/**
 * Utils JS
 */
var MainUtils = {
    uploadProcessListen : function(taskId,message){
        $.ajax(
            {
                method:"GET",
                url:Main.contextPath+"/comm/excel/upload/process/listen/"+taskId,
                data:{timeout:3000},
                dataType:"json",
                cache:false,
                beforeSend:function(xhr){
                    MainUtils.showLoadingMask(message);
                },
                success:function(data){
                    console.info(data);

                    if(data==undefined||data==""){
                        HDF.closeLoadingMask();
                        return;
                    }

                    if(data.indexOf("错误信息") >= 0){
                        $.alertMessage.info(data);
                        HDF.closeLoadingMask();
                        return;
                    }

                    HDF.closeLoadingMask();
                    MainUtils.uploadProcessListen(taskId,data);
                },
                error:function(){

                    HDF.closeLoadingMask();
                }
            }
        );
    },
    /**
     * 显示Loading中的遮罩层
     *
     * @param message
     */
    showLoadingMask : function(message) {
        if (HDF.loadingMaskCount == 0) {
            $("body").mask(message);
        }
        HDF.loadingMaskCount++;
    },
    uploadExcelFile:function(url,fileTagName,param){
        $("input[name="+fileTagName+"]").upload({
            url: url,
            // 其他表单数据
            params: param,
            // 上传完成后, 返回json, text
            dataType: 'json',
            onSend: function (obj, str) {
                MainUtils.showLoadingMask("文件上传中....");
                return true;
            },
            // 上传之后回调
            onComplate: function (data) {
                HDF.closeLoadingMask();
                var taskId = data.taskId;
                if(taskId==undefined||taskId==""){
                    var message = data.message;
                    if(message!=undefined && message!=""){
                        $.alertMessage.error(message);
                    }
                    return;
                }

                MainUtils.uploadProcessListen(taskId,"数据后台处理中.....");
            },
            onProgress: function (evt) {
            }
        });
        $("input[name="+fileTagName+"]").upload("ajaxSubmit")
    },

    /**
     * 计算时间只差,返回天
     * @param startDateString 开始时间
     * @param endDateString 结束时间
     * @returns 天数
     */
    calculateDate : function(startDateString,endDateString){
        if(endDateString==""||endDateString==undefined){
            endDateString = this.getCurrentDate();
        }
        var startDateSplit = startDateString.split("-");
        var endDateSplit = endDateString.split("-");
        //时间格式mm-dd-yyyy
        var startDate = new  Date(startDateSplit[1]  +  '-'  +  startDateSplit[2]  +  '-'  +  startDateSplit[0]);
        var endDate = new  Date(endDateSplit[1]  +  '-'  +  endDateSplit[2]  +  '-'  +  endDateSplit[0]);
        var calculateDateDays  =  parseInt(Math.abs(endDate  -  startDate)  /  1000  /  60  /  60  /24)
        return calculateDateDays;
    },
    /**
     * 获得当期时间
     * @returns 当前时间，时间格式为yyyy-mm-dd
     */
    getCurrentDate: function () {
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        //JS 月份从0开始的，所有月份必须+1
        var month = currentDate.getMonth()+1;
        var day = currentDate.getDay();
        return year + "-" + (month<10?("0"+month):month) + "-" + day;
    },
    /**
     * 时间格式验证(yyyy-mm-dd)
     * @param date 时间
     * @returns true格式正确,false格式不正确
     */
    dateFormatValidation : function(date){
        //时间格式的正则表达式
        var dateRegular = /^(\d{4})-(\d{2})-(\d{2})$/
        if (!dateRegular.test(date)){
            return false
        }
        return true;
    },

    /**
     * js加载页面图片
     * @path 路径
     * @属性值
     */
    loadImages:function(path,name){
        var arrayList = ["png","jpg","jpeg","bmp","gif"];
        $(arrayList).each(function(i,val){
            var img = new Image();
            var pathUrl=path+val;
            img.onload = function() {
                name.html("<img src='"+pathUrl+"' height='150px' width='250px'/>");
                name.attr("href",pathUrl);
                name.attr("src",pathUrl);
            }
            img.src= pathUrl;
        });
    },

    /**
     * js加载同一属性页面图片
     * @path 路径
     * @属性值
     */
    loadImageManys:function(name){
        var arrayList = ["png","jpg","jpeg","bmp","gif"];
        $(arrayList).each(function(i,val){
            $(name).each(function(j,src){
            var pathdata=$(this).attr("href");
            var img = new Image();
            var pathUrl=pathdata+val;
            var aTag = $(this);
            img.onload = function() {
                aTag.html("<img src='"+pathUrl+"' height='140px' width='200px'/>");
                aTag.attr("href",pathUrl);
                aTag.attr("src",pathUrl);
            }
            img.src= pathUrl;
            });
        });
    }
}
