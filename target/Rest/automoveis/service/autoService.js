app.factory("AutomoveisService", ["$resource", "appValue", function($resource, appValue){
	var URL_AUTOMOVEIS = appValue.baseUrl + "/automoveis";
	
	return $resource(URL_AUTOMOVEIS, {}, {
		query: {method: 'GET', isArray: true},
		create: {method: 'POST'}
	});	
}]);

app.factory("AutomovelService", ["$resource", "appValue", function($resource, appValue){
	var URL_AUTOMOVEIS = appValue.baseUrl + "/automoveis/:id"
		
	return $resource(URL_AUTOMOVEIS, {}, {
		show: {method: 'GET', params: {id: '@id'}},
		update: {method: 'PUT'},
		remove: {method: 'delete', params: {id: '@id'}}
	});
}]);