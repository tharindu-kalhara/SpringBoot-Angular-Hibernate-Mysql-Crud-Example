<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : ViewUsers
    Created on : Sep 21, 2017, 9:13:33 PM
    Author     : k0712
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>


<!DOCTYPE>
<html>
<head>

    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>JSP Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        var context = '${context}';
    </script>
</head>
<body>

<div class="container" ng-app="sample" ng-controller="viewUserController as vController" ng-init="beforeLoad()">
    <h2>Sample Spring Boot Application</h2>
    <div class="panel panel-default">
        <div class="panel-heading"><h2>View Users</h2></div>

        <div class="panel-body">
            <a data-toggle="modal" data-target="#addUser" class="pull-right btn btn-sm btn-success"> + Add New User </a>
            <table class="table">
                <thead>
                <tr>
                    <th>Count</th>
                    <th>Username</th>
                    <th>Gender</th>
                    <th>NIC</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <tr ng-repeat="user in users">
                    <td>{{$index+1}}</td>
                    <td>{{user.username}}</td>
                    <td ng-if="user.gender == 0">Male</td>
                    <td ng-if="user.gender == 1">Female</td>
                    <td>{{user.nic}}</td>
                    <td>
                        <a class="btn btn-success btn-sm" ng-click="viewUser.getAllUserContact(user.userId,user.username)">View
                        Contacts</a>
                        <a class="btn btn-danger btn-sm" ng-click="deleteUser.delete(user.userId,user.username)">Delete</a>
                    </td>
                </tr>
                </tr>
                </tbody>
            </table>
            <br>

            <div class="row">
                <center>
                    <h3>{{userDec}}</h3>
                    <table class="table" ng-if="contacts != null">
                        <thead>
                        <tr>
                            <th>Contact Count</th>
                            <th>Contact</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="contact in contacts">
                            <td>{{$index+1}}</td>
                            <td>{{ contact.contact }}</td>
                        </tr>
                        </tbody>
                    </table>
                </center>
            </div>


        </div>


        <!-- Modal -->
        <div class="modal fade" id="addUser" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header bg-success">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Add New User</h4>
                    </div>
                    <div class="modal-body">
                        <h2>User Basic Details</h2>
                        <form ng-submit="addUser.addUser()">
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" ng-model="user.username" required class="form-control" id="username">
                            </div>
                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" ng-model="user.password" required class="form-control" id="pwd">
                            </div>

                            <div class="form-group">
                                <label >Genders:</label>
                                <div class="radio">
                                    <label><input ng-model="user.gender" value="0" type="radio"
                                                  name="gender">Male</label>
                                </div>
                                <div class="radio">
                                    <label><input ng-model="user.gender" value="1" type="radio"
                                                  name="gender">Female</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="nic">NIC:</label>
                                <input type="text" ng-model="user.nic" required class="form-control" id="nic">
                            </div>

                            <h2>User Contacts</h2>
                            <div ng-repeat="contact in user.sampleContactCollection">

                                <div class="form-group">
                                    <label>Contact {{$index+1}} <a class="btn btn-danger btn-sm "
                                                                   ng-click="addUser.removeContact($index)">x</a></label>
                                    <input type="text" ng-model="contact.contact" required class="form-control">
                                    <br>
                                </div>

                            </div>
                            <a class="btn btn-warning pull-right " ng-click="addUser.addContactToUser()">+ Contact</a>
                            <br>
                            <br>

                            <button type="submit" class="pull-right btn btn-default">Submit</button>
                            <br>
                            <br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>

    </div>
</div>
<script>
    var sample = angular.module('sample', []);
    sample.controller('viewUserController', ['$scope', '$http', function ($scope, $http) {

        $scope.users, $scope.userDec, $scope.contacts = null;
        $scope.user = {
            sampleContactCollection: [
                {
                    contact: null,
                }
            ]
        };
        $scope.beforeLoad = function () {
            $scope.viewUser.getAllUsers();
        }
        $scope.viewUser = {
            getAllUsers: function () {
                $http({
                    method: 'GET',
                    url: context + '/user/get',
                }).then(function successCallback(response) {
                    if (response.status == 400) {
                        alert('Users Not Found');
                    } else if (response.status == 200) {
                        $scope.users = response.data;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });
            },
            getAllUserContact: function (id, name) {
                $http({
                    method: 'GET',
                    url: context + '/user/get/contact',
                    params: {userId: id}
                }).then(function successCallback(response) {
                    if (response.status == 204) {
                        $scope.userDec = name + "'s Contacts Not Available";
                        $scope.contacts = null;
                    } else if (response.status == 200) {
                        $scope.userDec = name + "'s Contacts";
                        $scope.contacts = response.data;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });
            }
        }

        $scope.addUser = {
            addUser: function () {
                $http({
                    method: 'POST',
                    url: context + '/user/add',
                    data : $scope.user
                }).then(function successCallback(response) {
                    if (response.status == 204) {

                    } else if (response.status == 200) {
                        $scope.user = {
                            sampleContactCollection: [
                                {
                                    contact: null,
                                }
                            ]
                        };
                        alert(response.data.message);
                        $scope.viewUser.getAllUsers();
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });

            },
            addContactToUser: function () {
                $scope.user.sampleContactCollection.push(
                        {
                            contact: null,
                        }
                );
            },
            removeContact: function (index) {
                $scope.user.sampleContactCollection.splice(index, 1);
            }
        }

        $scope.deleteUser = {
            delete: function (id,username) {

                $http({
                    method: 'DELETE',
                    url: context + '/user/delete/'+id
                }).then(function successCallback(response) {
                    if (response.status == 204) {
                        //fail message
                    } else if (response.status == 200) {
                        alert(username+' '+response.data.message);
                        $scope.viewUser.getAllUsers();
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });

            }
        }


    }])
    ;
</script>

</body>
</html>

