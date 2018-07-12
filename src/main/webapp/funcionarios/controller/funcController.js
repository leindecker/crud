app.controller('FuncionariosController', ["$scope", "$location", "FuncionariosService", function($scope, $location, FuncionariosService){
	$scope.funcionarios = FuncionariosService.query({});
	
	$scope.errors = false;
	
	//Criar Funcionario
	$scope.createFuncionarios = function(){
		$location.path("/funcionarios/adicionar")
	};
	
	//Salvar Funcionario
	$scope.save = function(){
		FuncionariosService.create($scope.funcionario, 
				function(success){
					$location.path("/funcionarios");
					$scope.errors = false;
				}, 
				function(error){
					$scope.errors = true;
				});
	}
}]);

app.controller("FuncionarioController", ["$scope", "$routeParams", "$location", "FuncionariolService", function($scope, $routeParams, $location, FuncionariolService){
	$scope.funcionario = FuncionariolService.show({id: $routeParams.id});
	
	//Editar Funcionario
	$scope.editFuncionario = function(){
		$location.path("/funcionario/atualizar/" + $scope.funcionario.id);
	};
	
	//Atualizar Automovel
	$scope.update = function(){
		FuncionariolService.update($scope.funcionario);
		$location.path("/funcionarios");
	};
	
	//Excluir Automovel
	$scope.remove = function(){
		FuncionariolService.remove({id: $scope.funcionario.id});
		$location.path("/funcionarios");
	}
}]);