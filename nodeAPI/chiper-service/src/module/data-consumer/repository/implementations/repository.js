/** dependencies section */
const request = require('request');
const mysql = require('mysql');
let connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'DBA2020',
    database: 'alaorden_dev'
});

/** imports section */
const variables = global.variables;

/** functional section */
/** class designed to handle the communication with external services to manage data */
class RepositoryImplementationController {

    constructor() {
        connection.connect();
    }

    getAccountData(email) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Account WHERE email = '${email}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    createAddress(addressData) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Address SET ?', addressData, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getUserAddresses(userId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Address WHERE userId = '${userId}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results)
            });
        });
    }

    createCompanyFromUser(companyData) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Company SET ?', companyData, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    addUserToACompany(userId, companyId) {
        return new Promise((resolve, reject) => {
            let collaborator = { userId, companyId };
            connection.query('INSERT INTO company_collaborators SET ?', collaborator, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getCompanies() {
        return new Promise((resolve, reject) => {
            connection.query('SELECT cp.*, cp.address as location,ct.name as city FROM Company cp JOIN City ct ON cp.city = ct.id', function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    createContract() {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Contract SET ?', post, function (error, results, fields) {
                if (error) reject(error);
                // Neat!
            });
        });
    }

    updateContract(contractId, newState) {
        return new Promise((resolve, reject) => {
            connection.query(`UPDATE Contract SET state = ${newState} WHERE id = ${contractId}`, function (error, results, fields) {
                if (error) reject(error);
                // Neat!
            });
        });
    }

    createNotification(notification) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Contract SET ?', notification, function (error, results, fields) {
                if (error) reject(error);
                // Neat!
            });
        });
    }

    getNotificationsByUser(userId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Notifications WHERE userId = ${userId}`, function (error, results, fields) {
                if (error) reject(error);
                // Neat!
            });
        });
    }

    updateNotificationState(notificationId, newState) {
        return new Promise((resolve, reject) => {
            connection.query(`UPDATE Contract SET readStatus = ${newState} WHERE id = ${notificationId}`, function (error, results, fields) {
                if (error) reject(error);
                // Neat!
            });
        });
    }

    registerCompanyServices(servicesArray) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO service (companyId, serviceType, name, description, price, isNegotiable, score) VALUES ?'
                , [servicesArray.map(item => [item.companyId, item.serviceType, item.name, item.description, item.price, item.isNegotiable, item.score])]
                , function (error, results, fields) {
                    if (error) reject(error);
                    resolve();
                });
        });
    }

    searchServices(type, city, date) {
        return new Promise((resolve, reject) => {
            connection.query("SELECT s.*, cp.* FROM Service s "
                + " JOIN Company cp ON s.companyId = cp.id"
                + " JOIN City ct ON ct.id = cp.city"
                + ` WHERE s.serviceType = ${type}`
                + ` AND ct.id = ${city}`
                + ` AND cp.id not in (SELECT companyId FROM Contract WHERE contractDate = '${date}' AND state != 'C')`, function (error, results, fields) {
                    if (error) reject(error);
                    resolve(results);
                });
        });
    }

    getServicesByCompany(companyId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Service WHERE companyId = '${companyId}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results)
            });
        });
    }

    async registerUser(userData) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO User SET ?', userData, function (error, results, fields) {
                if (error) reject(error);
                resolve({
                    message : 'user created'
                })
            });
        });
    }

    getUser(userDoc) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM User WHERE document = '${userDoc}'`, function (error, results, fields) {
                if (error) reject(error);

                console.log(results)
                resolve(results)
            });
        });
    }

    registerUserAccount(accountData) {
        return new Promise((resolve, reject) => {
            console.log(accountData)
            connection.query('INSERT INTO Account SET ?', accountData, function (error, results, fields) {
                if (error) reject(error);
                resolve({
                    message : 'account created'
                })
            });
        });
    }

    registerContractServices(contractServices) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO contract_services (contractId, serviceId) VALUES ?'
                , [contractServices.map(item => [item['contractId'], item['serviceId']])]
                , function (error, results, fields) {
                    if (error) reject(error);
                    // Neat!
                });
        });
    }

}

module.exports = new RepositoryImplementationController();