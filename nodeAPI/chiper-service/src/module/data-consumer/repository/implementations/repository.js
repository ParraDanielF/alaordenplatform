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
                if (error) {reject(error);}
                resolve();
            });
        });
    }

    getCompanyByName(companyName){
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Company WHERE name = '${companyName}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    updateAccountRole(userId, role){
        return new Promise((resolve, reject) => {
            connection.query(`UPDATE Account SET roleId = ${role} WHERE userId = '${userId}'`, function (error, results, fields) {
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

    createContract(contract) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Contract SET ?', contract, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getContract(companyId, userId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Contract WHERE companyId = ${companyId} AND userId = ${userId} ORDER BY contractDate DESC LIMIT 1`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    updateContract(contractId, newState) {
        return new Promise((resolve, reject) => {
            connection.query(`UPDATE Contract SET state = '${newState}' WHERE id = ${contractId}`, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getContractsByUser(userId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT c.id, s.name as service , cp.name as company, c.state FROM Contract c
            JOIN Contract_Services cs ON cs.contractId = c.id 
            JOIN Company cp ON cp.id = c.companyId
            JOIN service s ON cs.serviceId = s.id
            WHERE userId = ${userId}`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    createNotification(notification) {
        return new Promise((resolve, reject) => {
            connection.query('INSERT INTO Notifications SET ?', notification, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getcontratedService(serviceId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM service WHERE id = ${serviceId}` , function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }


    getNotificationsByUser(userId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Notifications WHERE userId = '${userId}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
            });
        });
    }

    updateNotificationState(notificationId, newState) {
        return new Promise((resolve, reject) => {
            connection.query(`UPDATE Notifications SET readStatus = ${newState} WHERE id = ${notificationId}`, function (error, results, fields) {
                if (error) reject(error);
                resolve();
            });
        });
    }

    getNotificationsByUser(userId){
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM Notifications WHERE userId = '${userId}' AND readStatus = 0`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results);
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
            let query =
            connection.query("SELECT s.id as serviceId, s.*, cp.* FROM service s "
                + " JOIN Company cp ON s.companyId = cp.id"
                + " JOIN City ct ON ct.id = cp.city"
                + ` WHERE s.serviceType = ${type}`
                + ` AND ct.id = ${city}`
                + ` AND cp.id not in (SELECT companyId FROM Contract WHERE contractDate = '${date}' AND state != 'C')`, function (error, results, fields) {
                    if (error) reject(error);
                    resolve(results);
                });
            console.log(query.sql)
        });
    }

    getServicesByCompany(companyId) {
        return new Promise((resolve, reject) => {
            connection.query(`SELECT * FROM service WHERE companyId = '${companyId}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results)
            });
        });
    }

    getContractDataToSeller(contractId) {
        return new Promise((resolve, reject) => {
            let query =
            connection.query(`SELECT s.name as serviceName, c.contractDate, c.description, ct.name as cityName FROM Contract_Services cs
            JOIN Contract c ON cs.contractId = c.id
            JOIN service s ON cs.serviceId = s.id
            JOIN Company cp ON s.companyId = cp.id
            JOIN City ct ON cp.city = ct.id
            where c.id = '${contractId}'`, function (error, results, fields) {
                if (error) reject(error);
                resolve(results[0])
            });
            console.log(query.sql)
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
                resolve(results)
            });
        });
    }

    registerUserAccount(accountData) {
        return new Promise((resolve, reject) => {
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
            connection.query('INSERT INTO Contract_Services (contractId, serviceId) VALUES ?'
                , [contractServices.map(item => [item['contractId'], item['serviceId']])]
                , function (error, results, fields) {
                    if (error) reject(error);
                    resolve();
                });
        });
    }

}

module.exports = new RepositoryImplementationController();
