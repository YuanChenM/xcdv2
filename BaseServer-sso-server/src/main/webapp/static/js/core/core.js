/**
 * @author ma_b
 * 
 */
var HDF = {
	statusCode : {
		ok : 200,
		error : 300,
		timeout : 301
	},
	jsonEval : function(data) {
		try {
			if ($.type(data) == 'string')
				return eval('(' + data + ')');
			else
				return data;
		} catch (e) {
			return {};
		}
	},
	ajaxError : function(xhr, ajaxOptions, thrownError) {
		if ("12029" == xhr.status || "404" == xhr.status) {
			$.alertMessage.error("页面找不到");
		} else if ("401" == xhr.status) {
			// 没权限或session失效
			$.alertMessage.error(Main.message.sessionTimeout);
			// window.location = Main.contextPath +
			// "/login?message=sy01s01.login.timeout";
		} else {
			if ($.alertMessage.isCallBackError === true
					&& $.isFunction(errorFuncCallback)) {
				$.alertMessage.error(xhr.responseText, errorFuncCallback);
			} else {
				$.alertMessage.error(xhr.responseText);
			}

		}

		// if (alertMsg) {
		// alertMsg.error("<div>Http status: " + xhr.status + " " +
		// xhr.statusText + "</div>"
		// + "<div>ajaxOptions: "+ajaxOptions + "</div>"
		// + "<div>thrownError: "+thrownError + "</div>"
		// + "<div>"+xhr.responseText+"</div>");
		// } else {
		// $.alertMessage.error(xhr.responseText);
		// alert("Http status: " + xhr.status + " " + xhr.statusText +
		// "\najaxOptions: " + ajaxOptions + "\nthrownError:"+thrownError + "\n"
		// +xhr.responseText);
		// }
	},
	msg : function(key, args) {
		var _format = function(str, args) {
			args = args || [];
			var result = str;
			for (var i = 0; i < args.length; i++) {
				result = result.replace(new RegExp("\\{" + i + "\\}", "g"),
						args[i]);
			}
			return result;
		};
		return _format(MSG[key], args);
	},

	init : function(options) {
		initEnv();
	},

	/**
	 * Loading遮罩层被打开的次数
	 */
	loadingMaskCount : 0,
	/**
	 * 显示Loading中的遮罩层
	 * 
	 * @param options
	 */
	showLoadingMask : function(options) {
		if (HDF.loadingMaskCount == 0) {
			$("body").mask("Loading...");
		}
		HDF.loadingMaskCount++;
	},

	/**
	 * 关闭Loading中的遮罩层
	 */
	closeLoadingMask : function() {
		HDF.loadingMaskCount--;
		if (HDF.loadingMaskCount <= 0) {
			$("body").unmask();
			HDF.loadingMaskCount = 0;
		}
	}
};

