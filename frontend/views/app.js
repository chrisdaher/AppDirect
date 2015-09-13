var myApp = angular.module('appDirect', []);

myApp.controller('subscription', [ '$scope', '$http', '$q', function($scope, $http, $q){
	var pathToApi = "http://104.197.105.11:5001/subscription/subscriptions";
	
	$scope.subs = [];
	$scope.getSubscriptions = function(){
		var deferred = $q.defer();
		$http.get(pathToApi).success(function(data) {
			$scope.subs = data;
		});
		return deferred.promise;
	};
	
	$scope.getSubscriptions();
	
}]);