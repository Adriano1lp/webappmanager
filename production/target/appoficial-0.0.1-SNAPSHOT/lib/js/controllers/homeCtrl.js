angular.module('lazyLoadApp').config(['$ocLazyLoadProvider', '$stateProvider', '$urlRouterProvider' , function($ocLazyLoadProvider, $stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise("/div");
	
	//Config For ocLazyLoading
	$ocLazyLoadProvider.config({
		'debug': true, // For debugging 'true/false'
		'events': true, // For Event 'true/false'
		'modules': [{ // Set modules initially
			name : 'div1', //  module div 1
			files: ['lib/div/controllers/adicionaMaterialCtrl.js']
		},{
			name : 'div2', //  module div 2
			files: ['lib/div/controllers/adicionaModeloCtrl.js']
		},{
            name : 'div3',
            files: ['lib/div/controllers/infoCqCtrl.js'] 
        },{
			name : 'div4',
			files: ['lib/div/controllers/infoReparoCtrl.js']
		}]
	});

	//Config/states of UI Router
	$stateProvider
	.state('div1', {
		url: "/div",
		views : {
			"" : {
				templateUrl:"lib/div/material.html"
			}
		},
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load('div1'); // Resolve promise and load before view 
			}]
		}
	})
	.state('div2', {
		url: "/div",
		views : {
			"" : {
				templateUrl:"lib/div/modelo.html"
			}
		},
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad) {
				return $ocLazyLoad.load('div2'); // Resolve promise and load before view 
			}]
		}
    })
    .state('div3',{
        url: "/div",
        views : {
            "" : {
                templateUrl:"lib/div/cq.html"
            }
        },
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad){
                return $ocLazyLoad.load('div3');
            }]
        }
	})
	.state('div4',{
		url: "/dv",
		views : {
			"" : {
				templateUrl:"lib/div/reparo.html"
			}
		},
		resolve: {
			loadMyCtrl: ['$ocLazyLoad', function($ocLazyLoad){
				return $ocLazyLoad.load('div4');
			}]
		}
	});
}]);