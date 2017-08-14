/**
 * Created by Lee on 2016/11/12.
 */

+function ($) {
  'use strict'

  // HPAGINATION PUBLIC CLASS DEFINITION
  // ===================================

  var trigger = '.hpagination'
  var input = 'input[name="page"]'

  var HPagination = function (element, options) {
    this.$element = $(element)
    this.options = options
    this.initOptions()
    if (this.options.pagination) {
      this.initDescription()
      this.initPagination()
    }
  }

  HPagination.VERSION = '1.0.0'

  HPagination.DEFAULT = {
    pagination : false,
    count : 0,
    pageSize : 10,
    page : 1,
    pages : 0,
    description : ''
  }

  HPagination.prototype.initOptions = function () {
    var options = this.options
    options.pagination = options.count > 0
    options.pages = Math.ceil(options.count / options.pageSize)
  }

  HPagination.prototype.initDescription = function () {
    var options = this.options
    var from = (options.page - 1) * options.pageSize + 1
    var to = options.page * options.pageSize
    to = Math.min(options.count, to)
    options.description = '从' + from + '到' + to + '/共' + options.count + '条数据'
    this.$element.prepend('<span>' + options.description + '</span>')
  }

  HPagination.prototype.initPagination = function() {
    var options = this.options
    var page = options.page
    var pages = options.pages
    var first = page - 2, last = page + 2
    if (first < 1) {
      last += 1 - first
      first = 1
    }
    if (last > pages) {
      first -= last - pages
      last = pages
    }
    first = Math.max(first, 1)
    var $element = this.$element
    var $ul = $('<ul></ul>')
    for (var i = first - 2; i < last + 5; i++) {
      var $li = $('<li></li>')
      var $span = $('<span></span>')
      if (i === first - 2) { // <<
        if (page === 1) $li.addClass('disabled')
        else $span.data('goto', 1)
        $span.text('«')
      } else if (i === first - 1) { // <
        if (page === 1) $li.addClass('disabled')
        else $span.data('goto', page - 1)
        $span.text('<')
      } else if (i === last + 1) { // >
        if (page === pages) $li.addClass('disabled')
        else $span.data('goto', page + 1)
        $span.text('>')
      } else if (i === last + 2) { // >>
        if (page === pages) $li.addClass('disabled')
        else $span.data('goto', pages)
        $span.text('»')
      } else if (i === last + 3) { // input box
        var $input = $('<input type="text" name="page" value="' + page + '" />')
        $span.append($input)
      } else if (i === last + 4) { // goto
        $span.data('goto', 'page')
        $span.text('跳转')
      } else {
        if (page === i) $li.addClass('active')
        else $span.data('goto', i)
        $span.text(i)
      }
      $li.append($span)
      $ul.append($li)
      $element.append($ul)
    }
  }

  HPagination.prototype.goto = function(page) {
    var $element = this.$element
    var $form = $element.closest('form')
    var $page = $element.find(input)
    $form.submit(function(){
      $page.val(page)
    })
    $form.submit()
  }

  HPagination.prototype.click = function(e) {
    var $target = $(e.target)
    var $page = $(this).find(input)
    if ($target.is('span')) {
      var goto = $target.data('goto')
      if (typeof goto != 'undefined') {
        $(this).data('bs.hpagination').goto(goto === 'page' ? $page.val() : goto)
      }
    }
  }

  // HPAGINATION PLUGIN DEFINITION
  // =============================

  function Plugin(option) {
    return this.each(function() {
      var $this = $(this)
      var options = $.extend({}, HPagination.DEFAULT, $this.data(), typeof option == 'object' && option)

      var data = $this.data('bs.hpagination')
      if (!data) $this.data('bs.hpagination', (data = new HPagination(this, options)))
    })
  }

  var old = $.fn.hpagination
  $.fn.hpagination = Plugin
  $.fn.hpagination.Constructor = HPagination

  // HPAGINATION NO CONFLICT
  // =======================

  $.fn.hpagination.noConflict = function() {
    $.fn.hpagination = old
    return this
  }

  // HPAGINATION DATA-API
  // ====================
  $(trigger).hpagination()
  $(document).on('click.bs.hpagination.data-api', trigger, HPagination.prototype.click)

} (jQuery);
