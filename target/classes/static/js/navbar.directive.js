angular.module('contact').directive('navBar', Navbar)
function Navbar() {
	 
	return {
		restrict : 'E',
		templateUrl : 'templates/navbar.html',
		controller: function($scope, $element, $timeout) {
		}
		}

	}
