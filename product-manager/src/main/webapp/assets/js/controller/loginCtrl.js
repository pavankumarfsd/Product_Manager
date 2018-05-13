angular.module('AppModule').controller('loginCtrl', ['$scope', '$state', 'apiService', function($scope, $state, apiService) {

	$scope.loginObj = {
		userId: 'user1',
		password: 'pass123'
	};
	$scope.submitLogin = submitLogin;
	
	function submitLogin() {
		apiService.login($scope.loginObj).then(function(res) {
			if (res === true) {
				sessionStorage.setItem('loggedInUser', JSON.stringify($scope.loginObj));
				$state.go('home');
			} else {
				$scope.loginMsg = "Invalid credentials";
			}
		});
	}
}]);
