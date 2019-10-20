angular.module("RestBase", []).factory("RestService",
		[ "$http", "$q", function($http, $q) {
			return {
				Jsoncall : function(method, url, sendingData) {
					var deferred = $q.defer();
					var BASE_URL = "http://localhost:8080/phone-book-view/rest";
					$http({
						'method' : method,
						'url' : BASE_URL + url,
						'data' : sendingData,
					}).success(function(response) {

						deferred.resolve(response);
					}).error(function(response) {

						deferred.reject(response);
					});
					return deferred.promise;
				}

			};

		} ]);
