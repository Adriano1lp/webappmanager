angular.module("login").controller("loginCtrl",function($scope, $http){
	$scope.app = "Login";
	

	$scope.usuario = [];
	var usuario = "";
	var status = "";
	var perfil = "";

	$scope.submitLogin = function(login){
		$http.post("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/login", login).then(function (response) {
	    	delete $scope.login;
			$scope.loginForm.$setPristine();
			$scope.usuario = response.data;
			status = $scope.usuario[0].status;
			usuario = $scope.usuario[0].usuario;
			perfil = $scope.usuario[0].perfil;
			if(perfil === 'true'){
				window.location.replace("http://localhost:8080/appoficial-0.0.1-SNAPSHOT/home.html");
			}
			localStorage.setItem("username", usuario);
			localStorage.setItem("status", status );
			console.log($scope.usuario);
			console.log(status)
			
	    });
        
	};
});

