/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Ressol (ressol@gmail.com). */
(function( factory ) {
	if ( typeof define === "function" && define.amd ) {

		// AMD. Register as an anonymous module.
		define([ "../jquery.ui.datepicker" ], factory );
	} else {

		// Browser globals
		factory( jQuery.datepicker );
	}
}(function( datepicker ) {
	datepicker.regional['en_US'] = {
		closeText: 'Close',
		prevText: '&#x3C;Prev',
		nextText: 'Next&#x3E;',
		currentText: 'Today',
		monthNames: ['January','February','March','April','May','June',
		'July','August','September','October','November','December'],
		monthNamesShort: ['Jan','Feb','Mar','Apr','May','Jun',
		'Jul','Aug','Sep','Oct','Nov','Dec'],
		dayNames: ['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'],
		dayNamesShort: ['Sun','Mon','Tue','Wen','Thu','Fri','Sat'],
		dayNamesMin: ['Su','Mo','Tu','We','Th','Fr','Sa'],
		weekHeader: 'Week',
		dateFormat: 'yy/mm/dd',
		yearSuffix: 'Year',
	};
	datepicker.regional['zh_TW'] = {
		closeText: '關閉',
		prevText: '&#x3C;上月',
		nextText: '下月&#x3E;',
		currentText: '今天',
		monthNames: ['一月','二月','三月','四月','五月','六月',
		'七月','八月','九月','十月','十一月','十二月'],
		monthNamesShort: ['1月','2月','3月','4月','5月','6月',
		'7月','8月','9月','10月','11月','12月'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		weekHeader: '周',
		dateFormat: 'yy-mm-dd',
		yearSuffix: '年',
	};
	datepicker.regional['zh_CN'] = {
		closeText: '关闭',
		prevText: '&#x3C;上月',
		nextText: '下月&#x3E;',
		currentText: '今天',
		monthNames: ['一月','二月','三月','四月','五月','六月',
		'七月','八月','九月','十月','十一月','十二月'],
		monthNamesShort: ['1月','2月','3月','4月','5月','6月',
		'7月','8月','9月','10月','11月','12月'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		weekHeader: '周',
		dateFormat: 'yy-mm-dd',
		yearSuffix: '年',
	};
	
	if(typeof(Main) != "undefined" && Main.language && Main.language!=""){
		datepicker.setDefaults(datepicker.regional[Main.language]);
	}else{
		datepicker.setDefaults(datepicker.regional['zh_CN']);
	}

	return datepicker.regional['zh_CN'];
}));