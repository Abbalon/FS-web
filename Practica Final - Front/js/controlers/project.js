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

        $scope.proInfo = {
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

        $scope.getProjectInfo = function(project){
            console.log(project);
            $scope.proInfo = project;
            console.log($scope.proInfo.txDescripcion);
        }

        $scope.delProject = function (project) {
            projectService.delProject(project)
                .success(function (data) {
                    $scope.reloadRoute();
            });
        }

        $scope.addProject = function () {
            projectService.addProject($scope.project)
                .then(function (data) {
                    $scope.reloadRoute();
                });
        }
    }]);