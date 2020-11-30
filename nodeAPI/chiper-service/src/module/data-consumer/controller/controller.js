/** imports section */
const ServiceController = require('../service/service');

/** configs section */


/** functional section */
/** class designed to expose the services to the router module */
/** child class : ServiceController */
class MainController {
    constructor() {
        this._serviceController = ServiceController;
    }

    login(req, res) {
        this._serviceController.login(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    createAddress(req, res) {
        this._serviceController.createAddress(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    getUserAddresses(req, res) {
        const { userId } = req.params;
        this._serviceController.getUserAddresses(userId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    createCompanyFromUser(req, res) {
        this._serviceController.createCompanyFromUser(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    addUserToACompany(req, res) {

        const { userId, companyId } = req.params;
        this._serviceController.addUserToACompany(userId, companyId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    getCompanies(req, res) {
        this._serviceController.getCompanies()
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    createContract(req, res) {
        this._serviceController.createContract(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    updateContract(req, res) {
        this._serviceController.updateContract()
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    getContractsByUser(req, res) {
        const {userId} = req.params;
        this._serviceController.getContractsByUser(userId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    updateNotificationState(req, res) {
        this._serviceController.updateNotificationState()
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }

    getNotificationsByUser(req, res) {
        this._serviceController.getNotificationsByUser(req.params.userId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }

    registerCompanyServices(req, res) {

        const { companyId } = req.params;
        this._serviceController.registerCompanyServices(companyId, req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }

    searchServices(req, res) {
        this._serviceController.searchServices(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }


    getServicesByCompany(req, res) {
        const { companyId } = req.params;
        this._serviceController.getServicesByCompany(companyId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }

    SetDecision(req, res) {
        this._serviceController.setDecision(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }

    getContractDataToSeller(req, res) {
        const { contractId } = req.params;
        this._serviceController.getContractDataToSeller(contractId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });
    }

    registerUser(req, res) {
        this._serviceController.registerUser(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                res.status(400).send(err)
            });

    }
}

module.exports = new MainController();