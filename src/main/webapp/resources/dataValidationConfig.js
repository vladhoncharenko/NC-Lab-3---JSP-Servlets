var config = {
    form: 'form',
    validate: {
        'input-name': {
            validation: 'length, numbet',
            length: '0-32'
        },
        'input-name2': {
            validation: 'length, alphanumeric',
            length: '1-9'
        }
    }
};

$.validate({
    modules: 'jsconf, security',
    onModulesLoaded: function () {
        $.setupValidation(config);
    }
});
