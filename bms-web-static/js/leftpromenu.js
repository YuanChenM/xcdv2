/* ========================================================================
 * Bootstrap: dropdown.js v3.3.0
 * http://getbootstrap.com/javascript/#dropdowns
 * ========================================================================
 * Copyright 2011-2014 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */

+ function($) {
	var parentli = ".parent-li";
	var secondli = ".parent-li li";
	var li = ".leftul li";
	var src = "img/icon04.png";
	var oldsrc = "img/icon03.png";
	var shrinkspan = ".shrink";
	
	//监听浏览器变化 刷新ul的高度
	$(".leftul").css("height",$(".leftnav").height()-140+"px");
	 window.onresize=function(){  
		$(".leftul").css("height",$(".leftnav").height()-140+"px");
	  }  
	
	//阻止li的冒泡事件
	$(document).on("click", li, function(event) {
		event.stopPropagation();
	})
	
	$(document).on("click", parentli, function(event) {
		event.stopPropagation();
		if($(this).hasClass("down") == false) {
			$(this).children("ul").slideDown();
			$(this).siblings().children("ul").slideUp();
			$(this).siblings().removeClass("down");
			$(this).addClass("down");
		} else {
			$(this).removeClass("down");
			$(this).children("ul").slideUp();
		}
	})
	
	$(document).on("click", secondli, function(event) {
			event.stopPropagation();
				if($(this).attr("class")==undefined||$(this).attr("class")=="") {
					$(".parent-li ul li").removeClass("seconddown");
					$(".parent-li ul li").children("img").attr("src", oldsrc);
					$(this).addClass("seconddown");
					$(this).siblings().children("img").attr("src", oldsrc);
					$(this).children("img").attr("src", src);
				} else {
					$(this).removeClass("seconddown");
					$(this).children("img").attr("src", oldsrc);
				}
			}) 
			
			
			$(document).on("click", shrinkspan, function(event) {
			if($(this).children("span").attr("class").indexOf("glyphicon glyphicon-indent-right") != -1) {
				$(".logo-bg").children("img").hide();
				$(".leftnav").width("inherit");
				$(".shrink").width("42px");
				$(".head").css("left", "42px");
				$(".main").css("left", "42px");
				$(".leftnavtxt").hide();
				$(this).children("span").attr("class", "glyphicon glyphicon-indent-left");
				$(".leftul li").mousemove(
					mouseover
				)
				$(".leftul li").mouseout(
					mouseout
				)
			} else {
				$(".logo-bg").children("img").show();
				$(".shrink").width("180px");
				$(".leftnav").width("180px");
				$(".head").css("left", "180px");
				$(".main").css("left", "180px");
				setTimeout(function() {
					$(".leftnavtxt").show();
				}, 400)
				$(this).children("span").attr("class", "glyphicon glyphicon-indent-right");
			}
		})
		//鼠标悬浮
		function mouseover(event) {
			event.stopPropagation();
			if($(".shrink").children("span").attr("class").indexOf("glyphicon-indent-left") != -1) {
				$(this).children(".leftnavtxt").addClass("leftmenu-text");
				$(this).children(".leftnavtxt").show();
			}
		}
		//鼠标离开
		function mouseout(event) {
			event.stopPropagation();
			if($(".shrink").children("span").attr("class").indexOf("glyphicon-indent-left") != -1) {
				$(this).children(".leftnavtxt").removeClass("leftmenu-text");
				$(this).children(".leftnavtxt").hide();
			}
		}
	}(jQuery);