(function($) {
	// set regional
	$.setRegional = function(key, value) {
		if (!$.regional) {
			$.regional = {};
		}
		$.regional[key] = value;
	};

	$.fn.extend({
		/**
		 * @param {Object}
		 *            op: {type:GET/POST, url:ajax请求地址, data:ajax请求参数列表,
		 *            callback:回调函数 }
		 */
		ajaxUrl : function(op, settings) {
			var pageLoginId = $("#MAIN_PAGE_LOGINID").val();
			if (op.data == undefined) {
				op.data = {};
			}
			op.data["MAIN_PAGE_LOGINID"] = pageLoginId;

			var $this = $(this);

			$.ajax($.extend({
				type : op.type || 'GET',
				url : encodeURI(op.url),
				data : op.data,
				cache : false,
				success : function(response) {
					try {
						var json = HDF.jsonEval(response);

						if (json.statusCode == HDF.statusCode.timeout) {
							// alertMsg.error(json.message ||
							// HDF.msg("sessionTimout"), {okCall:function(){
							// if ($.pdialog) {$.pdialog.checkTimeout();}
							// if (navTab) {navTab.checkTimeout();}
							// }});
						}

						if (json.statusCode == HDF.statusCode.error) {
							if (json.message) {
								alertMessage.error(json.message);
							}
						} else {
							if (settings == undefined
									|| settings.refreshHtml == undefined
									|| settings.refreshHtml == true) {
								if ($this != undefined) {
									$this.html(response).initUI();
								}
							}
							if ($.isFunction(op.callback)) {
								op.callback(response);
							}
						}
					} catch (err) {
						alert(err.message);
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					var textMsg = "系统异常,请联系管理员";
					if ("12029" == xhr.status || "404" == xhr.status) {
						textMsg = "页面找不到";
					} else if ("401" == xhr.status) {
						// 没权限或session失效
						textMsg = Main.message.sessionTimeout;
						// window.location = Main.contextPath +
						// "/login?message=sy01s01.login.timeout";
					}else if("500" == xhr.status){
						textMsg = xhr.responseText;
					}
					if ($.isFunction(op.error_callback)) {
						$.alertMessage.error(textMsg, op.error_callback);
					} else {
						$.alertMessage.error(textMsg);
					}

					// if (alertMsg) {
					// alertMsg.error("<div>Http status: " + xhr.status + " " +
					// xhr.statusText + "</div>"
					// + "<div>ajaxOptions: "+ajaxOptions + "</div>"
					// + "<div>thrownError: "+thrownError + "</div>"
					// + "<div>"+xhr.responseText+"</div>");
					// } else {
					// $.alertMessage.error(xhr.responseText);
					// alert("Http status: " + xhr.status + " " + xhr.statusText
					// +
					// "\najaxOptions: " + ajaxOptions +
					// "\nthrownError:"+thrownError + "\n"
					// +xhr.responseText);
					// }
				},
				beforeSend : HDF.showLoadingMask,
				complete : HDF.closeLoadingMask,
			}, settings));
		},
		loadUrl : function(url, data, callback, settings) {
			$(this).ajaxUrl({
				url : url,
				data : data,
				callback : callback
			}, settings);
		},
		/**
		 * @param url
		 *            提交的URL
		 * @param data
		 *            提交的数据（json格式）
		 * @param callback
		 *            ajax处理后的回调函数
		 * @param settings
		 *            设置选项 refreshHtml： true/false 是否刷新html，默认为true
		 */
		postUrl : function(url, data, callback, settings, error_callback) {
			$(this).ajaxUrl({
				url : url,
				data : data,
				callback : callback,
				type : 'POST',
				error_callback : error_callback
			}, settings);
			// $.ajax({
			// url:Main.contextPath + "/main/notice",
			// type:'GET',
			// cache:false,
			// success:function(data,status){
			// alert(data.noticeNum);
			// }
			// })

		},
		initUI : function() {
			return this.each(function() {
				if ($.isFunction(initUI))
					initUI(this);
			});
		},
		focusClass : function(className) {
			var _className = className || "textInputFocus";
			return this.each(function() {
				$(this).focus(function() {
					$(this).addClass(_className);
				}).blur(function() {
					$(this).removeClass(_className);
				});
			});
		},
	});
	$.widget("custom.pdialog", $.ui.dialog,
			{
				options : {
					url : "",
					formdata : {},
					appendTo : "body",
					autoOpen : true,
					buttons : [],
					closeOnEscape : true,
					closeText : "Close",
					dialogClass : "",
					draggable : true,
					hide : null,
					height : "auto",
					maxHeight : null,
					maxWidth : null,
					minHeight : 150,
					minWidth : 150,
					modal : true,
					position : {
						my : "center",
						at : "center",
						of : window,
						collision : "fit",
						// Ensure the titlebar is always visible
						using : function(pos) {
							var topOffset = $(this).css(pos).offset().top;
							if (topOffset < 0) {
								$(this).css("top", pos.top - topOffset);
							}
						}
					},
					resizable : true,
					show : null,
					title : null,
					width : 300,

					// callbacks
					beforeClose : null,
					close : null,
					drag : null,
					dragStart : null,
					dragStop : null,
					focus : null,
					open : null,
					resize : null,
					resizeStart : null,
					resizeStop : null,
					divId : "pdialogId"
				},
				open : function() {
					$("#" + this.options.divId).postUrl(this.options.url,
							this.options.formdata, this.options.callback);
					var that = this;
					if (this._isOpen) {
						if (this._moveToTop()) {
							this._focusTabbable();
						}
						return;
					}

					this._isOpen = true;
					this.opener = $(this.document[0].activeElement);

					this._size();
					this._position();
					this._createOverlay();
					this._moveToTop(null, true);

					// Ensure the overlay is moved to the top with the dialog,
					// but only when
					// opening. The overlay shouldn't move after the dialog is
					// open so that
					// modeless dialogs opened after the modal dialog stack
					// properly.
					if (this.overlay) {
						this.overlay.css("z-index", this.uiDialog
								.css("z-index") - 1);
					}

					this._show(this.uiDialog, this.options.show, function() {
						that._focusTabbable();
						that._trigger("focus");
					});

					// Track the dialog immediately upon openening in case a
					// focus event
					// somehow occurs outside of the dialog before an element
					// inside the
					// dialog is focused (#10152)
					this._makeFocusTarget();

					this._trigger("open");
				},
				close : function(event) {
					var that = this;

					if (!this._isOpen
							|| this._trigger("beforeClose", event) === false) {
						return;
					}

					this._isOpen = false;
					this._destroyOverlay();

					if (!this.opener.filter(":focusable").focus().length) {
						// Hiding a focused element doesn't trigger blur in
						// WebKit
						// so in case we have nothing to focus on, explicitly
						// blur the active element
						// https://bugs.webkit.org/show_bug.cgi?id=47182
						$(this.document[0].activeElement).blur();
					}

					this._hide(this.uiDialog, this.options.hide, function() {
						that._trigger("close", event);
					});
					if (this.options.divId != "pdialogId") {
						$("#" + this.options.divId).remove();
					} else {
						$("#" + this.options.divId).html(""); // 清空原有内容
					}

				},
			});

	$
			.widget(
					"custom.checkboxSelect",
					$.ui.selectmenu,
					{
						_renderItem : function(ul, item) {
							var $label = item.label;
							var $value = item.value;
							var li = $("<li>", {});
							var myDate = new Date();
							var $selectId = this.ids.element;
							var hiddenId = $selectId.substring(9);
							var $checked = "";
							var $hiddenValue = $("#" + hiddenId).val();
							if ($hiddenValue == undefined) {
								$hiddenValue = "";
							}
							var splitValue = $hiddenValue.split(",");
							for (var i = 0; i < splitValue.length; i++) {
								var $splitValue = splitValue[i];
								if ($splitValue == $value) {
									$checked = "checked='checked'";
									break;
								}
							}

							var $checkbox = $("<input label='" + $label + "' "
									+ $checked + " type='checkbox' id='jquery"
									+ myDate.getTime() + "' name='"
									+ this.ids.menu + "-checkbox' value='"
									+ $value + "'/>");
							$checkbox.appendTo(li);
							$("<span>", {
								text : $label
							}).appendTo(li);
							return li.appendTo(ul);
						},
						// 设置width的值
						_resizeButton : function() {
							var $selectId = this.ids.element;
							var $width = $("#" + $selectId).attr("width");
							// 如果Select下拉框中有width值,则取select框中width值,否则自适应
							if ($width) {
								this.button.outerWidth($width);
								return;
							}
							var width = this.options.width;

							if (!width) {
								width = this.element.show().outerWidth();
								this.element.hide();
							}
							this.button.outerWidth(width);

						},
						open : function(event) {
							if (this.options.disabled) {
								return;
							}

							// If this is the first time the menu is being
							// opened, render the items
							if (!this.menuItems) {
								this._refreshMenu();
							} else {

								// Menu clears focus on close, reset focus to
								// selected item
								this.menu.find(".ui-state-focus").removeClass(
										"ui-state-focus");
								// this.menuInstance.focus(null,
								// this._getSelectedItem()); 选中值初期化不正确的对应
							}

							// 选择项的checkbox设置
							var $selectId = this.ids.element;
							var hiddenId = $selectId.substring(9);
							var hiddenValue = $("#" + hiddenId).val();
							if (hiddenValue == undefined) {
								hiddenValue = "";
							}
							var hiddenValueList = hiddenValue.split(",");
							$("[name='" + this.ids.menu + "-checkbox']")
									.each(
											function() {
												var flag = false;
												for (var i = 0; i < hiddenValueList.length; i++) {
													if ($(this).val() == hiddenValueList[i]) {
														flag = true;
													}
												}

												if (flag) {
													// this.checked = "checked";
													$(this).attr("checked",
															true);
												} else {
													$(this).removeAttr(
															"checked");
												}
											});

							this.isOpen = true;
							this._toggleAttr();
							this._resizeMenu();
							this._position();

							this._on(this.document, this._documentClick);

							this._trigger("open", event);
						},
						_drawButton : function() {
							var that = this, tabindex = this.element
									.attr("tabindex");

							// Associate existing label with the new button
							this.label = $(
									"label[for='" + this.ids.element + "']")
									.attr("for", this.ids.button);
							this._on(this.label, {
								click : function(event) {
									this.button.focus();
									event.preventDefault();
								}
							});

							// Hide original select element
							this.element.hide();

							// Create button
							this.button = $(
									"<span>",
									{
										"class" : "ui-selectmenu-button ui-widget ui-state-default ui-corner-all",
										tabindex : tabindex
												|| this.options.disabled ? -1
												: 0,
										id : this.ids.button,
										role : "combobox",
										"aria-expanded" : "false",
										"aria-autocomplete" : "list",
										"aria-owns" : this.ids.menu,
										"aria-haspopup" : "true"
									}).insertAfter(this.element);

							$(
									"<span>",
									{
										"class" : "ui-icon "
												+ this.options.icons.button
									}).prependTo(this.button);

							this.buttonText = $("<span>", {
								"class" : "ui-selectmenu-text"
							}).appendTo(this.button);
							var $selectId = this.ids.element;
							var hiddenId = $selectId.substring(9);
							// id -> text
							var selectText = "";
							var selectIds = $("#" + hiddenId).val();
							if (selectIds != undefined && selectIds != "") {
								var selectIdArray = selectIds.split(",");
								if (Array.prototype.forEach) {
									selectIdArray.forEach(function(id) {
										var t = $(that.element).find(
												'option[value="' + id + '"]')
												.first().text();
										if (selectText != "") {
											selectText += ",";
										}
										selectText += t;
									});
								} else {
									for (var i = 0, len = selectIdArray.length; i < len; i++) {
										var t = $(that.element).find(
												'option[value="'
														+ selectIdArray[i]
														+ '"]').first().text();
										if (selectText != "") {
											selectText += ",";
										}
										selectText += t;
									}
								}
							}
							this._setText(this.buttonText, selectText);
							this._resizeButton();

							this._on(this.button, this._buttonEvents);
							this.button.one("focusin", function() {

								// Delay rendering the menu items until the
								// button receives focus.
								// The menu may have already been rendered via a
								// programmatic open.
								if (!that.menuItems) {
									that._refreshMenu();
								}
							});
							this._hoverable(this.button);
							this._focusable(this.button);
						},
						_select : function(item, event) {
							var $value = "";
							$("[name='" + this.ids.menu + "-checkbox']")
									.each(
											function() {
												if ((event.target && event.target.tagName === "INPUT")
														|| (event.originalEvent
																&& event.originalEvent.target && event.originalEvent.target.tagName === "INPUT")) {
													// 点击checkbox的时候
													return;
												} else {
													// 点击checkbox以外的时候
													if ($(this).val() == item.value) {
														if (this.checked) {
															$(this).removeAttr(
																	"checked");
														} else {
															this.checked = "checked";
														}
													}
												}
											});
							var $label = "";
							$("[name='" + this.ids.menu + "-checkbox']")
									.each(
											function() {
												if (this.checked) {
													if ($value == "") {
														$label = $(this).attr(
																"label");
														$value = $(this).val();
													} else {
														$label += ","
																+ $(this)
																		.attr(
																				"label");
														$value += ","
																+ $(this).val();
													}
												}
											});

							// 设置值到隐藏域中去
							var $selectId = this.ids.element;
							var hiddenId = $selectId.substring(9);
							$("#" + hiddenId).val($value);

							// //回调函数,指定函数名称为selectCallback
							// if($("#"+hiddenId).attr("callback")=="true"){
							// selectCallback(item,hiddenId,$value);
							// }
							// //级联操作
							// if($("#"+$selectId).attr("toId")){
							// var $actionUrl =
							// $("#"+$selectId).attr("actionUrl");
							// alert(1)
							// }

							// Change native select element
							this.element[0].selectedIndex = item.index;
							this._setText(this.buttonText, $label);
							this._setAria(item);
							this._trigger("select", event, {
								item : item
							});
							this._trigger("change", event, {
								item : item
							});

							this._refreshMenu(); // checkbox 点击无效果的对应
						}
					});

	$
			.widget(
					"custom.selectmenuEx",
					$.ui.selectmenu,
					{
						_renderMenu : function(ul, items) {
							var that = this, currentOptgroup = "";
							// alert(items)
							$
									.each(
											items,
											function(index, item) {
												if (item.optgroup !== currentOptgroup) {
													$(
															"<li>",
															{
																"class" : "ui-selectmenu-optgroup ui-menu-divider"
																		+ (item.element
																				.parent(
																						"optgroup")
																				.prop(
																						"disabled") ? " ui-state-disabled"
																				: ""),
																text : item.optgroup
															}).appendTo(ul);

													currentOptgroup = item.optgroup;
												}

												that._renderItemData(ul, item);
											});

							// 当页面中设定了高度属性时，设定下拉框的高度
							var menuHeight = $(that.element).attr("height");
							if (menuHeight) {
								$(ul).height(menuHeight);
							}
						},
						open : function(event) {
							if (this.options.disabled) {
								return;
							}
							this._refreshMenu();
							// If this is the first time the menu is being
							// opened, render the items
							// if ( !this.menuItems ) {
							// this._refreshMenu();
							// } else {
							//
							// // Menu clears focus on close, reset focus to
							// selected item
							// this.menu.find( ".ui-state-focus" ).removeClass(
							// "ui-state-focus" );
							// this.menuInstance.focus( null,
							// this._getSelectedItem() );
							// }

							this.isOpen = true;
							this._toggleAttr();
							this._resizeMenu();
							this._position();

							this._on(this.document, this._documentClick);

							this._trigger("open", event);
						},
						// 设置width的值
						_resizeButton : function() {
							var $selectId = this.ids.element;
							var $width = $("#" + $selectId).attr("width");
							// 如果Select下拉框中有width值,则取select框中width值,否则自适应
							if ($width) {
								this.button.outerWidth($width);
								return;
							}
							var width = this.options.width;

							if (!width) {
								width = this.element.show().outerWidth();
								this.element.hide();
							}
							this.button.outerWidth(width);
						},
						_select : function(item, event) {
							var oldIndex = this.element[0].selectedIndex;

							// Change native select element
							this.element[0].selectedIndex = item.index;
							this._setText(this.buttonText, item.label);
							this._setAria(item);
							this._trigger("select", event, {
								item : item
							});

							if (item.index !== oldIndex) {
								this._trigger("change", event, {
									item : item
								});
							}

							this.close(event);
						},
					});

	/**
	 * combobox
	 */
	$
			.widget(
					"custom.combobox",
					{
						_create : function(options) {
							this.wrapper = $("<span>").addClass(
									"custom-combobox")
									.insertAfter(this.element);

							this.element.hide();
							this._createAutocomplete();
							var $disabled = this.options.disabled;
							if ($disabled != true) {
								this._createShowAllButton();
							} else {
								this.input.attr("readonly", "readonly");
							}

						},

						_createAutocomplete : function() {
							var $selectValue = this.element.attr("selectValue");
							var value = "";
							if ($selectValue == undefined) {
								var selected = this.element
										.children(":selected");
								value = selected.val() ? selected.text() : "";
							} else {
								var $selectOption = this.element.find("option");
								$.each($selectOption, function() {
									var $val = $(this).val();
									if ($val == $selectValue) {
										value = $(this).text();
										return false;
									}
								});
							}
							this.input = $("<input>")
									.appendTo(this.wrapper)
									.val(value)
									.attr("title", "")
									.addClass(
											"custom-combobox-input ui-widget-content ui-state-default ui-corner-left")
									.autocomplete({
										delay : 0,
										minLength : 0,
										source : $.proxy(this, "_source")
									}).tooltip({
										tooltipClass : "ui-state-highlight"
									});

							this._on(this.input, {
								autocompleteselect : function(event, ui) {
									ui.item.option.selected = true;
									this._trigger("select", event, {
										item : ui.item.option
									});
								},

								autocompletechange : "_removeIfInvalid"
							});
						},

						_createShowAllButton : function() {
							var input = this.input, wasOpen = false;

							$("<a>")
									.attr("tabIndex", -1)
									.attr("title", "")
									.tooltip()
									.appendTo(this.wrapper)
									.button({
										icons : {
											primary : "ui-icon-triangle-1-s"
										},
										text : false
									})
									.removeClass("ui-corner-all")
									.addClass(
											"custom-combobox-toggle ui-corner-right")
									.mousedown(
											function() {
												wasOpen = input.autocomplete(
														"widget")
														.is(":visible");
											}).click(function() {
										input.focus();

										// Close if already visible
										if (wasOpen) {
											return;
										}

										// Pass empty string as value to search
										// for, displaying all results
										input.autocomplete("search", "");
									});
						},

						_source : function(request, response) {
							var matcher = new RegExp($.ui.autocomplete
									.escapeRegex(request.term), "i");
							response(this.element
									.children("option")
									.map(
											function() {
												var text = $(this).text();
												var searchVal = $(this).attr(
														"searchVal");
												if ((this.value && (!request.term
														|| matcher.test(text) || matcher
														.test(searchVal))))
													return {
														label : text,
														value : text,
														option : this
													};
											}));
						},

						_removeIfInvalid : function(event, ui) {

							// Selected an item, nothing to do
							if (ui.item) {
								return;
							}

							// Search for a match (case-insensitive)
							var value = this.input.val(), valueLowerCase = value
									.toLowerCase(), valid = false;
							this.element
									.children("option")
									.each(
											function() {
												if ($(this).text()
														.toLowerCase() === valueLowerCase) {
													this.selected = valid = true;
													return false;
												}
											});

							// Found a match, nothing to do
							if (valid) {
								return;
							}

							// Remove invalid value
							this.input.val("").attr("title", value + " 不存在")
									.tooltip("open");
							this.element.val("");
							this._delay(function() {
								this.input.tooltip("close").attr("title", "");
							}, 2500);
							this.input.data("ui-autocomplete").term = "";
						},

						_destroy : function() {
							this.wrapper.remove();
							this.element.show();
						}
					});

	/**
	 * 扩展String方法
	 */
	$
			.extend(
					String.prototype,
					{
						isPositiveInteger : function() {
							return (new RegExp(/^[1-9]\d*$/).test(this));
						},
						isInteger : function() {
							return (new RegExp(/^\d+$/).test(this));
						},
						isIntegerRange : function(min, max) {
							var val = parseInt(this);
							return val > min && val < max;
						},
						isNumber : function(value, element) {
							return (new RegExp(
									/^-?(?:\d+|\d{1,3}(?:,\d{3})+)(?:\.\d+)?$/)
									.test(this));
						},
						trim : function() {
							return this.replace(/(^\s*)|(\s*$)|\r|\n/g, "");
						},
						startsWith : function(pattern) {
							return this.indexOf(pattern) === 0;
						},
						endsWith : function(pattern) {
							var d = this.length - pattern.length;
							return d >= 0 && this.lastIndexOf(pattern) === d;
						},
						replaceSuffix : function(index) {
							return this
									.replace(/\[[0-9]+\]/, '[' + index + ']')
									.replace('#index#', index);
						},
						trans : function() {
							return this.replace(/&lt;/g, '<').replace(/&gt;/g,
									'>').replace(/&quot;/g, '"');
						},
						replaceAll : function(os, ns) {
							return this.replace(new RegExp(os, "gm"), ns);
						},
						replaceTm : function($data) {
							if (!$data) {
								return this;
							}
							return this.replace(RegExp(
									"({[A-Za-z_]+[A-Za-z0-9_]*})", "g"),
									function($1) {
										return $data[$1.replace(/[{}]+/g, "")];
									});
						},
						replaceTmById : function(_box) {
							var $parent = _box || $(document);
							return this
									.replace(
											RegExp(
													"({[A-Za-z_]+[A-Za-z0-9_]*})",
													"g"), function($1) {
												var $input = $parent.find("#"
														+ $1.replace(/[{}]+/g,
																""));
												return $input.val() ? $input
														.val() : $1;
											});
						},
						isFinishedTm : function() {
							return !(new RegExp("{[A-Za-z_]+[A-Za-z0-9_]*}")
									.test(this));
						},
						skipChar : function(ch) {
							if (!this || this.length === 0) {
								return '';
							}
							if (this.charAt(0) === ch) {
								return this.substring(1).skipChar(ch);
							}
							return this;
						},
						isValidPwd : function() {
							return (new RegExp(/^([_]|[a-zA-Z0-9]){6,32}$/)
									.test(this));
						},
						isValidMail : function() {
							return (new RegExp(
									/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)
									.test(this.trim()));
						},
						isSpaces : function() {
							for (var i = 0; i < this.length; i += 1) {
								var ch = this.charAt(i);
								if (ch != ' ' && ch != "\n" && ch != "\t"
										&& ch != "\r") {
									return false;
								}
							}
							return true;
						},
						isPhone : function() {
							return (new RegExp(
									/(^([0-9]{3,4}[-])?\d{3,8}(-\d{1,6})?$)|(^\([0-9]{3,4}\)\d{3,8}(\(\d{1,6}\))?$)|(^\d{3,8}$)/)
									.test(this));
						},
						isUrl : function() {
							return (new RegExp(
									/^[a-zA-z]+:\/\/([a-zA-Z0-9\-\.]+)([-\w .\/?%&=:]*)$/)
									.test(this));
						},
						isExternalUrl : function() {
							return this.isUrl()
									&& this.indexOf("://" + document.domain) == -1;
						}
					});

	$.extend($.prototype, {
		htmlCode : function() {
			var div = $('<div></div>');
			this.appendTo(div);
			return div.html();
		}
	});
})(jQuery);

function mainValidation($form) {
	return $form
			.validate({
				errorPlacement : function(error, element) {
					var index = 0;
					// 光标放在第一个出错项目上
					if (index == 0) {
						$(element).focus();
					}
					// 错误信息显示
					var msg = $(element).parent().prev().find("label").text()
							+ ": " + error;
					$('#alertMessageId').append(msg + "<br/>");
					$.alertMessage.error($('#alertMessageId').html());
					// 出错项目标示
					$(element).addClass('check_error');
					index++;
				},
				onfocusout : false,
				onkeyup : false,
				onclick : false,
				showErrors : function() {
					for (var i = 0; this.errorList[i]; i++) {
						var error = this.errorList[i];
						this.settings.highlight
								&& this.settings.highlight.call(this,
										error.element,
										this.settings.errorClass,
										this.settings.validClass);
						// this.showLabel( error.element, error.message );
						var element = error.element;
						var message = error.message;
						var label = this.errorsFor(element);
						if (label.length) {
							// refresh error/success class
							label.removeClass(this.settings.validClass)
									.addClass(this.settings.errorClass);

							// check if we have a generated label, replace the
							// message then
							label.attr("generated") && label.html(message);
						} else {
							// create label
							label = $("<" + this.settings.errorElement + "/>")
									.attr({
										"for" : this.idOrName(element),
										generated : true
									}).addClass(this.settings.errorClass);
							if (this.settings.wrapper) {
								// make sure the element is visible, even in IE
								// actually showing the wrapped element is
								// handled elsewhere
								label = label.hide().show().wrap(
										"<" + this.settings.wrapper + "/>")
										.parent();
							}
							if (!this.labelContainer.append(label).length)
								this.settings.errorPlacement ? this.settings
										.errorPlacement(message, $(element))
										: label.insertAfter(element);
						}
						if (!message && this.settings.success) {
							label.text("");
							typeof this.settings.success == "string" ? label
									.addClass(this.settings.success)
									: this.settings.success(label);
						}
						this.toShow = this.toShow.add(label);
					}
					if (this.errorList.length) {
						this.toShow = this.toShow.add(this.containers);
					}
					if (this.settings.success) {
						for (var i = 0; this.successList[i]; i++) {
							this.showLabel(this.successList[i]);
						}
					}
					if (this.settings.unhighlight) {
						for (var i = 0, elements = this.validElements(); elements[i]; i++) {
							this.settings.unhighlight.call(this, elements[i],
									this.settings.errorClass,
									this.settings.validClass);
						}
					}
					this.toHide = this.toHide.not(this.toShow);
					this.hideErrors();
					this.addWrapper(this.toShow).show();
				}
			});
}

function clearErrBef() {
	// 清楚上次的错误信息
	$('input,select,textarea').removeClass('check_error');
	$('#alertMessageId').html("");
}

function getFormData($form) {
	var formdata = {};
	var params = $form.serializeArray();
	for (var i = 0; i < params.length; i++) {
		var obj = formdata[params[i].name];
		if (obj == undefined) {
			formdata[params[i].name] = params[i].value;
		} else {
			// 数组或List类型的处理:拼成{"0":xxx, "1":xxxx}的形式
			if (typeof (obj) == "object") {
				// 已经是对象的时候
				var count = 0;
				for ( var attr in obj) {
					if (attr != undefined) {
						count++;
					}
				}
				// var indexKey = "\"" + count + "\"";
				obj[count] = params[i].value;
			} else {
				// 还不是对象的时候
				var value = new Object();
				value["0"] = obj;
				value["1"] = params[i].value;
				formdata[params[i].name] = value;
			}
		}
	}
	return formdata;
}
/**
 * 判读对象是否是数组
 * 
 * @param obj
 *            代判断对象
 * @returns ture:是数组; false:不是数组
 */
function isArrayFn(obj) {
	if (typeof Array.isArray === "function") {
		return Array.isArray(obj);
	} else {
		return Object.prototype.toString.call(obj) === "[object Array]";
	}
}

function setTabIndex(form) {
	// 设定对象
	var findContent = "input:visible,select:visible,textarea:visible,span.ui-selectmenu-button";
	var baseIndex = 100;
	var emptyRow = 0;
	$('#' + form).find('tr').each(
			function(row) {
				var column = 1;
				if ($(this).find(findContent).size() > 0) {
					$(this).find(findContent).each(
							function() {
								$(this).attr(
										'tabIdx',
										(row - emptyRow) * 100 + column
												+ baseIndex).addClass(
										'cTblIndex');
								column++;
							});
				} else {
					// 空tr
					emptyRow++;
				}
			});

	// Mantis:0191441 不要此功能 // 上下左右方向键和回车键的项目间迁移设定
	// $('#' + form + ' .cTblIndex').on('keydown', function(evt) {
	// / var tabIdx = parseInt($(this).attr('tabIdx'));
	// // 回车键
	// if (evt.keyCode == 13) {
	// evt.preventDefault();
	// var inputs = $('#' + form).find(findContent);
	// var inputSize = inputs.size();
	// var idx = inputs.index(this);
	// if (idx + 1 < inputSize) {
	// inputs[idx + 1].focus();
	// }
	// return false;
	// }
	// else {
	// switch (evt.keyCode) {
	// case 38: // ↑
	// tabIdx -= 100;
	// break;
	// case 40: // ↓
	// tabIdx += 100;
	// break;
	// case 37: // ←
	// tabIdx--;
	// break;
	// case 39: // →
	// tabIdx++;
	// break;
	// default:
	// return true;
	// }
	// if (tabIdx > 0) {
	// $('.cTblIndex[tabIdx=' + tabIdx + ']').focus();
	// return false;
	// }
	// }
	// return true;
	// });
}

function initEnv() {

	// setTimeout(function(){
	initUI();
	// }, 10);

}

/**
 * 
 * @param ctrl
 */
function initUI(ctrl) {
	var $p = $(ctrl || document);

	// page-content height
	Main.resizeMainContent();

	// accordion
	$('div.accordion', $p).each(function() {
		var $this = $(this);
		$this.accordion({
			heightStyle : "content",
			collapsible : true,
			active : false,
			fillSpace : $this.attr("fillSpace"),
			alwaysOpen : true
		});
	});

	// 详细画面 分组accordion
	$('div.group-accordion', $p).each(
			function() {
				var $this = $(this);
				$this.accordion({
					collapsible : $this.attr("collapsible") == undefined ? true
							: $this.attr("collapsible") == "true",
					active : ($this.attr("active") != undefined && $this
							.attr("active") == "false") ? false : 0,
					heightStyle : "auto",
					icons : {
						header : "ui-icon-circle-arrow-e",
						activeHeader : "ui-icon-circle-arrow-s"
					},
				});

				// // group accrodion width
				// $groupHeader = $this.find('.ui-accordion-header').first();
				// $groupContent = $this.find('.ui-accordion-content').first();
				// if($groupHeader.size() > 0 && $groupContent.size() > 0) {
				// $groupHeader.width($groupContent.width() - 34);
				// }
			});

	// combox

	// init styles
	// $("input[type=text], input[type=password], textarea",
	// $p).addClass("textInput").focusClass("focus");
	// $("input[readonly], textarea[readonly]", $p).addClass("readonly");
	// $("input[disabled=true], textarea[disabled=true]",
	// $p).addClass("disabled");
	// $("input[type=text]", $p).not("div.tabs input[type=text]",
	// $p).filter("[alt]").inputAlert();

	// Button
	// $("div.button", $p).hoverClass("buttonHover");
	// $("div.buttonActive", $p).hoverClass("buttonActiveHover");
	// $("div.panel", $p).jPanel();

	// validate form
	$("form.required-validate", $p).each(function() {
		$(this).validate({
			focusInvalid : false,
			focusCleanup : true,
			errorElement : "span",
			ignore : ".ignore",
			invalidHandler : function(form, validator) {
				var errors = validator.numberOfInvalids();
				if (errors) {
					var message = HDF.msg("validateFormError", [ errors ]);
					// TODO alertMsg.error(message);
					alert(message);
				}
			}
		});
	});

	// calendar

	// dialogs
	// $("a[target=dialog]", $p).each(function(){
	// $(this).click(function(event){
	// var $this = $(this);
	// var title = $this.attr("title") || $this.text();
	// var rel = $this.attr("rel") || "_blank";
	// var options = {};
	// var w = $this.attr("width");
	// var h = $this.attr("height");
	// if (w) options.width = w;
	// if (h) options.height = h;
	// options.max = eval($this.attr("max") || "false");
	// options.mask = eval($this.attr("mask") || "false");
	// options.maxable = eval($this.attr("maxable") || "true");
	// options.minable = eval($this.attr("minable") || "true");
	// options.fresh = eval($this.attr("fresh") || "true");
	// options.resizable = eval($this.attr("resizable") || "true");
	// options.drawable = eval($this.attr("drawable") || "true");
	// options.close = eval($this.attr("close") || "");
	// options.param = $this.attr("param") || "";
	//
	// var url =
	// unescape($this.attr("href")).replaceTmById($(event.target).parents(".unitBox:first"));
	// DWZ.debug(url);
	// if (!url.isFinishedTm()) {
	// alertMsg.error($this.attr("warn") || DWZ.msg("alertSelectMsg"));
	// return false;
	// }
	// $.pdialog.open(url, rel, title, options);
	//            
	// return false;
	// });
	// });

	// //button
	$("input[type=submit]").button().click(function(event) {
		event.preventDefault();
		$.core.navTabSearch("testForm");
	});

	$("a[target=ajax]", $p).each(function() {
		$(this).click(function(event) {
			var $this = $(this);
			var rel = $this.attr("rel");
			var paramStr = $this.attr("param");
			var param = {};
			if(paramStr != undefined){
				param=eval("("+paramStr+")");//转换为json对象
			}

			if (rel) {
				var $rel = $("#" + rel);

				$rel.postUrl($this.attr("href"), param , function() {
					// $this.trigger('load');
					// TODO $rel.find("[layoutH]").layoutH();
				});
			}

			event.preventDefault();
		});
	});

	// pagination
	// $("div.pagination", $p).each(function(){
	// var $this = $(this);
	// $this.pagination({
	// targetType:$this.attr("targetType"),
	// rel:$this.attr("rel"),
	// totalCount:$this.attr("totalCount"),
	// numPerPage:$this.attr("numPerPage"),
	// pageNumShown:$this.attr("pageNumShown"),
	// currentPage:$this.attr("currentPage")
	// });
	// });

	// tooltip
	// $p.tooltip();

	// 这里放其他第三方jQuery插件...

	// editmodel的控制
	$("form input[type=text][editmodel=false], form textarea[editmodel=false]")
			.each(function() {
				$(this).attr("readonly", "readonly");
			});
	$("form input:checkbox[editmodel=false]").each(function() {
		$(this).attr("disabled", "disabled");
	});
	// 只读框退格键的问题
	$("input[readOnly], textarea[readOnly]").bind("keydown", function(e) {
		if (e.keyCode == 8) {
			e.preventDefault();
		}
	});
}
/**
 * 左补齐字符串
 * 
 * @param nSize
 *            要补齐的长度
 * @param ch
 *            要补齐的字符
 * @return
 */
String.prototype.padLeft = function(nSize, ch) {
	var len = 0;
	var s = this ? this : "";
	ch = ch ? ch : '0';// 默认补0

	len = s.length;
	while (len < nSize) {
		s = ch + s;
		len++;
	}
	return s;
};

/**
 * 右补齐字符串
 * 
 * @param nSize
 *            要补齐的长度
 * @param ch
 *            要补齐的字符
 * @return
 */
String.prototype.padRight = function(nSize, ch) {
	var len = 0;
	var s = this ? this : "";
	ch = ch ? ch : '0';// 默认补0

	len = s.length;
	while (len < nSize) {
		s = s + ch;
		len++;
	}
	return s;
};
/**
 * 左移小数点位置（用于数学计算，相当于除以Math.pow(10,scale)）
 * 
 * @param scale
 *            要移位的刻度
 * @return
 */
String.prototype.movePointLeft = function(scale) {
	var s, s1, s2, ch, ps, sign;
	ch = '.';
	sign = '';
	s = this ? this : "";

	if (scale <= 0)
		return s;
	ps = s.split('.');
	s1 = ps[0] ? ps[0] : "";
	s2 = ps[1] ? ps[1] : "";
	if (s1.slice(0, 1) == '-') {
		s1 = s1.slice(1);
		sign = '-';
	}
	if (s1.length <= scale) {
		ch = "0.";
		s1 = s1.padLeft(scale);
	}
	return sign + s1.slice(0, -scale) + ch + s1.slice(-scale) + s2;
};
/**
 * 右移小数点位置（用于数学计算，相当于乘以Math.pow(10,scale)）
 * 
 * @param scale
 *            要移位的刻度
 * @return
 */
String.prototype.movePointRight = function(scale) {
	var s, s1, s2, ch, ps;
	ch = '.';
	s = this ? this : "";

	if (scale <= 0)
		return s;
	ps = s.split('.');
	s1 = ps[0] ? ps[0] : "";
	s2 = ps[1] ? ps[1] : "";
	if (s2.length <= scale) {
		ch = '';
		s2 = s2.padRight(scale);
	}
	return s1 + s2.slice(0, scale) + ch + s2.slice(scale, s2.length);
};
/**
 * 移动小数点位置（用于数学计算，相当于（乘以/除以）Math.pow(10,scale)）
 * 
 * @param scale
 *            要移位的刻度（正数表示向右移；负数表示向左移动；0返回原值）
 * @return
 */
String.prototype.movePoint = function(scale) {
	if (scale >= 0)
		return this.movePointRight(scale);
	else
		return this.movePointLeft(-scale);
};

/**
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 例子： (new
 * Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
 * Date()).Format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

/**
 * 共通方法
 */
$(function() {
	$.number = {
		formatNumber : function(digit, length) {
			length = length ? parseInt(length) : 0;
			var strDigit = digit + "";
			var indexOf = strDigit.indexOf(".");
			if (indexOf == -1) {
				return strDigit + ".00";
			}
			if (length <= 0)
				return Math.round(digit);
			digit = Math.round(digit * Math.pow(10, length))
					/ Math.pow(10, length);
			return digit.toFixed(2);
		},
		add : function(num1, num2, decimal) {
			var fNum1 = parseFloat(num1) * 10000;
			var fNum2 = parseFloat(num2) * 10000;
			var retValue = fNum1 + fNum2;
			retValue = retValue / 10000;
			return retValue;
		},
		sub : function(num1, num2, decimal) {
			var fNum1 = parseFloat(num1) * 10000;
			var fNum2 = parseFloat(num2) * 10000;
			var retValue = fNum1 - fNum2;
			retValue = retValue / 10000;
			return retValue;
		}
	};
	$.core = {
		bindImgView : function() {
			var $width = 400;
			var pageSize = 1024;
			$('a.tooltip')
					.bind(
							'mouseover',
							function(e) {
								var x = 10;
								var y = 10;
								var xx = e.originalEvent.x
										|| e.originalEvent.layerX || 0;
								// var yy = e.originalEvent.y ||
								// e.originalEvent.layerY || 0;
								if ((xx + $width) > pageSize) {
									x = (-400);
								}
								var tooltip = "<div id='tooltip' style='z-index:103'><img src='"
										+ $(this).attr("src")
										+ "' width='"
										+ $width + "px'/></div>"; // 创建 div 元素
								$("body").append(tooltip);
								$("#tooltip").css({
									"top" : (e.pageY + y) + "px",
									"left" : (e.pageX + x) + "px"
								}).show("fast"); // 设置x坐标和y坐标，并且显示;
							});
			$('a.tooltip').bind('mouseout', function(e) {
				$("#tooltip").remove();
			});
			$('a.tooltip').bind('mousemove', function(e) {
				var x = 10;
				var y = 10;
				var xx = e.originalEvent.x || e.originalEvent.layerX || 0;
				// var yy = e.originalEvent.y || e.originalEvent.layerY || 0;
				if ((xx + $width) > pageSize) {
					x = (-400);
				}
				$("#tooltip").css({
					"top" : (e.pageY + y) + "px",
					"left" : (e.pageX + x) + "px"
				});
			});
		},
		setSelectmenuText : function(selectId, text) {
			var lastTag = $("#" + selectId + "-button").find(
					".ui-selectmenu-text");
			lastTag.html(text);
		},

		/**
		 * 文件上传
		 */
		uploadForm : function(form, showLoading) {
			var $form = $(form);
			$form.attr("target", "hidden_frame");

			var actionTypeHid = "<input type='hidden' id='actionType' name='actionType' value='uploadCommon'/>";
			// var actionTypeObj = $("#actionType");
			// if (actionTypeObj == null || actionTypeObj.html() == undefined) {
			$form.append(actionTypeHid);
			// }
			// 显示loading
			if (showLoading == undefined || showLoading == null
					|| showLoading != false) {
				HDF.showLoadingMask();
			}

			$form.submit();
			return false;
		},

		/**
		 * 文件下载用提交方法（POST方式）
		 * 
		 * @param url
		 *            下载url
		 * @param data
		 *            json格式数据
		 */
		downloadUrl : function(url, data) {
			// 获得url和data
			if (url) {
				var inputs = '';
				if (data) {
					// 把参数组装成 form的 input
					$.each(data, function(key, value) {
						inputs += '<input type="hidden" name="' + key
								+ '" value="' + value + '" />';
					});
					// request发送请求
					$(
							'<form action="' + url + '" method="POST">'
									+ inputs + '</form>').appendTo('body')
							.submit().remove();
				}
			}
		},
		navTabSearch : function(form, navTabId) {

			var $form = $("#" + form);
			// if (!$form.valid()) {
			// }
			var formdata = {};
			var params = $form.serializeArray();
			for (var i = 0; i < params.length; i++) {
				formdata[params[i].name] = params[i].value;
			}
			$("#main-content").postUrl($form.attr('action'), formdata);
		},

		sleep : function(time) {
			var startTime = new Date().getTime();
			while (true) {
				var endTime = new Date().getTime();
				if (endTime - startTime >= time) {
					break;
				}
			}
		},
	};
});

/**
 * 自定义Dialog
 */
$(function() {
	$.pdialog = {
		option : {},
		open : function(title, url, option, formdata, divId) {
			if (option) {
				option['title'] = title;
				option['url'] = url;
				option['formdata'] = formdata;
			} else {
				option = {
					title : title,
					url : url,
					formdata : formdata
				};
			}
			this.option = option;
			if (divId) {
				// 如果DIV不存在,追加一个div
				if (!$("#" + divId)[0]) {
					$("body").append("<div id='" + divId + "'></div>");
				}
				this.option["divId"] = divId;
				$("#" + divId).pdialog(option);
			} else {
				$("#pdialogId").pdialog(option);
			}

			// dialog.pdialog( "open" );
		},
		close : function(divId) {
			if (divId) {
				$("#" + divId).pdialog("close");
				// $("#"+divId).remove();
			} else {
				$("#pdialogId").pdialog("close");
			}

		},
	};
	$.alertMessage = {
		option : {
			title : "",
			message : "",
			messageType : "",
			okcallback : null,
			cancelCallback : null
		},
		_alert : function() {
			$("#alertMessageId").html(this.option.message);
			var okButton = "确定";
			var cancelButton = "取消";
			var buttons = {};
			buttons[okButton] = this.option.okcallback;
			if (this.option.messageType == "confirm") {
				buttons[cancelButton] = this.option.cancelCallback;
			}
			$('#alertMessageId').dialog({
				title : this.option.title,
				modal : true,
				buttons : buttons,
				maxHeight : 800,
			});
		},
		close : function() {
			$('#alertMessageId').dialog("close");
		},
		info : function(message, callbackFun) {
			this.option.message = message;
			this.option.title = "提示信息";
			this.option.messageType = "info";
			if (!callbackFun || typeof (callbackFun) != "function") {
				this.option.okcallback = function() {
					$(this).dialog("close");
				};
			} else {
				this.option.okcallback = callbackFun;
			}
			this._alert();
		},

		error : function(message, callbackFun) {
			$.fDialog.alert(message,"error","错误消息", {
				buttons:[{text:"确定"}]
			});

		},

		warn : function(message, callbackFun) {
			this.option.message = message;
			this.option.title = "警告信息";
			if (!callbackFun) {
				this.option.okcallback = function() {
					$(this).dialog("close");
				};
			} else {
				this.option.okcallback = callbackFun;
			}
			this.option.messageType = "warn";
			this._alert();
		},

		confirm : function(message, okCallback, cancelCallback) {
			//$.fDialog.alert(message,"question","确认信息", {
			//		buttons:[
			//					{text:"确定",click:okCallback}
			//					,{text:'取消',click:cancelCallback}
			//				]
			//});
			this.option.message = message;
			this.option.title = "确认信息";
			if (!okCallback) {
				this.option.okcallback = function() {
					$(this).dialog("close");
				};
			} else {
				this.option.okcallback = okCallback;
			}
			if (!cancelCallback) {
				this.option.cancelCallback = function() {
					$(this).dialog("close");
				};
			} else {
				this.option.cancelCallback = cancelCallback;
			}
			this.option.messageType = "confirm";
			this._alert()



		},
	};
});
// @ sourceURL=core.js
