/**
 * htcGrid
 * 
 * 基于jquery.datatables
 * 
 * 新增html设置：
 *       th标签属性:
 *         coltype:控制生成的headerfilter控件类型，控制cellEdit控件类型，控制内容对齐居中/居左/居右
 *            值范围:
 *                 checkbox:生成一列checkbox，并且在列头有全选checkbox
 *                 radio:生成一列radio button
 *                 sno:生成一个序号列
 *                 link:生成一个超链，被点击时会触发gridLinkHandler事件
 *                 text:生成的headerfilter控件和cellEdit控件为输入框
 *                 select:生成的headerfilter控件和cellEdit控件为下拉框
 *                 code:将列code值转换为value值显示在列中,并生成的headerfilter控件和cellEdit控件为下拉框
 *                 date/datetime/number/money：生成的headerfilter控件是一个范围控件，检索时提交的formdata中会有XXXStart和XXXEnd两个值
 *                 action:生成一个可包含多个按钮的列,每个按钮需要在子节点分别定义。
 *      name：控制后台返回数据与列的绑定关系
 *          特别说明：coltype==select且filter==true或cellEdit==true时,
 *              name设置为XXXXName，数据源中需要同时有XXXXCode属性，用于与headerfilter下拉框和cellEdit下拉框的value与单元格值作匹配
 *      filter:为true时，会在该列头生成headerfilter控件
 *      edit:当cellEdit==true时，为true的列可以被编辑
 *      tip:其值应该为数据源中的一列，该列为一个图片地址，含有tip的列在鼠标经过时，会以Tip的形式显示一个图片。
 *      link特有属性：
 *          useable：指定一个布尔型回调函数的名称，该函数返回值决定该Link是否可以被点击。
 *      code特有属性：
 *          code2name:将code转换为value所需的js对象的名字（通过<msk:codeMasterData>标签获得）
 *      select特有属性：
 *          url属性: 列类型为select时，可为生成的headerfilter下拉框和cellEdit下拉框设置数据源
 *      action特有属性：
 *          useable：指定一个布尔型回调函数的名称，该函数返回值决定该按钮是否被显示。
 *          icon：设定按钮图标的位置
 *          title: 设置按钮提示内容
 * 
 * 新增DataTables属性：
 *   linkHandler:function(rowdata,colname,row,col):表格内有Link列时，点击触发事件.
 *       参数说明: rowdata:被点击行数据对象
 *              colname:被点击列的name
 *              row:被点击单元格行号
 *              col:被点击单元格列号
 *   actionHandler:function(rowdata,coltype,row,col):表格内有action列时，点击触发事件.
 *       参数说明: rowdata:被点击行数据对象
 *              coltype:被点击列的coltype
 *              row:被点击单元格行号
 *              col:被点击单元格列号
 *   editCellOnBlurHandler:function(ctrl):编辑单元格失焦点处理前,触发事件
 *       参数说明: ctrl:即将失焦点的单元格编辑控件对象
 * 
 * 新增方法：
 *   addRow(data):cellEdit允许编辑时，用data数据在本页最后添加一行，data不传时添加一个新行
 *   removeRow(rowIndex):cellEdit允许编辑时，删除一行
 *   getChangeData():cellEdit允许编辑时，取得已经修改的数据（数据标志modifyStatus说明 0:无变化 1:新增 2:编辑 3:删除）
 *   getChoiceData():checkbox列存在时，取得checkbox被选中的行数据数组
 *   getChoiceByKey(keyArray):checkbox列存在，根据keyArray取得checkbox被选中的行的字符串数组，
 *           例：
 *                参数：[key1,key2,key3]
 *                结果：
 *                {
 *                   key1:[choiceStr1a,choiceStr2a,choiceStr3a],
 *                   key2:[choiceStr1b,choiceStr2b,choiceStr3b],
 *                   key3:[choiceStr1c,choiceStr2c,choiceStr3c]
 *                }
 *    getChoiceOne():radio列存在时，取得radio button选中的行数据对象，无选中行时，返回NULL
 *   
 *   作者：yanshaohui
 *   日期：2014/10/17制作
 */
/**
 * @param $
 */
