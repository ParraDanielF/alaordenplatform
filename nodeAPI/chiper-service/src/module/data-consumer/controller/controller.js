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
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    createAddress(req, res) {
        this._serviceController.createAddress(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    getUserAddresses(req, res) {
        const {userId} = req.params;
        this._serviceController.getUserAddresses(userId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    createCompanyFromUser(req, res) {
        this._serviceController.createCompanyFromUser(req.body)
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    addUserToACompany(req, res) {

        const {userId, companyId} = req.params;
        this._serviceController.addUserToACompany(userId, companyId)
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    getCompanies(req, res) {
        this._serviceController.getCompanies()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    createContract(req, res) {
        this._serviceController.createContract()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    updateContract(req, res) {
        this._serviceController.updateContract()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    updateNotificationState(req, res) {
        this._serviceController.updateNotificationState()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    registerCompanyServices(req, res) {
        this._serviceController.registerCompanyServices()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    searchServices(req, res) {
        this._serviceController.searchServices()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }

    registerUser(req, res) {
        this._serviceController.registerUser()
            .then(response => res.status(200).send(response))
            .catch(err => {
                let serviceResponse = this.buildError(err);
                res.status(400).send(serviceResponse)
            });

    }


    buildError(err) {
        let serviceResponse = {
            code: err.code || '',
            message: err.message || '',
            error: err.error || ''
        };

        return serviceResponse;
    }

}

module.exports = new MainController();