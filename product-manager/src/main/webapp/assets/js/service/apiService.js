angular.module('AppModule').service('apiService', ['$http', '$q', function($http, $q) {
	return {
		login: login,
		getProducts: getProducts,
		saveProduct: saveProduct,
		updateProduct: updateProduct,
		deleteProduct: deleteProduct,
		imgToStr: imgToStr
	};
	
	function login(user) {
		return $http.post('./api/login', user).then(function(res) {
			return res.data.response;
		});
	}
	
	function getProducts(userId) {
		return $http.get('./api/products/user/' + userId).then(function(res) {
			return res.data.response;
		});
	}
	
	function saveProduct(userId, product) {
		return $http.post('./api/products/user/' + userId, product).then(function(res) {
			return res.data.response;
		});
	} 
	
	function updateProduct(userId, product) {
		return $http.put('./api/products/user/' + userId, product).then(function(res) {
			return res.data.response;
		});
	}
	
	function deleteProduct(userId, productId) {
		return $http['delete']('./api/products/user/' + userId + '/' + productId).then(function(res) {
			return res.data.response;
		});
	}
	
	function imgToStr(photo) {
		var defer = $q.defer();
        var reader = new FileReader();
        reader.onloadend = function (e) {
            defer.resolve(e.target.result);
        };   
        reader.readAsDataURL(photo);
        return defer.promise;
	}
}]);