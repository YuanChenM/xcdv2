/**
 * Created by jiangnan on 16/1/6.
 */
var FormUtils = {
    formData : {},
    init : function(formId,pageId){
        var $input = $("#"+formId).find("input");
        this.initFormValue($input,formId,pageId);
        var $select = $("#"+formId).find("select");
        this.initFormValue($select,formId,pageId);
    },
    initFormValue : function(tag,formId,pageId){
        $(tag).each(function(){
            var $inputType = $(this).attr("type");
            var $id = $(this).attr("id");
            var jsonKey = pageId+"_"+formId+"_"+$id;
            var jsonValue = FormUtils.formData[jsonKey];
            if($inputType=="button"){
                return;
            }
            $(this).val(jsonValue);
        });
    },
    setFormValue : function(formId,pageId){
        var $input = $("#"+formId).find("input");
        this.setFormValueData($input,formId,pageId);
        var $select = $("#"+formId).find("select");
        this.setFormValueData($select,formId,pageId);
    },
    setFormValueData : function(tag,formId,pageId){
        $(tag).each(function(){
            var $id = $(this).attr("id");
            var jsonKey = pageId+"_"+formId+"_"+$id;
            var jsonValue = $(this).val();
            FormUtils.formData[jsonKey] = jsonValue;
        });
    }


}