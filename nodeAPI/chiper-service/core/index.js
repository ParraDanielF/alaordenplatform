/** imports section */
const appConfig = require('./app');

/** temporal config */
process.env.RATE_LIMIT_TIME = 5000;
process.env.RATE_LIMIT_NO_REQUEST = 20
process.env.PORT = 8080;

/** functional section */
/** RUN SERVER */
appConfig.listen(process.env.PORT, function(){
    console.log('Example app listening on port  ' + process.env.PORT);
});
