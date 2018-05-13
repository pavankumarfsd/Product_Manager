angular.module('AppModule').controller('homeCtrl', ['$scope', '$state', 'ngDialog', 'apiService', function($scope, $state, ngDialog, apiService) {

	var loggedInUser = sessionStorage.getItem("loggedInUser");
	if (loggedInUser) {
		$scope.loggedInUser = JSON.parse(loggedInUser);

		$scope.userProducts = [];
		getUserProducts();

	} else {
		$state.go('login');
	}

	$scope.addProduct = addProduct;
	$scope.editProduct = editProduct;
	$scope.deleteProduct = deleteProduct;

	function getUserProducts() {
		apiService.getProducts($scope.loggedInUser.userId).then(function(res) {
			$scope.userProducts = res;
		});
	}

	function addProduct() {
		ngDialog.open({
			template: './views/product-form.html',
			controller: 'formCtrl',
			resolve: {
				userId: function() {
					return $scope.loggedInUser.userId;
				},
				product: function () {
					return {};
				}
			}
		}).closePromise.then(function() {
			getUserProducts();
		});
	}
	
	function editProduct(product) {
		ngDialog.open({
			template: './views/product-form.html',
			controller: 'formCtrl',
			resolve: {
				userId: function() {
					return $scope.loggedInUser.userId;
				},
				product: function () {
					return product;
				}
			}
		}).closePromise.then(function() {
			getUserProducts();
		});
	}
	
	function deleteProduct(product, index) {
		ngDialog.openConfirm({
			template: '<p>Are you sure you want to delete the product?' + product.name + '</p>' +
                '<div class="ngdialog-buttons text-center">' +
                    '<button type="button" class="btn btn-default" ng-click="closeThisDialog(0)">No</button>&emsp;' +
                    '<button type="button" class="btn btn-danger" ng-click="confirm(1)">Yes</button>' +
                '</div>',
            plain: true
		}).then(function() {
			apiService.deleteProduct($scope.loggedInUser.userId, product.id).then(function() {
				getUserProducts();
			});
		});
	}
}]).controller('formCtrl', ['$scope', 'apiService', 'ngDialog', 'userId', 'product', function($scope, apiService, ngDialog, userId, product) {
	$scope.product = angular.copy(product);

	$scope.onPhotoChange = function(uploadedPic) {
		apiService.imgToStr(uploadedPic).then(function(imgStr) {
			$scope.product.photo = imgStr;
		});
	};

	$scope.saveProduct = function (product) {
		if (product.id) {
			apiService.updateProduct(userId, product).then(function() {
				ngDialog.closeAll();
			});
		} else {
			apiService.saveProduct(userId, product).then(function() {
				ngDialog.closeAll();
			});
		}
	};
}]);
