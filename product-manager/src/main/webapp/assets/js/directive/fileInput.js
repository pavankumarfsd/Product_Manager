angular.module('AppModule').directive("filesInput", function() {
	return {
		require: "ngModel",
		link: function postLink(scope,elem,attrs,ngModel) {
			elem.on("change", function(e) {
				var files = elem[0].files;
				if (attrs.multiple) {
					ngModel.$setViewValue(files);
				} else {
					ngModel.$setViewValue(files[0]);
				}
			});
		}
	};
});