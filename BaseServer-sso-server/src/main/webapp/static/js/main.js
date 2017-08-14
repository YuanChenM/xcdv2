/**
 * Main画面のJS
 *
 * @author ma_b
 */

var Main = {
	menuAction:"",
	menuActionTitle:"",
	outerLayout: null,
	innerLayout: null,

	// contextPath
    contextPath : "",
    // 语言(默认简体中文，目前用于日历控件的国际化)
    language : "zh_CN",

	resizePaneAccordions: $.layout.callbacks.resizePaneAccordions,
	resizeTabLayout: $.layout.callbacks.resizeTabLayout,

	// Main画面初期化
	init : function() {
		// JS FW 初期化
		HDF.init();

		// main layout 初期化設定
	    Main.outerLayout = $('body').layout({
			applyDefaultStyles:     false
	    ,   center__paneSelector:   ".main-container"
	    ,   north__paneSelector:    ".main-header"
	    ,   west__paneSelector:     ".main-menu"
	    ,   south__paneSelector:    ".main-copyright"
	    ,   west__size:             200
	    ,   north__size:            118
	    ,   south__size:            22
	    ,   spacing_open:           4 // ALL panes
	    ,   spacing_closed:         4 // ALL panes
	    ,   north__spacing_open:    0
	    ,   south__spacing_open:    0
		,   west__togglerLength_open:    40
		,   west__togglerLength_closed:  40
		,   north__resizable:       false
		,   north__slidable:        false
	    ,   center__onresize:       "Main.innerLayout.resizeAll"
	    ,	west__onresize:		    Main.resizeTabLayout // west accordion a child of pane
	    }); 

	    Main.innerLayout = $('div.main-container').layout({
	        center__paneSelector:   ".main-content"
	    ,   south__paneSelector:    ".main-message"
	    ,   south__size:            35
	    ,   spacing_open:           2  // ALL panes
	    ,   spacing_closed:         8  // ALL panes
	    ,   center__onresize_end:   "Main.resizeMainContent"
	    });
	    
	    /*
	    Main.outerLayout.panes.west.tabs({
			activate:			Main.resizePaneAccordions 
		});
		*/

		$( ".favourite_content .sub_menu" ).menu();
	    
		// get menu data
		Main.createMenu();
		
		//修改密码事件
		$("#head_passwordchange").click(function(){
			var url = Main.contextPath + "/comm/password";
			$.pdialog.open("修改密码", url, {resizable:false, width: 300, height: 270}, "");
		});
		
		//用户配置维护
		$("#head_modifyProfile").click(function(){
			var url = Main.contextPath + "/sy01s03/init";
			var messageTitle = $(this).children("input").val();
			//$('#main-content').postUrl(url);
			$.pdialog.open(messageTitle, url, {resizable:false, width: 400, height: 300}, "");
		});
		
		// logout
		$("#head_logout").click(function(){
			var url = Main.contextPath + "/logout";
			window.location = url;
		});
		
		// 下拉菜单的处理
		$(".icon-select ul").hide().menu();
		$(".icon-select div").click(function() {
			$(".icon-select ul").hide();
			Main.outerLayout.resetOverflow(this);
			Main.outerLayout.allowOverflow('north');
	        var menu = $( this ).next().show().position({
			    my: "right top",
				at: "right bottom",
				of: this
			});
			$( document ).one( "click", function() {
				Main.outerLayout.resetOverflow(this);
				menu.hide();
			});
			return false;
		});

		// theme 選択項目初期化
		// addThemeSwitcher( 'body > .ui-layout-north > #header', { top: '10px', right: '6px' });
		
		// 显示初始内容：系统支持信息
		//$("#main-content").postUrl(Main.contextPath +"/main/message");
	},

	// 创建菜单
	createMenu : function() {
		Main.initMenu();
	},

	// 初始化菜单
	initMenu : function() {

		$( ".menu_content[active]" ).accordion({
			active: 0
		,   collapsible: true
		,   heightStyle: "content"
		});
		$( ".menu_content:not([active])" ).accordion({
			active: false
		,   collapsible: true
		,   heightStyle: "content"
		});
		
		$( ".menu_content .sub_menu" ).menu();
		
		$( ".menu_content .sub_menu li[href][rel]" ).click(function(){
			$that = $(this);
			var $pageId = $that.attr("pageId");
			var $pageTitle = $that.attr("pageTitle");
			var url = $that.attr("href");
			if(url != undefined && url != "" && url != "#"){
				// 清除检索条件的cookie
				HGRID.hfilter.clear();

				$(".menu_content .sub_menu .ui-menu-item[selected=selected]").each(function() {
				    $(this).removeAttr("selected");
				});
				$that.attr("selected", "selected");
				
				var rel = $that.attr("rel");
				Main.menuAction = url;
				Main.menuActionTitle = $pageTitle;

				$("#"+rel).postUrl(url,{pageId:$pageId,pageTitle:$pageTitle});
			}
		});
	},
	
	logout : function() {
		$("#logout").loadUrl(Main.contextPath + "/login.logout", function(res) {
			if (res == "success") {
				window.location.href = Main.contextPath +"/login";
			}
		});
	},
	
	// resize main-content
	resizeMainContent : function() {
    	$('.main-content').each(function(){
            
            // page-content height
            var $mainContent = $(this);
            var $pageHeader = $mainContent.find('div.page-header').first();
            var $pageContent = $pageHeader.nextAll('div.page-content').first();
            if($pageHeader.size() > 0 && $pageContent.size() > 0) {
	            var paddingHeight = parseInt($pageHeader.css('paddingTop').replace('px', ''))
	                + parseInt($pageHeader.css('paddingBottom').replace('px', ''))
	                + parseInt($pageContent.css('paddingTop').replace('px', ''))
	                + parseInt($pageContent.css('paddingBottom').replace('px', ''));
	            var borderHeight = 1;
	            $pageContent.height($mainContent.height() - $pageHeader.height() - paddingHeight - borderHeight);
            }
            
    	});
	}
};
