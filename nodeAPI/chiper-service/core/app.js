/** dependencies section */
let express = require('express');
let events = require('events');
let bodyParser = require('body-parser');
const helmet = require('helmet');
//const cors = require('cors');

/** global constants */
global.variables = require('../config/service-constants');
global.customEvents = new events.EventEmitter();

/** imports section */
let rateLimitMiddleware = require('../config/middlewares/rate-limiter-middleware');
const routerLayer = require('../src/module/data-consumer/routes/router');

/** declarations section */
let app = express();

/** configs section */
//cors
//const whitleListDomain = process.env.WHITE_LIST_DOMAIN ? JSON.parse(process.env.WHITE_LIST_DOMAIN) : ['http://localhost:4200'];
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Authorization, X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Allow-Request-Method');
  res.header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, DELETE');
  res.header('Allow', 'GET, POST, OPTIONS, PUT, DELETE');

  next();
});


//middlewares
app.use(rateLimitMiddleware);
app.use(helmet());
app.use(bodyParser.json({
    limit: '150mb',
    extended: true,
    type: 'application/json',
    parameterLimit: 9000000
}));

app.use(bodyParser.urlencoded({
    limit: 100000,
    extended: true
}));

/** error listeners */
/* let mappedListeners = ['uncaughtException','unhandledRejection', 'serviceError'];
mappedListeners.forEach(listener => {
    global.customEvents.on(listener, (error) => {
        return serviceErrorResponse = mainErrorHandler.buildReponse(error);

    });
});
 */

/** routes */
app.use('/', routerLayer);

module.exports = app;
