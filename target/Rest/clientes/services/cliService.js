app.factory("ClientesService", ["$resource", "appValue", function($resource, appValue){
	var URL_CLIENTES = appValue.baseUrl + "/clientes";
	
	return $resource(URL_CLIENTES, {}, {
		query: {method: 'GET', isArray: true},
		create: {method: 'POST'}
	});	
}]);

app.factory("ClienteService", ["$resource", "appValue", function($resource, appValue){
	var URL_CLIENTES = appValue.baseUrl + "/clientes/:id"
		
	return $resource(URL_CLIENTES, {}, {
		show: {method: 'GET', params: {id: '@id'}},
		update: {method: 'PUT'},
		remove: {method: 'delete', params: {id: '@id'}}
	});
}]);