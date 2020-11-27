'use strict'
const rateLimit = require('express-rate-limit');

const rateLimiterUsingThirdParty = new rateLimit({
    windowMs: process.env.RATE_LIMIT_TIME, //  in milliseconds
    max: process.env.RATE_LIMIT_NO_REQUEST,
    message: `You have exceeded the number of requests`,
    headers: false,
});

module.exports = rateLimiterUsingThirdParty;