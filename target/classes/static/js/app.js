var contact = angular.module('contact',
			[ '$routeProvider', 'RestBase', 'ngMockE2E', 'ui.bootstrap' ]).config(routerConfig)

	function routerConfig($routeProvider) {

		$routeProvider.when('/contact/new', {
			templateUrl : 'templatecontactDetails.html',
			controller : 'ContactDetailsController',
			resolve : {
				getUserAccess : function() {
					return null;
				}
			},
			controllerAs : 'mv'
		}).when('/contact/edit/:stockId', {
			templateUrl : 'template/contactDetails.html',
			controller : 'ContactDetailsController',
			resolve : {
				getUserAccess : function() {
					return null;
				}
			},
			controllerAs : 'mv'
		}).when('/contact', {
			templateUrl : 'template/contactList.html',
			controller : 'ContactListController',
			resolve : {
				getUserAccess : function() {
					return null;
				}
			},
			controllerAs : 'mv'
		}).otherwise({
			redirectTo : '/'
		});
}
