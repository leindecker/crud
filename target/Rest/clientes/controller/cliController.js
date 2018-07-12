app.controller('ClientesController', ["$scope", "$location", "ClientesService", function($scope, $location, ClientesService){
	$scope.clientes = ClientesService.query({});
	
	
	$scope.errors = false;
	
	//Criar Cliente
	$scope.createClientes = function(){
		$location.path("/clientes/adicionar")
	};
	
	//Salvar Cliente
	$scope.save = function(){
		ClientesService.create($scope.cliente, 
				function(success){
					$location.path("/clientes");
					$scope.errors = false;
				}, 
				function(error){
					$scope.errors = true;
				});
	}
}]);

app.controller("ClienteController", ["$scope", "$routeParams", "$location", "ClienteService", function($scope, $routeParams, $location, ClienteService){
	$scope.cliente = ClienteService.show({id: $routeParams.id});
	
	//Editar Cliente
	$scope.editClientes = function(){
		$location.path("/clientes/atualizar/" + $scope.cliente.id);
	};
	
	//Atualizar Cliente
	$scope.update = function(){
		ClienteService.update($scope.cliente);
		$location.path("/clientes");
	};
	
	//Excluir Cliente
	$scope.remove = function(){
		ClienteService.remove({id: $scope.cliente.id});
		$location.path("/clientes");
	}
}]);