var app =angular.module("AppModule",['ui.router','ngDialog']);
app.config(['$stateProvider', '$urlRouterProvider',function ($stateProvider, $urlRouterProvider){
	$stateProvider.state({
		name:'login',
		url:'/login',
		controller : 'loginCtrl',
		templateUrl:"views/auth/login.html"
	}).state({
		name:'home',
		url:'/home',
		controller : 'homeCtrl',
		templateUrl:"views/home.html"
	});
	$urlRouterProvider.otherwise('/login');
}]);
