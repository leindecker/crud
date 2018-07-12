app.factory("FuncionariosService", ["$resource", "appValue", function($resource, appValue){
	var URL_FUNCIONARIOS = appValue.baseUrl + "/funcionarios";
	
	return $resource(URL_FUNCIONARIOS, {}, {
		query: {method: 'GET', isArray: true},
		create: {method: 'POST'}
	});	
}]);

app.factory("FuncionariolService", ["$resource", "appValue", function($resource, appValue){
	var URL_FUNCIONARIOS = appValue.baseUrl + "/funcionarios/:id"
		
	return $resource(URL_FUNCIONARIOS, {}, {
		show: {method: 'GET', params: {id: '@id'}},
		update: {method: 'PUT'},
		remove: {method: 'delete', params: {id: '@id'}}
	});
}]);