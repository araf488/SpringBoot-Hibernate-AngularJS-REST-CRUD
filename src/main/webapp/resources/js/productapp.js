
'use strict';
var app = angular.module('myApp', ['ngResource']);

angular.module('myApp').factory('Product', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/Spring4RESTAngularJS/product/:productId', {productId: '@id'},
	{
		updateProduct: {method: 'PUT'}
	}
    );
}]);

angular.module('myApp').controller('ProductController', ['$scope', 'Product', function($scope, Product) {
    var ob = this;
    ob.products=[];
    ob.product = new Product(); 
    ob.fetchAllProducts = function(){
        ob.products = Product.query();
    };
    ob.fetchAllProducts();
    ob.addProduct = function(){
	console.log('Inside save');
	if($scope.productForm.$valid) {
	  ob.product.$save(function(product){
	     console.log(product); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllProducts();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editProduct = function(id){
	    console.log('Inside edit');
        ob.product = Product.get({ productId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateProductDetail = function(){
	console.log('Inside update');
	if($scope.productForm.$valid) {
    	   ob.product.$updateProduct(function(product){
    		console.log(product); 
		ob.updatedId = product.id;
				ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllProducts();
           });
	}
    };	
    ob.deleteProduct = function(id){
	    console.log('Inside delete');
	    ob.product = Product.delete({ productId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllProducts(); 
	    });
    };		
    ob.reset = function(){
    	ob.product = new Product();
        $scope.productForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.product = new Product();
	    ob.flag= '';	
   	    ob.fetchAllProducts();
    };    
}]);    
   