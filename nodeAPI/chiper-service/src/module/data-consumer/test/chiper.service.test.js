/** imports section */
const describe = require('mocha').describe;
const request = require('supertest');
const assert = require('chai').assert;
let app = require('../../../../core/app')

describe('[API TESTING]', () => {
    before('[REQUIRED CONFIGS TO MAKE THE SERVICES TEST]',() => {
        /** pre-test configs */
    });

    describe('[SERVICES TEST]', () => {
        it("path= /getInfo, assertion= shoud fetch third party data", () => {
            request(app)
                .get('/getInfo')
                .end((err, res) => {
                    if(err){console.warn('[SERVICE ERROR] path=/getInfo', err)}
                    assert.isNotEmpty(res.body.body);
                });
        });

        it("path= /getInfo, assertion= shoud fail", () => {
            global.variables['qa']['DATA_SOURCE_URI'] = global.variables['qa']['DATA_SOURCE_URI_FAIL']
            request(app)
                .get('/getInfo')
                .end((err, res) => {
                    if(err){console.warn('[SERVICE ERROR] path=/getInfo', err)}
                    assert.equal(res.body.statusCode, 404);
                });
        });
    });
});

