var app = angular.module('contact', []);
app.factory('ContactService', ContactService)
 {
	function ContactService(RestService) {

		return {
			create : create,
			get : get,
			listAll : listAll,
			update : update,
			remove : remove

		}
		function create(contact) {
			return RestService.Jsoncall('POST', '/contact', contact);
		}
		/*function get(id) {
			return RestService.Jsoncall('GET', '/stock/' + id);
		}*/
		function get(name) {
			return RestService.Jsoncall('GET', '/contact/' + name);
		}
		function listAll() {
			return RestService.Jsoncall('GET', '/contact');

		}
		function update(contact) {
			return RestService.Jsoncall('PUT', '/contact', contact);
		}
		function remove(id) {
			return RestService.Jsoncall('DELETE', '/contact/' + id);
		}

	}
})()
