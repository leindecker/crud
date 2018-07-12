app.controller('AutomoveisController', ["$scope", "$location", "AutomoveisService", function($scope, $location, AutomoveisService){
	$scope.automoveis = AutomoveisService.query({});
	
	$scope.errors = false;
	
	//Criar Automoveis
	$scope.createAutomoveis = function(){
		$location.path("/automoveis/adicionar")
	};
	
	//Salvar Automoveis
	$scope.save = function(){
		AutomoveisService.create($scope.automovel, 
				function(success){
					$location.path("/automoveis");
					$scope.errors = false;
				}, 
				function(error){
					$scope.errors = true;
				});
	}
}]);

app.controller("AutomovelController", ["$scope", "$routeParams", "$location", "AutomovelService", function($scope, $routeParams, $location, AutomovelService){
	$scope.automovel = AutomovelService.show({id: $routeParams.id});
	
	//Editar Automovel
	$scope.editAutomovel = function(){
		$location.path("/automovel/atualizar/" + $scope.automovel.id);
	};
	
	//Atualizar Automovel
	$scope.update = function(){
		AutomovelService.update($scope.automovel);
		$location.path("/automoveis");
	};
	
	//Excluir Automovel
	$scope.remove = function(){
		AutomovelService.remove({id: $scope.automovel.id});
		$location.path("/automoveis");
	}
}]);