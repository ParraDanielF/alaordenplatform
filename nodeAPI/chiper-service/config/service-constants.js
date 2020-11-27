
/** object defined to contain the constant values to use in the app */
let variables = {
    dev : {
        DATA_SOURCE_URI: 'https://data.sfgov.org/resource/rqzj-sfat.json'
    },
    qa : {
        DATA_SOURCE_URI: 'https://data.sfgov.org/resource/rqzj-sfat.json',
        DATA_SOURCE_URI_FAIL: 'https://data.sfgov.org/resource/rqzj-sfat-fail.json'
    }
};

module.exports = variables;