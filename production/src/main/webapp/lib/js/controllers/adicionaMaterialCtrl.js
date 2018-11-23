angular.module("adicionaMaterial").controller("adicionaMaterialCtrl",function($scope, $http){
	$scope.app = "Adicionar Material";
	$scope.materiais = [];
	$scope.modelos =[];
	

	$scope.data = new Date();
	$scope.username = localStorage.getItem("username");
	
	var carregarMaterial = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/material").then(function (response) {
	    	$scope.materiais = response.data;
	    });
	};
	var carregarModelo = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/modelo").then(function (response) {
	    	$scope.modelos = response.data;
	    });
	};
	

	$scope.adicionarMaterial = function(material){
		material['login']=$scope.username;
		console.log(material);
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/material", material).then(function (response) {
	    	delete $scope.material.serie;
	    	delete $scope.material.casid;
	    	delete $scope.material.mac;
			$scope.materialForm.$setPristine();
			carregarMaterial();
	    });
        
	};
	
	$scope.deletarMaterial = function (materiais){
		
		$scope.materiais = materiais.filter(function (material){			
			if (!material.selecionado) return material;
			material['login']=$scope.username;
			$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/materialdelete", material).then(function (response) {		    	
		    });			
		});        
    };
    $scope.isMaterialSelecionado = function (materiais){
       return materiais.some(function (material){
            return material.selecionado;
        }); 
	};
    $scope.ordenarPor = function (campo){
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };
	carregarMaterial();
	carregarModelo();
});