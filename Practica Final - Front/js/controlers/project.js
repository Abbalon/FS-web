'use strict';

/*Config*/
angular.module("angularJS")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/project', { //view project
            templateUrl: 'view/showProjects.html',
            controller: 'ProjectsCtrl'
        });
    }])

    /*Controllers*/
    /**Empleado*/
    .controller('ProjectsCtrl', ['$scope', '$route', 'projectService', function ($scope, $route, projectService) {

        /*Function to refresh page*/
        $scope.reloadRoute = function() {
            $route.reload();
        }

        $scope.date = new Date();

        $scope.project = {
            idProyecto:'',
            txDescripcion:'',
            txLugar:'',
            txObservaciones:'',
            fInicio:'',
            fBaja:'',
            fFin:''
        };

        projectService.projects()
            .success(function (data) {
                $scope.projects = data;
            });
        $scope.delProject = function (project) {
            console.log(project);
            projectService.delProject(project)
                .success(function (data) {
                    $scope.reloadRoute();
            });
        }

        $scope.addProject = function () {
            console.log("ADD");
            console.log($scope.project);
            projectService.addProject($scope.project)
                .then(function (data) {
                    $scope.reloadRoute();
                });
        }
    }]);