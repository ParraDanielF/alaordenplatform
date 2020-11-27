/** dependencies section */
const RepositoryController = require('../repository/repository.interface');

/** declarations section */

/** functional section */
/** class designed to handle the services business logic */
/** child class : RepositoryInterfaceController */
class ServiceController {
    constructor() {
        this._repositoryController = RepositoryController;
    }

    login(credentials) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getAccountData(credentials.email)
                .then(res => {
                    if (res.length > 0) {
                        if (res[0]['password'] == credentials['password']) {
                            resolve({
                                message: true,
                                role: res[0]['roleId']
                            });
                        } else {
                            reject({
                                message: false
                            })
                        }
                    }
                })
                .catch(err => reject(err))
        });
    }

    createAddress(address) {
        return new Promise((resolve, reject) => {
            this._repositoryController.createAddress(address)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    getUserAddresses(userId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getUserAddresses(userId)
                .then(res => {
                    resolve(res);
                })
                .catch(err => reject(err))
        });
    }

    createCompanyFromUser(userData) {
        return new Promise((resolve, reject) => {
            this._repositoryController.createCompanyFromUser(userData)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    addUserToACompany(userId, companyId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.addUserToACompany(userId, companyId)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    getCompanies() {
        return new Promise((resolve, reject) => {
            this._repositoryController.getCompanies()
                .then(res => {
                    resolve(res);
                })
                .catch(err => reject(err))
        });
    }

    getNotificationsByUser(userId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getNotificationsByUser(userId)
                .then(res => {
                    resolve(res);
                })
                .catch(err => reject(err))
        });
    }

    createContract(contractData) {
        return new Promise((resolve, reject) => {
            this._repositoryController.createContract(contractData)
                .then(async (newContract) => {

                    /** register contract services */
                    contractData.services.forEach(svc => {
                        svc['contractId'] = newContract['id'];
                    })

                    await this._repositoryController.registerContractServices(contractData.services);
                    /** register notification, (user, companyId) */
                    let notificationBody = {
                        notificationMessage: '',
                        readStatus: 0,
                        userId: contractData.userId
                    };

                    await this._repositoryController.createNotification(notificationBody);
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    updateContract(contractId, newContractStatus) {
        return new Promise((resolve, reject) => {
            this._repositoryController.updateContract(contractId, newContractStatus)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    updateNotificationState(contractId, newNotificationStatus) {
        return new Promise((resolve, reject) => {
            this._repositoryController.updateNotificationState(contractId, newNotificationStatus)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    registerCompanyServices(companyId, servicesArray) {
        return new Promise((resolve, reject) => {
            servicesArray.forEach( svc => {
                svc['companyId'] = companyId;
            });
            this._repositoryController.registerCompanyServices(servicesArray)
                .then(() => {
                    resolve({
                        message: 'Success'
                    })
                })
                .catch(err => reject(err))
        });
    }

    searchServices(serviceFilter) {
        return new Promise((resolve, reject) => {
            this._repositoryController.searchServices(serviceFilter.type, serviceFilter.city, serviceFilter.date)
                .then(res => {
                    resolve(res);
                })
                .catch(err => reject(err))
        });
    }

    getServicesByCompany(companyId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getServicesByCompany(companyId)
            .then( services => {
                resolve(services);
            })
            .catch(err => reject(err))
        });
    }

    registerUser(user) {
        return new Promise((resolve, reject) => {
            let userData = {
                name: user.name,
                document: user.document,
                documentType: user.documentType,
                lastName: user.lastName,
                country: user.country || 1,
                city: user.city || 1
            }
            this._repositoryController.registerUser(userData)
                .then(async (newUser) => {
                    /** create account data */
                    let accountData = {
                        userId: newUser.id,
                        email: user.email,
                        roleId: 1,
                        password: user.password,
                        status: 1
                    };

                    await this._repositoryController.registerUserAccount(accountData);
                })
                .catch(err => reject(err))
        });
    }

}

module.exports = new ServiceController();