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
                                role: res[0]['roleId'],
                                userId: res[0]['userId']
                            });
                        } else {
                            reject({
                                message: false
                            })
                        }
                    } else {
                        reject({
                            message: 'the user doesn\' exists'
                        })
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
                    this._repositoryController.updateAccountRole(userData.owner, 2).then(() => {
                        this._repositoryController.getCompanyByName(userData.name).then(data => {
                            resolve(data[0])
                        })
                            .catch(err => reject(err))
                    })
                        .catch(err => reject(err))
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
            let contract = {
                companyId: contractData.companyId,
                userId: contractData.userId,
                contractDate: contractData.date,
                paymentTypeId: contractData.paymentType,
                state: contractData.state,
                description: contractData.description
            };

            this._repositoryController.createContract(contract)
                .then(() => {
                    this._repositoryController.getContract(contract.companyId, contract.userId).then(async data => {
                        /** register contract services */
                        contractData.services.forEach(svc => {
                            svc['contractId'] = data[0]['id'];
                        })
                        await this._repositoryController.registerContractServices(contractData.services);

                        /** register notification, (user, companyId) */
                        let notificationsBodies = [{
                            notificationMessage: `Se ha solicitado el servicio exitosamente`,
                            readStatus: 0,
                            userId: contractData.userId,
                            contractId: data[0]['id']
                        },
                        {
                            readStatus: 0,
                            userId: contractData.companyOwner,
                            contractId: data[0]['id']
                        }
                        ];

                        notificationsBodies.forEach(async (notificationBody) => {
                            if (!notificationBody.notificationMessage) {
                                let data = await this._repositoryController.getcontratedService(contractData.services[0]['serviceId']);
                                notificationBody['notificationMessage'] = `Ha recibido una solicitud del servicio ${data[0].name} el dia ${contractData.date}`
                            }

                            await this._repositoryController.createNotification(notificationBody)
                        });

                        resolve({
                            message: 'Success'
                        })

                    }).catch(err => reject(err))

                }).catch(err => reject(err))
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

    getNotificationsByUser(userId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getNotificationsByUser(userId)
                .then(data => {
                    resolve(data)
                })
                .catch(err => reject(err))
        });
    }

    registerCompanyServices(companyId, servicesArray) {
        return new Promise((resolve, reject) => {
            servicesArray.forEach(svc => {
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
                .then(services => {
                    resolve(services);
                })
                .catch(err => reject(err))
        });
    }

    setDecision(decision) {
        return new Promise((resolve, reject) => {
            let d = decision.decision == "Accept" ? "A" : "R";
            this.updateContract(decision.contractId, d)
                .then(services => {
                    this.updateNotificationState(decision.notificationId,1).then( data => {
                        resolve();
                    })
                    .catch(err => reject(err))
                })
                .catch(err => reject(err))
        });
    }

    getContractDataToSeller(contractId) {
        return new Promise((resolve, reject) => {
            this._repositoryController.getContractDataToSeller(contractId)
                .then(services => {
                    resolve(services);
                })
                .catch(err => reject(err))
        });
    }

    registerUser(user) {
        return new Promise((resolve, reject) => {
            try {
                let userData = {
                    id: 0,
                    name: user.name,
                    document: user.document,
                    documentType: user.documentType,
                    lastName: user.lastName,
                    country: user.country || 1,
                    city: user.city || 1
                }
                console.log("1");
                let promises = [this._repositoryController.registerUser(userData)]
                console.log("2");
                Promise.all(promises).then(() => {
                    this._repositoryController.getUser(user.document)[0].then(async (newUser) => {
                        console.log('1=>', newUser)
                        /** create account data */
                        let accountData = {
                            id: 0,
                            userId: newUser.id,
                            email: user.email,
                            roleId: 1,
                            password: user.password,
                            status: 1
                        };

                        let accountResponse = await this._repositoryController.registerUserAccount(accountData);
                        resolve(accountResponse)
                    });
                })
            } catch (error) {
                reject(error);
            }


        });
    }

}

module.exports = new ServiceController();