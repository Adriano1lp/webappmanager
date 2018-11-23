angular.module("adicionaModelo").controller("adicionaModeloCtrl",function($scope, $http){
	$scope.app = "Cadastro de Modelos";
	$scope.modelos = [];
	
	$scope.data = new Date();
	$scope.username = localStorage.getItem("username");
	
	var carregarModelo = function () {
	    $http.get("http://localhost:8080/appoficial/modelo").then(function (response) {
	    	$scope.modelos = response.data;
	    });
	};
	
	$scope.adicionarModelo = function(modelo){
		console.log(modelo);
		$http.post("http://localhost:8080/appoficial/modelo", modelo).then(function (response) {
	    	delete $scope.modelo.codigosap;
	    	delete $scope.modelo.modelo;
	    	delete $scope.modelo.segmento;
			$scope.modeloForm.$setPristine();
			carregarModelo();
	    });
        
	};
	
	
	$scope.deletarModelo = function (modelos){
		$scope.modelos = modelos.filter(function (modelo){			
			if (!modelo.selecionado) return modelo;
			$http.post("http://localhost:8080/appoficial/modelodelete", modelo).then(function (response) {		    	
		    });			
		});        
    };
    $scope.isModeloSelecionado = function (modelos){
       return modelos.some(function (modelo){
            return modelo.selecionado;
        }); 
	};
	$scope.ordenarPor = function (campo){
        $scope.criterioDeOrdenacao = campo;
        $scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
    };
	carregarModelo();
});