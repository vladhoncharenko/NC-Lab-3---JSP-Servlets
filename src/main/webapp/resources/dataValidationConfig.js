var config = {
    form: 'form'
};

$.formUtils.addValidator({
    name : 'canBeNull',
    validatorFunction : function(value, $el, config, language, $form) {
        return ((value=='NULL')||(parseInt(value))||(value=='null'));
    },
    errorMessage : 'Enter valid number or NULL',
    errorMessageKey: 'badEvenNumber'
});

$.formUtils.addValidator({
    name: 'validateEmail',
    validatorFunction: function validateEmail(email) {
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    },
    errorMessage:'Wrong email'
})

$.validate({
    modules: 'jsconf, security,toggleDisabled',
    disabledFormFilter : 'form.toggle-disabled',
    showErrorDialogs : false,
    onModulesLoaded: function () {
        $.setupValidation(config);
    }
});
