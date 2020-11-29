/** dependencies section */
let express = require('express');
const router = express.Router()

/** imports section */
const MainController = require('../controller/controller');

/** configs section */

/** auth */
router.post('/auth/login', MainController.login.bind(MainController));

/** address */
router.post('/address/create', MainController.createAddress.bind(MainController));
router.get('/address/:userId/list', MainController.getUserAddresses.bind(MainController));

/** company */
router.post('/company/create-from-user/:userId', MainController.createCompanyFromUser.bind(MainController));
router.post('/company/:companyId/add/:userId', MainController.addUserToACompany.bind(MainController));
router.get('/company/list', MainController.getCompanies.bind(MainController));

/** services */
router.post('/service/register/:companyId', MainController.registerCompanyServices.bind(MainController));
router.post('/service/search', MainController.searchServices.bind(MainController));
router.get('/service/:contractId/data', MainController.getContractDataToSeller.bind(MainController));
router.get('/:companyId/services', MainController.getServicesByCompany.bind(MainController));

/** contract */
router.post('/contract/create', MainController.createContract.bind(MainController));
router.put('/contract/update', MainController.updateContract.bind(MainController));

/** notification */
router.get('/:userId/notifications', MainController.getNotificationsByUser.bind(MainController));
router.post('/notification/:notificationId/state/:state', MainController.updateNotificationState.bind(MainController));

/** user */
router.post('/user/register', MainController.registerUser.bind(MainController));

module.exports = router;