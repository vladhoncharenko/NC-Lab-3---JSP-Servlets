var config = {
    form: 'form'
};

$.formUtils.addValidator({
    name : 'canBeNull',
    validatorFunction : function(value, $el, config, language, $form) {
        return ((value=='NULL')||(parseInt(value)));
    },
    errorMessage : 'Enter valid number or NULL',
    errorMessageKey: 'badEvenNumber'
});

$.validate({
    modules: 'jsconf, security,toggleDisabled',
    disabledFormFilter : 'form.toggle-disabled',
    showErrorDialogs : false,
    onModulesLoaded: function () {
        $.setupValidation(config);
    }
});
