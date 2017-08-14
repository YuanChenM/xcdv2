/**
 * Created by Lee on 2016/11/12.
 */

+function ($) {
  'use strict'

  // HDATATABLE PUBLIC CLASS DEFINITION
  // ===================================

  var trigger = '.hdatatable'
  var input = 'input[name="page"]'

  var HDatatable = function (element, options) {
    this.$element = $(element)
    this.options = options
    this.initOptions()
    this.initTable()
    if (this.options.count != 0) this.initPagination()
  }

  HDatatable.VERSION = '1.0.0'

  HDatatable.DEFAULT = {
    count : 0,
    pageSize : 10,
    page : 1
  }

  HDatatable.prototype.initOptions = function () {
  }

  HDatatable.prototype.initTable = function () {
    var $table = this.$element.find('table')
    var $tbody = $table.children('tbody')
    var $tfoot = $table.children('tfoot')

    // Append Class
    $tbody.find('.number').each(function() {
      $(this).formatNumber()
    })
    $tbody.find('.money').each(function() {
      $(this).formatNumber({fixed : 2})
    })
    $tfoot.find('.number').each(function() {
      $(this).formatNumber()
    })
    $tfoot.find('.money').each(function() {
      $(this).formatNumber({fixed : 2})
    })

  }

  HDatatable.prototype.initPagination = function() {
    var $hpagination = $('<nav></nav>')
    $hpagination.addClass('hpagination')
    $.extend($hpagination.data(), this.options)
    this.$element.append($hpagination)
  }

  // HDATATABLE PLUGIN DEFINITION
  // =============================

  function Plugin(option) {
    return this.each(function() {
      var $this = $(this)
      var options = $.extend({}, HDatatable.DEFAULT, $this.data(), typeof option == 'object' && option)

      var data = $this.data('bs.hdatatable')
      if (!data) $this.data('bs.hdatatable', (data = new HDatatable(this, options)))
    })
  }

  var old = $.fn.hdatatable
  $.fn.hdatatable = Plugin
  $.fn.hdatatable.Constructor = HDatatable

  // HDATATABLE NO CONFLICT
  // =======================

  $.fn.hdatatable.noConflict = function() {
    $.fn.hdatatable = old
    return this
  }

  // HDATATABLE DATA-API
  // ====================
  $(trigger).hdatatable()

} (jQuery);
