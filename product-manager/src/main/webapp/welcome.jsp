<!DOCTYPE html>
<html ng-app="AppModule">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>MedicalShop</title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/ng-dialog.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/app.css" />
	</head>
	
	<body>
		<ui-view></ui-view>
	</body>
	
	
	<!-- Libs -->
	<script type="text/javaScript" src="./assets/js/lib/angular.min.js"></script>
	<script type="text/javaScript" src="./assets/js/lib/angular-ui-router.min.js"></script>
	<script type="text/javaScript" src="./assets/js/lib/ngDialog.min.js"></script>

	<!-- Module -->
	<script type="text/javascript" src="./assets/js/app.js"></script>

	<!-- Controllers -->
	<script type="text/javascript" src="./assets/js/controller/loginCtrl.js"></script>
	<script type="text/javascript" src="./assets/js/controller/homeCtrl.js"></script>

	<script type="text/javascript" src="./assets/js/directive/fileInput.js"></script>
	<!-- Services -->			
	<script type="text/javascript" src="./assets/js/service/apiService.js"></script>
</html>