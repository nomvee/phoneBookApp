var app = angular.module('contact', []);
app.controller('ContactDetailsController', function($scope, $filter) {
	function ContactDetailsController($scope, $location, $routeParams,
			ContactService) {

		$scope.contact = {};
		$scope.name = "";
		$scope.$location = $location;

		$scope.get = function() {
            var successCallback = function(data) {

                $scope.contact = data;

                $scope.numPages = Math.ceil($scope.contact.length
                        / $scope.numPages);
                $scope.totalItems = $scope.contact.length;
                console.log($scope.contact);

            };
            var errorCallback = function() {

                $location.path("/");
            };

            ContactService.listAll().then(successCallback, errorCallback);
        };
		
		$scope.getContact = function(name) {
			ContactService.get(name).then(function(response) {
				$scope.name = "";
				if(response == null){
					$scope.get();
				}else{
				var searchContact = {
					id : response.id,
					number : response.number,
					name : response.name,
					

				}
				$scope.contact.push(searchContact);
				}

			}, function(error) {
				console.log("error ");
			});
		}

		$scope.save = function() {

			var successCallback = function() {
				$location.path("/contact");
			};
			var errorCallback = function() {
				$location.path("/");
			};
			if ($routeParams.stockId == undefined) {
				ContactService.create($scope.contact).then(successCallback,
						errorCallback);
			} else {
				ContactService.update($scope.contact).then(successCallback,
						errorCallback);
			}
		};
		$scope.get();
}});


/*(function() {
	angular.module('contact').controller('ContactDetailsController',
			ContactDetailsController)

	function ContactDetailsController($scope, $location, $routeParams,
			ContactService) {

		$scope.contact = {};
		$scope.name = "";
		$scope.$location = $location;

		$scope.get = function() {
            var successCallback = function(data) {

                $scope.contact = data;

                $scope.numPages = Math.ceil($scope.contact.length
                        / $scope.numPages);
                $scope.totalItems = $scope.contact.length;
                console.log($scope.contact);

            };
            var errorCallback = function() {

                $location.path("/");
            };

            ContactService.listAll().then(successCallback, errorCallback);
        };
		
		$scope.getContact = function(name) {
			ContactService.get(name).then(function(response) {
				$scope.name = "";
				if(response == null){
					$scope.get();
				}else{
				var searchContact = {
					id : response.id,
					number : response.number,
					name : response.name,
					

				}
				$scope.contact.push(searchContact);
				}

			}, function(error) {
				console.log("error ");
			});
		}

		$scope.save = function() {

			var successCallback = function() {
				$location.path("/contact");
			};
			var errorCallback = function() {
				$location.path("/");
			};
			if ($routeParams.stockId == undefined) {
				ContactService.create($scope.contact).then(successCallback,
						errorCallback);
			} else {
				ContactService.update($scope.contact).then(successCallback,
						errorCallback);
			}
		};
		$scope.get();
	}
})()*/