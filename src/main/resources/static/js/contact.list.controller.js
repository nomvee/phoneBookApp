var app = angular.module('contact', []);
app.controller('ContactListController', function($scope, $filter) {

    function ContactListController($scope,$location,ContactService) {

        var mv = this;
        $scope.name = "";
        $scope.contacts = [];
        $scope.displayNotification = false;
        $scope.numberOfRecords = 5;
        $scope.totalItems; 
        $scope.currentPage = 1;
        $scope.itemsPerPage = $scope.numberOfRecords;
        $scope.maxSize = 2;
        
        $scope.get = function() {
            var successCallback = function(data) {

                $scope.contacts = data;

                $scope.numPages = Math.ceil($scope.contacts.length
                        / $scope.numPages);
                $scope.totalItems = $scope.contacts.length;
                console.log($scope.contacts);

            };
            var errorCallback = function() {

                $location.path("/");
            };

            ContactService.listAll().then(successCallback, errorCallback);
        };
        
    	$scope.getContact = function(name) {
			ContactService.get(name).then(function(response) {
				$scope.name = "";
				if(response != undefined && response.length > 1){
				//if(response == null){
					$scope.contacts = response;
				}else if (response != undefined){
				var searchContact = {
					id : response.id,
					number : response.number,
					name : response.name,	
				}
				$scope.contacts= [];
				$scope.contacts.push(searchContact);
				}else{
					$scope.contacts= [];	
				}
			}, function(error) {
				console.log("error ");
			});
		}
        $scope.remove = function(index, id) {
			var successCallback = function() {
				$scope.contacts.splice(index, 1);
 

			};
			var errorCallback = function() {
				 $location.path("/");
			};
			ContactService.remove(id).then(successCallback, errorCallback);
		};
        
		$scope.order = function(x) {
			$scope.stockOrder = x;
        };

        $scope.setPage = function(pageNo) {
        	$scope.currentPage = pageNo;
        };

        $scope.pageChanged = function() {
            console.log('Page changed to: ' + $scope.currentPage);
        };

        $scope.setItemsPerPage = function() {

        	$scope.itemsPerPage = $scope.numberOfRecords;
        	$scope.currentPage = 1; 
        };

        $scope.get();
        
    }
});
