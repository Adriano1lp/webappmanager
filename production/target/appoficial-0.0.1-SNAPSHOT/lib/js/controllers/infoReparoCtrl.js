angular.module("infoReparo").controller("infoReparoCtrl",function($scope, $http){
	$scope.app = "Informações de Reparo";
	$scope.materiais = [];
	$scope.defeitos =[];
	
	$scope.data = new Date();
	$scope.username = localStorage.getItem("username");
	
	var carregarMaterial = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/reparo").then(function (response) {
	    	$scope.materiais = response.data;
	    });
	};
	
	var carregaHistorico = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/reparohistorico").then(function (response) {
	    	$scope.materiais = response.data;
	    });
	};
	var carregarDefeitos = function () {
	    $http.get('lib/json/defeitos.json').then(function (response) {
	    	$scope.defeitos = response.data;
	    });
	};
	
	$scope.adicionarReparo = function(material){
		material['login']=$scope.username;
		console.log(material);
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/reparo", material).then(function (response) {
	    	delete $scope.material.serie;
	    	delete $scope.material.observacao;
	    	delete $scope.material.defeito;
			$scope.materialForm.$setPristine();
			carregarMaterial();
	    });
        
	};
	
	$scope.pesquisaHistorico = function(material){
		material['login']=$scope.username;
		console.log(material);
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/reparohistorico", material).then(function (response) {
	    	delete $scope.material.serie;
	    	delete $scope.material.observacao;
	    	delete $scope.material.defeito;
			$scope.materialForm.$setPristine();
			carregaHistorico();
	    });
        
	};
	
	$scope.deletarReparo = function (materiais){
		$scope.materiais = materiais.filter(function (material){			
			if (!material.selecionado) return material;
			material['login']=$scope.username;
			$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/reparodelete", material).then(function (response) {		    	
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
	carregarDefeitos();
});