/** dependencies section */
const RepositoryImplemetation = require('./implementations/repository');

/** functional section */
/** class designed to define the current implementation that will be used for the service */
/** child class : RepositoryImplemetation */
class RepositoryController {
    constructor() {
        this._implementations = {
            repositoryImplementation: RepositoryImplemetation
        };
    }

    getAccountData(email) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getAccountData(email)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    createAddress(address) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.createAddress(address)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    getUserAddresses(userId) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getUserAddresses(userId)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    createCompanyFromUser(companyData) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.createCompanyFromUser(companyData)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    addUserToACompany(userId, companyId) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.addUserToACompany(userId, companyId)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    getCompanies() {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getCompanies()
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    createContract(contract) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.createContract(contract)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    updateContract(contractId, newContractStatus) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.updateContract(contractId, newContractStatus)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    createNotification(notification) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.createNotification(notification)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    updateNotificationState(notificationId, newNotificationState) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.updateNotificationState(notificationId, newNotificationState)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    registerCompanyServices(servicesArray) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.registerCompanyServices(servicesArray)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    searchServices(type,city,date) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.searchServices(type,city,date)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    registerUser(userData) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.registerUser(userData)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    getUser(userDoc) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getUser(userDoc)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    registerUserAccount(accountData) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.registerUserAccount(accountData)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    registerContractServices(services) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.registerContractServices(services)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    getNotificationsByUser(userId) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getNotificationsByUser(userId)
                .then(res => resolve(res))
                .catch(err => reject(err))
        });
    }

    getServicesByCompany(companyId) {
        return new Promise((resolve, reject) => {
            this._implementations.repositoryImplementation.getServicesByCompany(companyId)
            .then(res => resolve(res))
            .catch(err => reject(err))
        });
    }

}

module.exports = new RepositoryController();