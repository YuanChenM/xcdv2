/**
 * Created by li_huiqian on 2016/11/11.
 */
+function ($) {

    // format number
    $.fn.formatNumber = function(option) {
        const DEFAULT = {
            fixed : -1
        }
        return this.each(function() {
            // replace dom
            var $this = $(this);
            var options = $.extend({}, DEFAULT, $this.data(), typeof option == 'object' && option);
            var value = '';
            if ($this.is('input')) {
                value = $this.val();
            } else {
                value = $this.text();
            }
            // remove ','
            value = value.replace(/\,/g, '');
            value = isNaN(value) || value === '' ? '0' : value;
            if (options.fixed != -1) value = parseFloat(value).toFixed(options.fixed);
            else value = parseFloat(value);
            value = (typeof value.toString() == 'string') ? value.toString() : '';
            var beforeDot = value.split('.')[0];
            var afterDot = value.split('.')[1];
            value = beforeDot.replace(/(\d{1,3})(?=(?:\d{3})+(?!\d))(\.\d+)?/g, '$1,');
            if (afterDot != null) value += '.' + afterDot;
            if ($this.is('input')) {
                $this.val(value);
            } else {
                $this.text(value);
            }
        });
    }


} (jQuery);