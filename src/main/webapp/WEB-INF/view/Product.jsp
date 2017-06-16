<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en-US">
    <head>
        <meta charset="UTF-8" /> 
        <title> Spring MVC 4 REST + AngularJS </title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="ProductController as productCtrl">
            <h1> Spring MVC 4 REST AngularJS </h1>
            <form name="productForm" method="POST">
                <table>
                    <tr><td colspan="2">
                            <div ng-if="productCtrl.flag !== 'edit'">
                                <h3> Add New Product </h3> 
                            </div>
                            <div ng-if="productCtrl.flag === 'edit'">
                                <h3> Update Product for ID: {{ productCtrl.product.id}} </h3> 
                            </div> </td>
                    </tr>
                    <tr>
                        <td>Product Name: </td> <td><input type="text" name="pname" ng-model="productCtrl.product.pname" required/> 
                            <span ng-show="productForm.pname.$error.required" class="msg-val">Product Name is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Price: </td> <td> <input type="text" name="price" ng-model="productCtrl.product.price" required/> 
                            <span ng-show="productForm.price.$error.required" class="msg-val">Price is required.</span> </td>
                    </tr>
                    <tr>
                        <td>Quantity: </td> <td> <input type="text" name="qty" ng-model="productCtrl.product.qty" required/> 
                            <span ng-show="productForm.qty.$error.required" class="msg-val">Quantity is required.</span> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="productCtrl.flag === 'created'" class="msg-success">Product successfully added.</span>
                            <span ng-if="productCtrl.flag === 'failed'" class="msg-val">Product already exists.</span> </td>
                    </tr>
                    <tr><td colspan="2">
                            <div ng-if="productCtrl.flag !== 'edit'">
                                <input  type="submit" ng-click="productCtrl.addProduct()" value="Add Product"/> 
                                <input type="button" ng-click="productCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="productCtrl.flag === 'edit'">
                                <input  type="submit" ng-click="productCtrl.updateProductDetail()" value="Update Product"/> 	
                                <input type="button" ng-click="productCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> <span ng-if="productCtrl.flag === 'deleted'" class="msg-success">Product successfully deleted.</span>
                    </tr>
                </table>     
            </form>
            <table>
                <tr><th>ID </th> <th>Product Name</th> <th>Price</th> <th>Quantity</th></tr>
                <tr ng-repeat="row in productCtrl.products">
                    <td><span ng-bind="row.id"></span></td>
                    <td><span ng-bind="row.pname"></span></td>
                    <td><span ng-bind="row.price"></span></td>
                    <td><span ng-bind="row.qty"></span></td>
                    <td>
                        <input type="button" ng-click="productCtrl.deleteProduct(row.id)" value="Delete"/>
                        <input type="button" ng-click="productCtrl.editProduct(row.id)" value="Edit"/>
                        <span ng-if="productCtrl.flag === 'updated' && row.id === productCtrl.updatedId" class="msg-success">Product successfully updated.</span> </td> 
                </tr>	
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/resources/js/lib/angular.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/lib/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/productapp.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    </body>
</html>