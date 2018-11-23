angular.module("infoCq").controller("infoCqCtrl",function($scope, $http){
	$scope.app = "Informações de C.Q";
	$scope.materiais = [];
	$scope.statuscqs = [];
	
	$scope.data = new Date();
	$scope.username = localStorage.getItem("username");
	
	var carregarMaterial = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/cq").then(function (response) {
	    	$scope.materiais = response.data;
	    });
	};
	
	var carregaHistorico = function () {
	    $http.get("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/cqhistorico").then(function (response) {
	    	$scope.materiais = response.data;
	    });
	};
	
	var carregarStatus = function () {
	    $http.get('lib/json/defeitos.json').then(function (response) {
	    	$scope.statuscqs = response.data;
	    });
	};
	
	$scope.adicionarCq = function(material){
		material['login']=$scope.username;
		console.log(material);
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/cq", material).then(function (response) {
	    	delete $scope.material.serie;
	    	delete $scope.material.observacao;
	   
			$scope.materialForm.$setPristine();
			carregarMaterial();
	    });
        
	};
	
	$scope.pesquisaHistorico = function(material){
		material['login']=$scope.username;
		console.log(material);
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/cqhistorico", material).then(function (response) {
	    	delete $scope.material.serie;
	    	delete $scope.material.observacao;
	    	delete $scope.material.defeito;
			$scope.materialForm.$setPristine();
			carregaHistorico();
	    });
        
	};
	
	$scope.deletarCq = function (materiais){
		$scope.materiais = materiais.filter(function (material){			
			if (!material.selecionado) return material;
			material['login']=$scope.username;
			$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/cqdelete", material).then(function (response) {		    	
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
});