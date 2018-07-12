//Principal module
var app = angular.module("app", ["ngResource", "ngRoute"]);

app.config(["$routeProvider", "$locationProvider", function($routeProvider, $locationProvider){
	// CLIENTES
	
	//List Clientes
	$routeProvider.when("/clientes", {
		templateUrl: "./clientes/view/clientes.html",
		controller: "ClientesController"
	});
	
	//Adicionar Clientes
	$routeProvider.when("/clientes/adicionar", {
		templateUrl: "./clientes/view/create.html",
		controller: "ClientesController"
	});
	
	//Visualizar Cliente
	$routeProvider.when("/clientes/:id", {
		templateUrl: "./clientes/view/cliente.html",
		controller: "ClienteController"
	});
	
	//Atualizar Cliente
	$routeProvider.when("/clientes/atualizar/:id", {
		templateUrl: "./clientes/view/update.html",
		controller: "ClienteController"
	});
	
	// AUTOMOVEIS
	
	//List Automoveis
	$routeProvider.when("/automoveis", {
		templateUrl: "./automoveis/view/automoveis.html",
		controller: "AutomoveisController"
	});
	
	//Visualizar Automovel
	$routeProvider.when("/automovel/:id", {
		templateUrl: "./automoveis/view/automovel.html",
		controller: "AutomovelController"
	});
	
	//Atualizar Automovel
	$routeProvider.when("/automovel/atualizar/:id", {
		templateUrl: "./automoveis/view/update.html",
		controller: "AutomovelController"
	});
	
	//Adicionar Automovel
	$routeProvider.when("/automoveis/adicionar", {
		templateUrl: "./automoveis/view/create.html",
		controller: "AutomoveisController"
	});
	
	// FUNCIONARIOS

	
	//List FUNCIONARIOS
	$routeProvider.when("/funcionarios", {
		templateUrl: "./funcionarios/view/funcionarios.html",
		controller: "FuncionariosController"
	});
	
	//Visualizar FUNCIONARIOS
	$routeProvider.when("/funcionario/:id", {
		templateUrl: "./funcionarios/view/funcionario.html",
		controller: "FuncionarioController"
	});
	
	//Adicionar FUNCIONARIOS
	$routeProvider.when("/funcionarios/adicionar", {
		templateUrl: "./funcionarios/view/create.html",
		controller: "FuncionariosController"
	});
	
	//Atualizar FUNCIONARIOS
	$routeProvider.when("/funcionario/atualizar/:id", {
		templateUrl: "./funcionarios/view/update.html",
		controller: "FuncionarioController"
	});
	
}]);

app.value("appValue", {
	baseUrl: "/Rest/services"
});