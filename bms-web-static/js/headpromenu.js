/* ========================================================================
 * Bootstrap: dropdown.js v3.3.0
 * http://getbootstrap.com/javascript/#dropdowns
 * ========================================================================
 * Copyright 2011-2014 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */
 
+function($) {
	var parentspan = ".parent-span";
	var li=".head li";
	//阻止li的冒泡事件
	$(document).on("click", li, function(event) {
		event.stopPropagation();
	})
	$(document).on("click", parentspan, function(event) {
		event.stopPropagation();
			if($(this).attr("class").indexOf("headdown") == -1) {
				$(this).children("ul").show();
				$(this).addClass("headdown");
				  $(this).children(".glyphicon-chevron-down").removeClass("headrotefalse");
                $(this).children(".glyphicon-chevron-down").addClass("headrotetrue");
			} else {
				$(this).removeClass("headdown");
				$(this).children("ul").hide();
                $(this).children(".glyphicon-chevron-down").removeClass("headrotetrue");
                $(this).children(".glyphicon-chevron-down").addClass("headrotefalse");
			}
	})
}(jQuery);