(function($){
   $.fn.grid = function(option){
       
      option = option||{};

      var $that = $(this);
      var $table = null;//datatable对象      
      var $header = $(this).children('thead').find('th[coltype]');
      var $body = $(this).children('tbody');
      
      //是否显示新增按钮
      var $showAddBtn = $(this).attr("showAddBtn");
      var $isShowAddBtn = false;
      if($showAddBtn!=undefined||$showAddBtn=="true"){
    	  $isShowAddBtn = true;
      }
      
      
      var exportXls = (option.btnExport && option.btnExport.size()>0) || option.showExportBtn;

      var columnNames = [];//列名数组
      var columnTypes = [];//列类型数组
      var filters = [];//列可过滤数组
      var hasFilter = false;//生成检索条件头
      var columnEditables = [];//列可编辑标志数组
      var tableEditable = false;//生成编辑功能
      var tips = [];
      var maxlengths =[];
      var Fcss=[];
      var Ecss=[];
      var Tdcss=[];
      var allActions = [];

      //默认值
      var defaultValueArray = [];

      option.autoSearch = typeof(option.autoSearch)=='undefined' || option.autoSearch;
      option.fnPreDrawCallback = function(arg){
          arg.iDraw++;
          return option.autoSearch || arg.iDraw>1;
      };

      var rowData = {};//行数据对象
      
      /*********共通属性******/
      //冻结表头的设置（在页面大小不断调整时候效果不好，默认关闭）
//      option.scrollY = "450px";
//      option.scrollCollapse = true;
      option.bAutoWidth = false;
      var tableAction = $(this).attr("action");
      var ajaxSource = "";
      if(tableAction!=undefined){
          ajaxSource = tableAction;
      }else{
          ajaxSource = $(this).parents('form').attr('action');
      }
      
      option.ajaxSource = ajaxSource;  
      option.paginationType = "full_numbers";
      option.language = {
              "lengthMenu": "每页显示_MENU_条",
              "zeroRecords": "对不起，没有查询到记录！",
              "info": "从 _START_到 _END_ /共 _TOTAL_条数据",
              "infoEmpty": "",
              "infoFiltered": "(filtered from _MAX_ total records)",
              "showAll":"全部",
              "searchLabel":"查询",
              "exportLabel":"下载",
              "paginate": {
                  "first": "首页",
                  "previous": "前一页",
                  "next": "后一页",
                  "last": "尾页",
                  "pageNo": "第_PAGENO_页",
              },
      };

      option.paginate = typeof(option.paginate)=='undefined' || option.paginate;
      option.resultFooter = typeof(option.resultFooter)=='undefined' || option.resultFooter;
      option.iDisplayLength = option.iDisplayLength || 10;
      option.serverSide = true;
      option.bJQueryUI=false;
      option.bSort=false;
      option.bSortClasses=false;
      option.bProcessing= true;
      option.bLengthChange=false;
      option.lengthMenu =   [[10, 25, 50, 10000000], ["10", "25", "50", option.language.showAll]];
      option.bFilter=false;
      option.columns = [];
      option.columnDefs = option.columnDefs || [];
      option.needIdPrefix = option.needIdPrefix || false;
              
//      option.dom = '<"pagesize"l>t<ip>';
      option.dom = 't<"pagesize"ip>';
      /*************************************************/
      
      /*********为Grid设定绑定列***************************/
      $header.each(function(index){
            //列的Name属性，与同名列数据绑定
            var columnName = $(this).attr("name");
            var coltype = $(this).attr("coltype");
            var tip = $(this).attr("tip");
            var filter = ($(this).attr("filter")==="true");
            hasFilter = hasFilter || filter;
            var editable = ($(this).attr("edit")==="true");
            tableEditable = tableEditable || editable;
            var maxlength = $(this).attr("maxlength");
            var Fcs = $(this).attr("Fcss");
            var Ecs = $(this).attr("Ecss");
            var Tdcs = $(this).attr("Tdcss");
            
            columnTypes.push(coltype);
            columnNames.push(columnName);
            filters.push(filter);
            columnEditables.push(editable);
            tips.push(tip);
            if(maxlength){
                maxlengths.push(' maxlength="'+ maxlength +'" ');
            }else{
                maxlengths.push('');
            }
            
            if(Fcs){
                Fcss.push(' '+Fcs);
            }else{
                Fcss.push('');
            }
            
            if(Ecs){
                Ecss.push(' '+Ecs);
            }else{
                Ecss.push('');
            }
            
            if(Tdcs){
                Tdcss.push(' '+Tdcs);
            }else{
                Tdcss.push('');
            }
            
            if(columnName){
                rowData[columnName] = '';
                option.columns.push({"data":columnName});
            }else if(coltype==="checkbox"){
                var autoColumnName = "_checkbox_" + index;
                option.columns.push({"data":autoColumnName});
            }else if(coltype==="radio"){
                var autoColumnName = "_radio_" + index;
                option.columns.push({"data":autoColumnName});
            }else{
                option.columns.push({"data":null});
            }
      });
      /*************************************************/

      /*********设定特殊类型的列(根据th的coltype属性)*********/
      $header.each(function(index){
          var coltype = columnTypes[index];//$(this).attr("coltype");
          if(coltype==="sno"){
              option.columnDefs.push({
                targets: index,
                render: function(data, type, full,cell) {
                    //特殊处理：在调用fnUp()时，cell.row返回的是一个一维数组
                    var rowIndex = $.isArray(cell.row)?cell.row[0]:cell.row;
                    return cell.settings._iDisplayStart + rowIndex + 1;
                  }
              });
          }else if(coltype==="checkbox"){
              $(this).prepend('<input type="checkbox" class="mainCheckbox"/>');
              option.columnDefs.push({
                targets: index,
                render: function(data, type, full,cell) {
                    //特殊处理：在调用fnUp()时，cell.row返回的是一个一维数组
                    var rowIndex = $.isArray(cell.row)?cell.row[0]:cell.row;
                    if(data && data=='1'){
                        return '<input type="checkbox" class="subCheckbox" checked col="' + cell.col + '" row="' + rowIndex + '" />';    
                    }else{
                        return '<input type="checkbox" class="subCheckbox" col="' + cell.col + '" row="' + rowIndex + '" />';
                    }
                 } 
              });
          }else if(coltype==="radio"){
              var $redionOnclickName = option.redionOnclickName;
              var $onclickName = "";
              if($redionOnclickName != undefined && $redionOnclickName != ""){
                  $onclickName = 'onclick="'+$redionOnclickName+'(this)"';
              }
              option.columnDefs.push({
                targets: index,
                render: function(data, type, full,cell) {
                    //特殊处理：在调用fnUp()时，cell.row返回的是一个一维数组
                    var rowIndex = $.isArray(cell.row)?cell.row[0]:cell.row;
                    if(data && data=='1'){
                        return '<input type="radio" '+$onclickName+'  name="radio'+ cell.col +'" checked class="subRadio" col="' + cell.col + '" row="' + rowIndex + '" />';
                    }else{
                        return '<input type="radio" '+$onclickName+' name="radio'+ cell.col +'" class="subRadio" col="' + cell.col + '" row="' + rowIndex + '" />';
                    }
                 } 
              });
          }else if(coltype==="link"){
              var useable = $(this).attr('useable');
              var usefun = null;
              if(useable && option[useable] && $.isFunction(option[useable])){
                  usefun = option[useable];
              }else{
                  usefun = function(){return true;};
              }
              option.columnDefs.push({
                    targets: index,
                    render: function(data, type, full,cell) {
                    	if(data == null)
                    	{
                    		return data;
                    	}
                    	
                        var rowIndex = $.isArray(cell.row)?cell.row[0]:cell.row;
                        if(usefun(full,rowIndex))
                        {
                            return '<a class="gridLink" href="javascript:void(0);" col="' + cell.col + '">'+ data +'</a>';    
                        }else{
                            return data;
                        }
                    }
              });
          }else if(coltype==="code"){
              var code2name = $(this).attr("code2name");
              var datasrc = eval(code2name);
              option.columnDefs.push({
                  targets: index,
                  render: function(data, type, full,cell) {
                	  var dataText = "";
                      if(datasrc!=undefined && data!=undefined){
                    	  var codeKeys = (data + "").split(",");
                    	  $.each(codeKeys, function(i, v){
                              //if(datasrc["key_" + v] != undefined && datasrc["key_" + v] != null) {
                              if(datasrc["" + v] != undefined && datasrc["" + v] != null) {
                            	  if(dataText != "") {
                            		  dataText += ",";
                            	  }
                            	 // dataText += datasrc["key_" + v];
                                  dataText += datasrc["" + v];
                              }
                    	  });
                      }
                      if(dataText == ""){
                    	  dataText = data;
                      }
                      return dataText;
                  } 
              });
          }else if(coltype==="money"){
              option.columnDefs.push({
                  targets: index,
                  render: function(data, type, full,cell) {
                      return fmoney(data,2);
                  } 
              });
          }else if(coltype==="date"){
              option.columnDefs.push({
                  targets: index,
                  render: function(data, type, full,cell) {
                      if(data && data.length>10){
                        data = data.substr(0,10);  
                      }
                      return data;
                  } 
              });
          }else if(coltype==="datetime"){
              option.columnDefs.push({
                  targets: index,
                  render: function(data, type, full,cell) {
                      var retDateTime = new Date(data);
                      data = retDateTime.format('yyyy-MM-dd hh:mm:ss');
                      return data;
                  }
              });
          }else if(coltype==="action"){
              var actions = [];
              var useables = [];
              $(this).find('[coltype]').each(function(){
                  var coltype_sub = $(this).attr('coltype');
                  var useable_sub = $(this).attr('useable');
                  var pic_icon = $(this).attr('icon');
                  if(pic_icon == undefined || pic_icon == ""){
                      pic_icon = Main.contextPath + "/static/images/action/" + coltype_sub + ".png";
                  }
                  var title_sub = $(this).attr('title');
                  if(useable_sub && option[useable_sub] && $.isFunction(option[useable_sub])){
                      useables.push(option[useable_sub]);  
                  }else{
                      useables.push(function(){return true;});
                  }
                  actions.push('<a class="cellButton '+coltype_sub+'" title="'+title_sub+'" href="javascript:void(0);" col="{colIndex}"><img src="'+ pic_icon +'"/></a>');
              });
              
              allActions[index] = {"actions":actions,"useables":useables};
              
              option.columnDefs.push({
                    targets: index,
                    render: function(data, type, full,cell) {
                        var rowIndex = $.isArray(cell.row)?cell.row[0]:cell.row;
                        var rowaction = '';
                        for(var i=0;i<allActions[index].useables.length;i++){
                            if(allActions[index].useables[i](full,rowIndex)){
                                rowaction = rowaction + allActions[index].actions[i]; 
                            }else{
                                rowaction = rowaction + '<span class="cellSpan"></span>';
                            }
                        }
                        return rowaction.replace(/{colIndex}/g, cell.col);
                     } 
              });
          }
      });
      /*************************************************/

      /*********添加HeaderFilter和編輯控件******************/
      var filterHtml = '';
      var editHtml = '';
      var headHtml ='';
      $header.each(function(index){
        var filterOn = filters[index];
        var filterType = columnTypes[index];
        var editable = columnEditables[index];
        var columnName = columnNames[index];
        //Input Tag name def
        var $inputName = "filterMap['"+columnName+"']";
        var $selectName = "";
        var $dateStartName = "filterMap['"+columnName+"Start']";
        var $dateEndName = "filterMap['"+columnName+"End']";
        //columnName = "filterMap['"+columnName+"']";
        var maxlength = maxlengths[index];
        
        var Fcs = Fcss[index];
        var Ecs = Ecss[index];
        
        filterHtml = filterHtml + '<td class="' + filterType + '">';    
        
        if(filterType==="text" || filterType==="link"){
            if(filterOn){
            	// cookie中保存的条件
            	var valueHtml = '';
            	var defaultValue = $(this).attr("defaultValue");
            	if(null != defaultValue && '' != defaultValue && 'undefined' != defaultValue) {
            		valueHtml = ' value="' + defaultValue + '"';
            	}
                var cookieName = "hfilter." + $that.attr("id") + "." + $inputName;
            	var cookieValue = HGRID.hfilter.get(cookieName);
            	if(cookieValue){
            		valueHtml = ' value="' + cookieValue + '"';
            	}
                filterHtml = filterHtml + '<input type="text" name="' + $inputName +'" class="cellFilter cellFilterText' + Fcs +'"'+ maxlength + valueHtml + '/>';
            }
            if(editable){
                editHtml = editHtml + '<input type="text" name="' + columnName +'" class="cellEdit cellEditText' + Ecs +'"'+ maxlength +'/>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==="date"){
            if(filterOn){
            	// cookie中保存的条件
            	var valueHtmlStart = '';
            	var valueHtmlEnd = '';
            	var defaultValueStart = $(this).attr("defaultValueStart");
            	if(null != defaultValueStart && '' != defaultValueStart && 'undefined' != defaultValueStart) {
            		valueHtmlStart = ' value="' + defaultValueStart + '"';
            	}
            	var defaultValueEnd = $(this).attr("defaultValueEnd");
            	if(null != defaultValueEnd && '' != defaultValueEnd && 'undefined' != defaultValueEnd) {
            		valueHtmlEnd = ' value="' + defaultValueEnd + '"';
            	}
                var cookieNameStart = "hfilter." + $that.attr("id") + "." + columnName + "Start";
                var cookieNameEnd = "hfilter." + $that.attr("id") + "." + columnName + "End";
            	var cookieValueStart = HGRID.hfilter.get(cookieNameStart);
            	var cookieValueEnd = HGRID.hfilter.get(cookieNameEnd);
            	if(cookieValueStart){
            		valueHtmlStart = ' value="' + cookieValueStart + '"';
            	}
            	if(cookieValueEnd){
            		valueHtmlEnd = ' value="' + cookieValueEnd + '"';
            	}

                filterHtml = filterHtml + '<input type="text" name="' + $dateStartName +'Start" class="cellFilter cellFilterDate' + Fcs + '"' + valueHtmlStart + '/><input type="text" name="' + $dateEndName +'End" class="cellFilter cellFilterDate' + Fcs +'"' + valueHtmlEnd + '/>';
            }
            if(editable){
                editHtml = editHtml + '<input type="text" name="' + columnName +'" class="cellEdit cellEditDate' + Ecs +'"/>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==="datetime"){
            if(filterOn){
            	// cookie中保存的条件
            	var valueHtmlStart = '';
            	var valueHtmlEnd = '';
            	var defaultValueStart = $(this).attr("defaultValueStart");
            	if(null != defaultValueStart && '' != defaultValueStart && 'undefined' != defaultValueStart) {
            		valueHtmlStart = ' value="' + defaultValueStart + '"';
            	}
            	var defaultValueEnd = $(this).attr("defaultValueEnd");
            	if(null != defaultValueEnd && '' != defaultValueEnd && 'undefined' != defaultValueEnd) {
            		valueHtmlEnd = ' value="' + defaultValueEnd + '"';
            	}
                var cookieNameStart = "hfilter." + $that.attr("id") + "." + columnName + "Start";
                var cookieNameEnd = "hfilter." + $that.attr("id") + "." + columnName + "End";
            	var cookieValueStart = HGRID.hfilter.get(cookieNameStart);
            	var cookieValueEnd = HGRID.hfilter.get(cookieNameEnd);
            	if(cookieValueStart){
            		valueHtmlStart = ' value="' + cookieValueStart + '"';
            	}
            	if(cookieValueEnd){
            		valueHtmlEnd = ' value="' + cookieValueEnd + '"';
            	}
                filterHtml = filterHtml + '<input type="text" name="' + $dateStartName +'Start" class="cellFilter cellFilterDate"' + valueHtmlStart + '/><input type="text" name="' + $dateEndName +'" class="cellFilter cellFilterDate"' + valueHtmlEnd + '/>';
            }
//            if(editable){
//                editHtml = editHtml + '<input type="text" name="' + columnName +'" class="cellEdit cellEditDate"/>';
//            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==="money"){
            if(filterOn){
            	// cookie中保存的条件
            	var valueHtmlStart = '';
            	var valueHtmlEnd = '';
            	var defaultValueStart = $(this).attr("defaultValueStart");
            	if(null != defaultValueStart && '' != defaultValueStart && 'undefined' != defaultValueStart) {
            		valueHtmlStart = ' value="' + defaultValueStart + '"';
            	}
            	var defaultValueEnd = $(this).attr("defaultValueEnd");
            	if(null != defaultValueEnd && '' != defaultValueEnd && 'undefined' != defaultValueEnd) {
            		valueHtmlEnd = ' value="' + defaultValueEnd + '"';
            	}
                var cookieNameStart = "hfilter." + $that.attr("id") + "." + columnName + "Start";
                var cookieNameEnd = "hfilter." + $that.attr("id") + "." + columnName + "End";
            	var cookieValueStart = HGRID.hfilter.get(cookieNameStart);
            	var cookieValueEnd = HGRID.hfilter.get(cookieNameEnd);
            	if(cookieValueStart){
            		valueHtmlStart = ' value="' + cookieValueStart + '"';
            	}
            	if(cookieValueEnd){
            		valueHtmlEnd = ' value="' + cookieValueEnd + '"';
            	}
                filterHtml = filterHtml + '<input type="text" name="' + $inputName +'Start" class="cellFilter cellFilterMoney' + Fcs +'"'+ maxlength + valueHtmlStart + '/><input type="text" name="' + columnName +'End" class="cellFilter cellFilterMoney' + Fcs +'"'+ maxlength + valueHtmlEnd + '/>';
            }
            if(editable){
                editHtml = editHtml + '<input type="text" name="' + columnName +'" class="cellEdit cellEditMoney' + Ecs +'"'+ maxlength +'/>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==="number"){
            if(filterOn){
            	// cookie中保存的条件
            	var valueHtmlStart = '';
            	var valueHtmlEnd = '';
            	var defaultValueStart = $(this).attr("defaultValueStart");
            	if(null != defaultValueStart && '' != defaultValueStart && 'undefined' != defaultValueStart) {
            		valueHtmlStart = ' value="' + defaultValueStart + '"';
            	}
            	var defaultValueEnd = $(this).attr("defaultValueEnd");
            	if(null != defaultValueEnd && '' != defaultValueEnd && 'undefined' != defaultValueEnd) {
            		valueHtmlEnd = ' value="' + defaultValueEnd + '"';
            	}
                var cookieNameStart = "hfilter." + $that.attr("id") + "." + columnName + "Start";
                var cookieNameEnd = "hfilter." + $that.attr("id") + "." + columnName + "End";
            	var cookieValueStart = HGRID.hfilter.get(cookieNameStart);
            	var cookieValueEnd = HGRID.hfilter.get(cookieNameEnd);
            	if(cookieValueStart){
            		valueHtmlStart = ' value="' + cookieValueStart + '"';
            	}
            	if(cookieValueEnd){
            		valueHtmlEnd = ' value="' + cookieValueEnd + '"';
            	}
                filterHtml = filterHtml + '<input type="text" name="' + $inputName +'Start" class="cellFilter cellFilterNumber' + Fcs +'"'+ maxlength + valueHtmlStart + '/><input type="text" name="' + columnName +'End" class="cellFilter cellFilterNumber' + Fcs +'"'+ maxlength + valueHtmlEnd + '/>';
            }
            if(editable){
                editHtml = editHtml + '<input type="text" name="' + columnName +'" class="cellEdit cellEditNumber' + Ecs +'"'+ maxlength +'/>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==="select"){
            //生成下拉框(特：以Name结尾的列，其Filter下拉框的name属性被改为Code结尾)
            columnName = columnName.replace(/Name$/,"Code");
            
        	// cookie中保存的条件
            var gridId = $that.attr("id");
            var cookieName = "hfilter." + gridId + "." + $inputName;
        	var cookieValue = HGRID.hfilter.get(cookieName);
        	var cookieValueArray = undefined;
        	if(cookieValue != undefined){
        		cookieValueArray = (cookieValue + "").split(",");
        	}

        	var selectedCodes = ""; // 选择的值
            var select = $(this).find('select');
        	if(cookieValue != undefined){
        		// cookie 中存在时
        		selectedCodes = cookieValue;
	            if(select.size()>0){
	            	// <select>方式
	            	select.find('option').each(function(){
	            		// 将默认选中清除
	            		$(this).removeAttr("selected");
	            	});
            		$.each(cookieValueArray, function(i, v){
            			// 选中 与cookie中保存值一致的选项
    	            	select.find('option[value="' + v + '"]').each(function(){
    	            		$(this).attr("selected","selected");
    	            	});
	            	});
	            }
        	}else{
	            if(select.size()>0){
	            	// <select>方式
	            	select.find('option[selected=selected]').each(function(){
	            		if(selectedCodes != ""){
	            			selectedCodes += ",";
	            		}
	            		selectedCodes += $(this).val();
	            	});
	            }
        	}
            
            // 重建<select>
            if(filterOn){
            	var idPrefix = "";
            	if(option.needIdPrefix == true){
            		idPrefix = gridId+"_";
            	}
                    //TODO DataGrid Select 问题,无法用[]做为ID
                    filterHtml = filterHtml + '<input type="hidden" name="' + $inputName + '" id="' + idPrefix + columnName + '" value="' + selectedCodes + '" />';
                    filterHtml = filterHtml + '<select id="checkbox-' + idPrefix + columnName + '" name="checkbox-' + columnName + '" width="20px" class="cellFilter cellFilterSelect" multiple="multiple">';

                    //filterHtml = filterHtml + '<input type="hidden"  value="' + selectedCodes + '" />';
                    //filterHtml = filterHtml + '<select width="20px" class="cellFilter cellFilterSelect" multiple="multiple">';
            }
            if(editable){
                editHtml = editHtml + '<select name="' + columnName +'" class="cellEdit cellEditSelect">';    
            }
            
            if(select.size()>0){
            	// <select>方式
                var options = select.html();
                select.remove();
                if(filterOn){
                    filterHtml = filterHtml + options;
                }
                if(editable){
                    editHtml = editHtml + '<option></option>' + options;
                }
            }else{
                //options中配置下拉框的数据
                var url = $(this).attr("url");
                if(url){
                    //异步数据源的下拉框，要求th中配置数据源url
                    $("").postUrl(url,function(data){
                        var optionStr = '';
                        for(var i=0;i<data.length;i++){
                        	var checkedHtml = '';
                        	if(cookieValueArray){
                        		$.each(cookieValueArray, function(i, v){
                        			if(data[i].value == v){
                        				checkedHtml = ' selected="selected"';
                        			}
                        		});
                        	}
                            optionStr = optionStr + '<option value="' + data[i].key + '"' + checkedHtml + '>'+ data[i].value +'</option>';
                        }
                        if(optionStr){
                            $('select[name=' + columnName + '],select[name=checkbox-' + columnName + ']').prepend(optionStr);//.checkboxSelect();
                        }
                    });
                }
            }

            if(filterOn){
                filterHtml = filterHtml + '</select>';    
            }
            if(editable){
                editHtml = editHtml + '</select>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==='code'){
            
        	// cookie中保存的条件
            var gridId = $that.attr("id");
            var cookieName = "hfilter." + gridId + "." + $inputName;
        	var cookieValue = HGRID.hfilter.get(cookieName);
        	var cookieValueArray = undefined;
        	if(cookieValue){
        		cookieValueArray = (cookieValue + "").split(",");
        	}else{
        		cookieValue = '';
        	}

            // 重建<select>
            if(filterOn){
            	var idPrefix = "";
            	if(option.needIdPrefix == true){
            		idPrefix = gridId+"_";
            	}
                filterHtml = filterHtml + '<input type="hidden" name="'+$inputName+'" id="'+idPrefix+columnName+'" value="' + cookieValue + '" >';
                filterHtml = filterHtml + '<select id="checkbox-'+ idPrefix + columnName +'" name="checkbox-' + columnName +'" width="20px" class="cellFilter cellFilterSelect" multiple="multiple">';    
            }
            if(editable){
                var blank = ($(this).attr("blank")==="true");
                editHtml = editHtml + '<select name="' + columnName +'" class="cellEdit cellEditSelect">';
                if(blank){
                     editHtml = editHtml + '<option value=""></option>';
                }
            }
            
            var code2name = $(this).attr("code2name");
            var codes = eval(code2name);
            for(var key in codes){
            	//var codeValue = key.replace('key_','');
                var codeValue = key;
                if(filterOn){
                	var checkedHtml = '';
                	if(cookieValueArray){
                		$.each(cookieValueArray, function(i, v){
                			if(codeValue == v){
                				checkedHtml = ' selected="selected"';
                			}
                		});
                	}
                    filterHtml = filterHtml + '<option value="' + codeValue + '"' + checkedHtml + '>'+ codes[key] +'</option>';
                }
                if(editable){
                    editHtml = editHtml + '<option value="' + codeValue + '">'+ codes[key] +'</option>';
                }
            }
            if(filterOn){
                filterHtml = filterHtml + '</select>';    
            }
            if(editable){
                editHtml = editHtml + '</select>';
            }
            if(exportXls){
                headHtml = headHtml + '<input type="hidden" name="headers" value="' + $(this).text() + '"></input>';
            }
        }else if(filterType==='action'){
//            //生成检索按钮
//            filterHtml = filterHtml + '<a class="gridSearch" href="javascript:void(0);">'+ option.language.searchLabel +'</a>';
        }
        
        if(index==filters.length-1){
            //生成检索按钮
            filterHtml = filterHtml + '<a class="gridSearch h-button" href="javascript:void(0);" title="' + option.language.searchLabel + '">'+ option.language.searchLabel +'</a>';
            
            if(option.showExportBtn){
                //生成导出
                filterHtml = filterHtml + '<a class="gridExport h-button" href="javascript:void(0);" title="' + option.language.exportLabel + '">'+ option.language.exportLabel +'</a>';
            }
        }
        
        filterHtml = filterHtml + '</td>';
      });
      
      if(hasFilter){
          $(this).prepend('<thead class="filterHeader"><tr>' + filterHtml + '</tr></thead>');  
      }
      if(exportXls){
          $(this).after(headHtml);//.wrapAll('<form action="'+ option.ajaxSource +'" method="post"></form>');
      }
      /*********Grid内各控件事件***************************/
      //有checkbox列时，为checkbox列绑定全选处理
      $header.each(function(i){
//            $(this).find('input.mainCheckbox').click(function(){
            $(this).on('click','input.mainCheckbox',function(){
                var all = this.checked;
                $body.find('tr').find('td:eq('+ i +')').find('input.subCheckbox:enabled').each(function(){
                    $(this)[0].checked = all; 
                });
            });
      });
      
      $body.on('click','input.subCheckbox',function(){
          var col = $(this).parents('tr').children('td').index($(this).parent('td'));
          var $ckbs = $body.find('tr').find('td:eq(' + col + ')').find('input.subCheckbox');
          //$header.find('tr')
          //$titleHeader.find('th:eq(' + col + ')')
          $($header[col]).find('input.mainCheckbox').each(function(){
              $(this)[0].checked = ($ckbs.size() == $ckbs.filter(':checked').size());
          });
      });
      
      var fxRowCallback = option.fnRowCallback;
      option.fnRowCallback = function(tr,data){
          
          //检索后，为每个单元格设定css
          for(var i=0;i<columnTypes.length;i++){
              $(tr).find('td:eq('+ i +')')
                  .addClass(columnTypes[i]) // 列类型css
                  .addClass(Tdcss[i])
                  .addClass(columnEditables[i]?'editable':'') //列可编辑状态css
                  .attr('tip',data[tips[i]]);  //列Tip值设定
          }
          
          if(fxRowCallback){
              fxRowCallback(tr,data);
          }
      };
      
      if(option.scrollCollapse){
          var sizeChange = function(){
                var $firstRow = $body.find('tr:eq(0)');
                  if($firstRow.size()>0){
                      var tablewidth = 0;
                      $header.each(function(index){
                          var cellwidth = $firstRow.find('td:eq("' + index + '")').width();
                          tablewidth= tablewidth + cellwidth + 10;
                          $(this).width(cellwidth);
                      });
                      $header.parents('tr').width(tablewidth);
                      $header.parents('table').width(tablewidth);
                  }
            };
            
            $(window).resize(function(){
                lazyDosomething(sizeChange,window,200);
            });
      }

      var fxDrawCallback = option.fnDrawCallback;
      option.fnDrawCallback = function(){
          if(fxDrawCallback){
              fxDrawCallback();
          }
          
          $('a.paginate_button.first.disabled').html('<img src="' + Main.contextPath + '/static/images/page/page_first_disable.png"/>');
          $('a.paginate_button.previous.disabled').html('<img src="' + Main.contextPath + '/static/images/page/page_prev_disable.png"/>');
          $('a.paginate_button.next.disabled').html('<img src="' + Main.contextPath + '/static/images/page/page_next_disable.png"/>');
          $('a.paginate_button.last.disabled').html('<img src="' + Main.contextPath + '/static/images/page/page_last_disable.png"/>');
          
          $('a.paginate_button.first:not(.disabled)').html('<img src="' + Main.contextPath + '/static/images/page/page_first.png"/>');
          $('a.paginate_button.previous:not(.disabled)').html('<img src="' + Main.contextPath + '/static/images/page/page_prev.png"/>');
          $('a.paginate_button.next:not(.disabled)').html('<img src="' + Main.contextPath + '/static/images/page/page_next.png"/>');
          $('a.paginate_button.last:not(.disabled)').html('<img src="' + Main.contextPath + '/static/images/page/page_last.png"/>');
          
          // tooltip
          $('a.paginate_button:not(.disabled)').each(function(){
        	  var $this = $(this);
        	  switch(true){
        	  case $this.hasClass("first"):
        		  $this.attr("title", option.language.paginate.first);
        		  break;
        	  case $this.hasClass("previous"):
        		  $this.attr("title", option.language.paginate.previous);
        		  break;
        	  case $this.hasClass("next"):
        		  $this.attr("title", option.language.paginate.next);
        		  break;
        	  case $this.hasClass("last"):
        		  $this.attr("title", option.language.paginate.last);
        		  break;
        	  default :
        		  var pageNo = $this.text();
        	      var pageNoTitle = option.language.paginate.pageNo.replace(/_PAGENO_/g, pageNo);
    		      $this.attr("title", pageNoTitle);
        	  }
          });
          
          //检索后，全选checkbox不能被选中
          $header.find('input.mainCheckbox').each(function(){
              $(this)[0].checked = false;
          });

          //固定表头时的一些特殊设置
          if(option.scrollCollapse){
              $table.find('thead.filterHeader').remove();
              
              var $firstRow = $body.find('tr:eq(0)');
              if($firstRow.size()>0){
                  $header.each(function(index){
                      var cellwidth = $(this).width();
                      $firstRow.find('td:eq("' + index + '")').width(cellwidth);
                  });
              }
          }

          $body.tooltip({
              items: "td[tip]:not(:empty)",
              content: function() {
                var element = $(this);
                var tipval = element.attr('tip');
                
                return "<img class='map' src='"+ Main.contextPath + tipval + "?" +
                "zoom=11&size=350x350&maptype=terrain&sensor=false&center=''/>";
              }
          });
          
          // 如果是group-accordion内的grid，刷新group-accordion
          $table.parents("div.group-accordion").each(function(){
        	  $(this).accordion("refresh");
          });
          
          // filter中下拉框宽度的设置
          $table.find("thead.filterHeader > tr > td.select > span.ui-selectmenu-button, thead.filterHeader > tr > td.code > span.ui-selectmenu-button").each(function(){
        	  var width = $(this).parent("td").width();
        	  if(width != undefined && width > 2){
        		  width = width - 2;
        	  }
        	  if(width > 0){
        	      $(this).width(width);
        	  } else {
        	      $(this).width("98%");
        	  }
          });
      };

      $body.on('click','a.gridLink',function(){
          if(option.linkHandler && $.isFunction(option.linkHandler)){
//              var row = $(this).attr('row');
              var col = $(this).attr('col');
              var $tr = $(this).parent('td').parent('tr');
              var $trs = $tr.parent('tbody').children('tr');
              row = $trs.index($tr);

              option.linkHandler.call($table
                      ,$table.fnGetData(row)
                      ,columnNames[col]
                        ,row
                        ,col);
          }
      });

      $body.on('click','a.cellButton',function(){
          if(option.actionHandler && $.isFunction(option.actionHandler)){
//              var row = $(this).attr('row');
              var col = $(this).attr('col');
              var $tr = $(this).parent('td').parent('tr');
              var $trs = $tr.parent('tbody').children('tr');
              row = $trs.index($tr);
              
              option.actionHandler.call($table
                      ,$table.fnGetData(row)
                      ,this.className.replace(/cellButton /,'')
                        ,row
                        ,col);
          }
      });
      
      /*************************************************/

      /*********修改数据获取方式****************************/
      option.fnServerData = function(sSource,aoData,fnCallback ){
          if($table && option.scrollCollapse){
              $table.find('thead.filterHeader').remove();
          }
        
          var formdata = {};
    	  var cookieNamePrefix = "hfilter." + $that.attr("id") + ".";
          
          //自上次检索后,检索条件是否变更过
          var conditionChanged = false;
          //Filter检索条件收集
          if($that){              
              var params = $that.parents('form').serializeArray();
              for(var i=0;i<params.length;i++){
                 formdata[params[i].name] = params[i].value;
              }
              
              // 保存文本框的条件到cookie
              $that.children('thead').find('input.cellFilter').each(function(){
                  HGRID.hfilter.add(cookieNamePrefix+this.name, this.value);
              });
              // 保存文本框的条件到cookie
              $that.children('thead').find('select.cellFilter').prev('input').each(function(){
                  HGRID.hfilter.add(cookieNamePrefix+this.name, this.value);
              });
              
              //自上次检索后,如果检索条件变更过,则要从第一页开始显示
              if($that.params != undefined && $that.params!=null && $.isArray($that.params)){
                  for(var i=0;i<$that.params.length;i++){
                      if( params[i] !=null && $that.params[i].value != params[i].value){
                          conditionChanged = true;
                          break;
                      }
                  }
              }
             $that.params = params;
          }
          
          //自上次检索后,如果检索条件变更过,则要从第一页开始显示
          if(conditionChanged){
              $table.fnClearTable(true);
              return;
          }
          
          //Table原生条件收集(开始行号，页大小等)
          for(var i=0;i<aoData.length;i++){
              if("iDisplayLength" == aoData[i].name){
                  formdata.pageSize = aoData[i].value;
              }else if("iDisplayStart" == aoData[i].name){
            	  formdata.startPos = aoData[i].value;
                  // 保存条件到cookie
            	  HGRID.hfilter.add(cookieNamePrefix+"iDisplayStart", aoData[i].value);
              }
          }
        
          if(formdata.pageSize==-1){
              formdata.paging = false;
          }else{
              formdata.paging = true;  
          }
          
          if((!option.fxBeforeRequest) || option.fxBeforeRequest(sSource,formdata,fnCallback)){
              $('#main-content').postUrl(sSource,formdata,function(data){
                  if((!option.fxAfterRequest) || option.fxAfterRequest(data)){
                      data.draw = 0;
                      data.recordsFiltered = data.recordsTotal;
                      fnCallback(data);
                  }
              },{refreshHtml:false});
          }
      };
      /*************************************************/

      /***********生成DataTables*************************/
      $table = $(this).dataTable(option);      
      /*************************************************/

      /*******************header filter控件初始化******************/
      var $filterHeader = null;
      if(option.scrollCollapse){
          $filterHeader = $(this).parents('div.dataTables_scroll').find('div.dataTables_scrollHead').find('thead.filterHeader');  
      }else{
          $filterHeader = $(this).find('thead.filterHeader');  
      }
      
      //Filter区存在jQueryUI日期控件
      $filterHeader.find('input.cellFilterDate').datepicker({
        showButtonPanel: true,
        dateFormat:'yy-mm-dd',
        changeMonth: true,
        changeYear: true,
        //showOtherMonths: true,
        //selectOtherMonths: true,
      });
      // 清空错误日期
      $filterHeader.find('input.cellFilterDate').change(function(){
    	  var inputValue = $(this).val();
    	  if(inputValue != null && inputValue != ""){
//    		  if(/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/.test( inputValue ) === false){
    		  if(new Date( Date.parse(inputValue.replace(/-/g,"/")) ).format("yyyy-MM-dd") != inputValue){
    			  $(this).val("");
    		  }
    	  }
      });
      
      $filterHeader.find('select.cellFilterSelect').checkboxSelect();

      stopInputNumber($filterHeader.find('input.cellFilterNumber'));
      stopInputNumber($filterHeader.find('input.cellFilterMoney'));
      
      $filterHeader.on('keydown', 'input,select',function(evt){
          if(evt.keyCode == 13 || evt.keyCode == 37 || evt.keyCode==39)
          {
//              var $comps = $(this).parents('tr').find('input,select');
//              var count = $comps.size();
//              var index = $comps.index($(this));
              
              $('.hasDatepicker').datepicker('hide');
              
             switch(evt.keyCode){
                  case 13:    // Enter
                	  if($(this).attr("type") == "text"){
                          $filterHeader.find('a.gridSearch').click();
                	  }
                      break;
// Mantis:0191441 不要此功能  case 37:    // ←
//                    if(index>0){
//                          $($comps.get(index-1)).focus();
//                      }
//                    break;
//                case 39:    // →
//                    if(index<count){
//                          $($comps.get(index+1)).focus();
//                      }
//                    break;
//                default:
//                    return;
              }
          }
      });
      
      //Filter区存在检索按钮
      $filterHeader.find('a.gridSearch').button().click(function(){
          $table.fnDraw();
      });
      
      $filterHeader.find('a.gridExport').button().click(function(){
          $table.parents('form').attr('method','POST').submit();
      });
      
      if(exportXls && option.btnExport){
          option.btnExport.click(function(){
              $table.parents('form').attr('method','POST').submit();
          });
      }
      /*************************************************/
      /***********当Cell可以编辑时，添加编辑功能***************/
      if(tableEditable){
          var $editComps = $('<div style="display:none;">' + editHtml + '</div>').insertAfter($(this).parents('form'));
          
          //单元格编辑完毕方法
          var cellEditComplete = function($comp){
              
              if(option.editCellOnBlurHandler && $.isFunction(option.editCellOnBlurHandler)){
                  option.editCellOnBlurHandler($comp);
              }
              
              $comp.unbind('blur');
              
              var isSelect = $comp.is('select');
              var text = null;
              var val = null;
              if(isSelect){
                  text = $comp.find("option:selected").text(); 
                  val = $comp.val();
              }else{
                  val = text = $comp.val();
                  
              }
              var $td = $comp.parent();
              if(text!=$td.data('oldText')){
                  var $tr = $td.parent();
                  var $trs = $tr.parent();
                  var colIndex = $tr.children().index($td);
                  var rowIndex = $trs.children().index($tr);
                  var rowData = $table.fnGetData(rowIndex);
                  var colName = columnNames[colIndex];
                  //修改数据标志（新增、删除、编辑状态时，不变）
                  if(typeof(rowData.modifyStatus)=='undefined'){
                      rowData.modifyStatus=2;
                  }
                  //修改行数据
                  rowData[colName] = text;
                  if(isSelect){
                      rowData[colName.replace(/Name$/,"Code")] = val;
                  }
                  // checkbox的页面数据
                  $tr.find("td.checkbox input.subCheckbox").each(function(){
                      var checkboxCol = $(this).attr("col");
                      var checkboxColName = "_checkbox_" + checkboxCol;
                      if($(this).is(":checked")){
                          rowData[checkboxColName] = 1;
                      }else{
                          delete rowData[checkboxColName];
                      }
                  });
                  // radio的页面数据
                  $tr.find("td.radio input.subRadio").each(function(){
                      var radioCol = $(this).attr("col");
                      var radioColName = "_radio_" + radioCol;
                      if($(this).is(":checked")){
                          rowData[radioColName] = 1;
                      }else{
                          delete rowData[radioColName];
                      }
                  });
                  $table.fnUpdate(rowData,rowIndex,undefined,false,false);
                  $tr.addClass('rowEdit');
              }
              $comp.appendTo($editComps); 
              //修改显示数据
              $td.text(text);
          };

          //将传入单元格变成编辑状态
          var cellEditMode = function($td,col){
              //当前单元格是否可以编辑
              if(columnEditables[col] && columnNames[col]){
                  //保存原值
                  var text = $td.text();
                  $td.data('oldText',text);
                  $td.text('');
                  
                  //编辑控件取得
                  var $editComp = $editComps.children('input[name="'+ columnNames[col] +'"],select[name="'+ columnNames[col].replace(/Name$/,"Code") +'"]');
                  //编辑控件添加到td之内
                  $editComp.appendTo($td);
                  //为编辑控件赋值
                  if($editComp.is('select')){
                      $editComp.find("option").each(function(){
                          if($(this).text()==text){
                              $(this).attr('selected','selected');
                          }else{
                              $(this).removeAttr('selected');
                          }
                      }); 
                  }else{
                      $editComp.val(text);
                  }
                  //编辑控件获得光标
                  $editComp.focus();
                  $('div.ui-tooltip').hide();
                  
                  //编辑控件绑定鼠标离开事件
                  if(!$editComp.is('input.cellEditDate')){
                      $editComp.unbind('blur');
                      $editComp.bind('blur',function(){
                          cellEditComplete($(this));
                      });
                  }
              }
          };
          
          //Warning:不要删，暂时屏蔽功能
          //编辑光标迁移到下一个单元格
//          var gotoNextCell = function($curr,row,col){
//              if($curr.is('input.cellEditDate')){
//                  $curr.datepicker('hide');
//              }else{
//                  cellEditComplete($curr);
//              }
//              var $td = $body.find('tr:eq('+ row +')').find('td:eq('+col+')');
//              cellEditMode($td,col);
//          };
          
          //单元格编辑完毕(IE9+不支持,在click事件内每次注册blur事件)
//          $body.on('focusout','input.cellEdit:not(.cellEditDate),select.cellEdit',function(){  
//              cellEditComplete($(this));
//          });
                    
          //单元格编辑完毕（日期控件需要的特殊处理，选择面板close时为选择完毕）
          $editComps.find('input.cellEditDate').datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            //showOtherMonths: true,
            //selectOtherMonths: true,
            onClose:function(){
                cellEditComplete($(this));
            }
          });
          
          //单元格被点击时，进入编辑状态
          $body.on('click','td:not(:has(input,select)).editable',function(){
              var col = $(this).parent().children().index(this);
              cellEditMode($(this),col);
          });
          
          //Warning:不要删，暂时屏蔽功能
          //单元格编辑时，上下左右键功能
//          $body.on('keydown','input.cellEdit,select.cellEdit',function(evt){
//              if(evt.keyCode == 13 || evt.keyCode == 37 || evt.keyCode==38|| evt.keyCode == 39 || evt.keyCode==40){
//                  var $parentTD = $(this).parents('td');
//                  var $parentTR = $parentTD.parents('tr');
//                  var $parentBODY =$parentTR.parents('tbody');
//                  var col = $parentTR.children().index($parentTD);
//                  var row = $parentBODY.children().index($parentTR);
//                  var colCnt = $parentTR.children().size();
//                  var rowCnt = $parentBODY.children().size();
//                  //当前单元格在整个表格中的位置
//                  var cellIndex = colCnt * row + col;
//                  var cellCnt = colCnt * rowCnt;
//                  
//                  switch(evt.keyCode){
//                      case 37:    // ←
//                          do{
//                              cellIndex--;
//                          }while(cellIndex>=0 && !columnEditables[cellIndex%colCnt]);    
//                          break;
//                      case 39:    // →
//                      case 13:    // Enter
//                          do{
//                              cellIndex++;
//                          }while(cellIndex<cellCnt && !columnEditables[cellIndex%colCnt]);
//                          break;
//                      case 38:    // ↑
//                          do{
//                              cellIndex-=colCnt;
//                          }while(cellIndex>=0 && !columnEditables[cellIndex%colCnt]);
//                          break;
//                    case 40:    // ↓
//                        do{
//                            cellIndex+=colCnt;
//                          }while(cellIndex<cellCnt && !columnEditables[cellIndex%colCnt]);
//                          break;
//                  }
//                  
//                  if(cellIndex>=0 && cellIndex<cellCnt){
//                      gotoNextCell($(this),Math.floor(cellIndex/colCnt),cellIndex%colCnt);
//                  }
//              }
//          });
      }
      /*************************************************/
      
      /*********新增一行的接口（cellEdit==true时才有意义）*****/
//      $table.addRow = function(){alert("Table的cellEdit属性为false,不支持编辑！");};
//      if(tableEditable){
          
          function emptyRowData(){
//              this.isNewRow = true;
              this.modifyStatus = 1;//数据标志： 0:无变化 1:新增 2:编辑 3:删除
          }
          emptyRowData.prototype = rowData;

          $table.addRow = function(data){
              
              var addRowIndex = $table.fnGetData().length;//option.iDisplayLength-1;
              data = data || new emptyRowData();
              data.modifyStatus = 1;
              $table.fnAddData(data,false);
              var rowHtml = '<tr role="row" class="rowAdd '+ (addRowIndex%2==1?'even':'odd') + '">';
              
              //如果加之前是0条记录，需要先把0条的message那行给去除
              if ($body.find("tr:eq(0)").find("td:eq(0)").attr("class") == "dataTables_empty") {
            	  $body.find("tr:eq(0)").remove();
              }
              
              $header.each(function(index){

                  var coltype = columnTypes[index];
                  // edit by gaojian begin
				  var editItem = columnEditables[index];

				  if (editItem) {
						rowHtml = rowHtml + '<td class="' + coltype
								+ ' editable",>';
				  } else {
						rowHtml = rowHtml + '<td class="' + coltype + '">';
				  }
				  // rowHtml = rowHtml + '<td class="'+ coltype +'">';
				  // edit by gaojian end
                  if(coltype==="sno"){
                      rowHtml = rowHtml + (addRowIndex+1);
                  }else if(coltype==="checkbox"){
                	    // edit by gaojian begin
						var checkValue = data[$(this).attr("name")];
						if (checkValue && checkValue == '1') {
							rowHtml = rowHtml
									+ '<input type="checkbox" class="subCheckbox" checked col="'
									+ index + '" row="' + addRowIndex + '" />';
						} else {
							rowHtml = rowHtml
									+ '<input type="checkbox" class="subCheckbox" col="'
									+ index + '" row="' + addRowIndex + '" />';
						}
						// rowHtml = rowHtml +'<input type="checkbox"
						// class="subCheckbox" col="' + index + '" />';
						// edit by gaojian end
                  }else if(coltype==="radio"){
                      rowHtml = rowHtml +'<input type="radio" name="radio'+ index +'" class="subRadio" col="' + index + '" row="' + addRowIndex + '"/>';
                  }
                  else if(coltype==="action"){
                      
                      var rowaction = '';
                      for(var i=0;i<allActions[index].actions.length;i++){
                          rowaction = rowaction + allActions[index].actions[i]; 
                      }
                      rowHtml = rowHtml + rowaction.replace(/{colIndex}/g, index);

//                      var actions = '';
////                      var useables = [];
//                      $(this).find('[coltype]').each(function(){
//                          var coltype_sub = $(this).attr('coltype');
//                          var pic_icon = $(this).attr('icon');
//                          if(pic_icon == undefined || pic_icon == ""){
//                              pic_icon = Main.contextPath + "/images/action/" + coltype_sub + ".png";
//                          }
////                          var useable_sub = $(this).attr('useable');
////                          if(useable_sub && option[useable_sub]){
////                              useables.push(option[useable_sub]);  
////                          }else{
////                              useables.push(function(){return true;});
////                          }
//                          actions = actions + ('<a class="cellButton '+coltype_sub+'" href="javascript:void(0);" col="'+index+'"><img src="'+ pic_icon +'"/></a>');          
//                      });
//                      rowHtml = rowHtml +actions;
                  }
                    else{
                      //列的Name属性，与同名列数据绑定
                      var columnName = $(this).attr("name");
                      rowHtml = rowHtml + data[columnName];
                  }
                  
                  rowHtml = rowHtml + '</td>';
              });
              rowHtml = rowHtml + '</tr>';
              $body.append(rowHtml);
          };
//      }
      /*************************************************/
      
      /*********删除一行的接口（cellEdit==true时才有意义）*****/
//      $table.removeRow = function(){alert("Table的cellEdit属性为false,不支持编辑！");};
//      if(tableEditable){
          $table.removeRow = function(rowIndex){
              var $row = $body.children('tr:eq('+ rowIndex +')');
              $row.addClass('rowDelete');
              var rowData = $table.fnGetData(rowIndex);
              
              if(typeof(rowData.modifyStatus)=='undefined'){
                  rowData.modifyStatus = 3;//原项目删除
              }else if(rowData.modifyStatus==1){
                  rowData.modifyStatus = 4;//新增项目删除
              }if(rowData.modifyStatus==2){
                  rowData.modifyStatus = 3;//原项目编辑后删除
              }
          };
//      }
      
       // add by gaojian begin
  	   $table.deleteRow = function(rowIndex) {
  			var $row = $body.children('tr:eq(' + rowIndex + ')');
  			if ($row) {
  				$table.fnDeleteRow(rowIndex, null, false);
  				$row.remove();
  				// change cssstyle
  				$table.find('tbody>tr>td.sno').each(function(index) {
  					$(this).text(index + 1);
  				});
  				$table.find("tbody tr:even").removeClass("even")
  						.addClass("odd");
  				$table.find("tbody tr:odd").removeClass("odd").addClass("even");
  			}
  		};
  		// add by gaojian end
          
      /*************************************************/
      
      /*********获取变更数据的接口（cellEdit==true时才有意义）**/
//      $table.getChangeData = function(){return [];};
//      if(tableEditable){
          $table.getChangeData = function(){
            var result = [];
            var data = $table.fnGetData();
            for(var i=0;i<data.length;i++){
                var row = data[i];
//                if(row.modifyStatus==1 || row.modifyStatus==2 || (row.modifyStatus==3 && !row.isNewRow)){
                if(row.modifyStatus==1 || row.modifyStatus==2 || row.modifyStatus==3){
                    result.push(row);
                }
            }
            return result;
//          };
      };
      /***************************************************/
      
      /*********获取选中数据的接口（存在checkbox列时才有意义）******/
      //获取checkbox选中行的数据对象数组
      $table.getChoiceData = function(){return [];};
      //获取checkbox没有选中的行的数据对象数组
      $table.getUnChoiceData = function(){return [];};
      //获取checkbox选中行的关键字值数组,可支持多个关键字
      $table.getChoiceByKey = function(){return [];};
      //获取radio选中行的对象
      $table.getChoiceOne = function(){return null;};
      
      $header.each(function(colIndex){
          var coltype = columnTypes[colIndex];
          if(coltype==="checkbox"){
              $table.getChoiceData = function(){
                  var result = [];
                  $body.find('tr').find('td:eq('+ colIndex +')').find('input.subCheckbox').each(function(rowIndex){
                      if($(this).is(':checked')){
                    	  var rowNo = $(this).attr('row');
                          result.push($table.fnGetData(rowNo));  
                      }
                  });
                  return result;
              };
              
              $table.getUnChoiceData = function(){
                  var result = [];
                  $body.find('tr').find('td:eq('+ colIndex +')').find('input.subCheckbox').each(function(rowIndex){
                      if(!$(this).is(':checked')){
                    	  var rowNo = $(this).attr('row');
                          result.push($table.fnGetData(rowNo));  
                      }
                  });
                  return result;
              };
              
              $table.getChoiceByKey = function(keys){
                  var result = {};
                 
                  for(var i=0;i<keys.length;i++){
                      result[keys[i]] = [];
                  }

                  $body.find('tr').find('td:eq('+ colIndex +')').find('input.subCheckbox').each(function(rowIndex){
                      if($(this).is(':checked')){
                    	  var rowNo = $(this).attr('row');
                          var choice = $table.fnGetData(rowNo);
                          for(var i=0;i<keys.length;i++){
                              result[keys[i]].push(choice[keys[i]]);
                          }
                      }
                  });
                  return result;
              };
          }else if(coltype==="radio"){
        	  var result = undefined;
              $table.getChoiceOne = function(){
                  $body.find('tr').find('td:eq('+ colIndex +')').find('input.subRadio').each(function(){
                      if($(this).is(':checked')){
                    	  var rowNo = $(this).attr('row');
                    	  result = $table.fnGetData(rowNo);
                      }
                  });
                  return result;
              };
          }
      });
      /***************************************************/
      
      if(!option.resultFooter){
          $(this).parent('div.dataTables_wrapper').find('div.pagesize').remove();
      }
      
      return $table;
   };
})(jQuery);

function defaultAddCallBack(){
	alert("默认新增按钮函数,因为你没有编写新增函数所以,该方法没有任何代码执行,请在当前Table中添加addCallback属性和编写Callback函数");
}


function lazyDosomething(method,context,delay){
    clearTimeout(method.tId);
    method.tId = setTimeout(function(){
        method.call(context);
    },delay);
}

function stopInputNumber($input){
    $input.keydown(function(evt){
        //小数点和负号暂不支持
        //|| evt.keyCode==189|| evt.keyCode==109|| evt.keyCode==110|| evt.keyCode==190
        if(evt.keyCode == 13 || evt.keyCode == 37 || evt.keyCode==39 || evt.keyCode==8|| evt.keyCode==9){
            return true;
        }
        if(evt.keyCode<48 || (evt.keyCode>57 && evt.keyCode<96) ||evt.keyCode>105){
            return false;
        }
    });
    
    $input.keyup(function(evt){
        //小数点和负号暂不支持
        //|| evt.keyCode==189|| evt.keyCode==109|| evt.keyCode==110|| evt.keyCode==190
        if(evt.keyCode == 13 || evt.keyCode == 37 || evt.keyCode==39 || evt.keyCode==9){
            return true;
        }
        
//        if(evt.keyCode<48 || (evt.keyCode>57 && evt.keyCode<96) ||evt.keyCode>105){
//            return false;
//        }
        
        var val = $(this).val().replace(/,/g,'');
        if(val!=''){
            val = format_number(val); //parseInt(val).toLocaleString();
        }
        $(this).val(val);
    });
}

function format_number(n){
       var b=parseInt(n).toString();
       var len=b.length;
       if(len<=3){return b;}
       var r=len%3;
       return r>0?b.slice(0,r)+","+b.slice(r,len).match(/\d{3}/g).join(","):b.slice(r,len).match(/\d{3}/g).join(",");
}
function fmoney(s, n) {
    if(s=='' || s==null){
        return s;
    }
    // + 或 - 开头
    var pre = "";
    var num = s + "";
    if(num.indexOf("+")==0 || num.indexOf("-")==0){
    	pre = num.substr(0, 1);
    	num = num.substr(1, num.length-1);
    }
    
    n = n > 0 && n <= 20 ? n : 2;
    num = parseFloat((num).replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    var numArray = num.split(".");
    var l = numArray[0].split("").reverse(), r = numArray[1];
    t = "";
    for (var i = 0; i < l.length; i++) {
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
    }
    return pre + t.split("").reverse().join("") + "." + r;
} 

var HGRID = {
	/**
	 * 保存Grid的检索条件
	 */
	hfilter : {
		// Grid的过滤条件
		filters : {},
		// 根据key获得保存的条件值
		get : function(key){
			if(HGRID.hfilter.filters){
		        return HGRID.hfilter.filters[key];
			}else{
				return undefined;
			}
		},
		// 保存条件值
		add : function(key, value){
			if(HGRID.hfilter.filters == undefined){
				HGRID.hfilter.filters = {};
			}
			HGRID.hfilter.filters[key] = value;
		},
		// 清除所有保存的条件
		clear : function(){
			if(HGRID.hfilter.filters){
			    HGRID.hfilter.filters = {};
			}
		},
	},
};