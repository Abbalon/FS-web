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
            fFin:'',
            empleados:''
        };

        $scope.proInfo = {
            idProyecto:'',
            txDescripcion:'',
            txLugar:'',
            txObservaciones:'',
            fInicio:'',
            fBaja:'',
            fFin:'',
            empleados:''
        };

        $scope.employee = {
            idEmpleado: '',
            txNif: '',
            txNombre: '',
            txApellido1: '',
            txApellido2: '',
            txEmail: '',
            nTelefono1: '',
            fNacimiento: '',
            fAlta: '',
            cxEdocivil: '',
            bServmilitar: ''
        };


        projectService.projects()
            .success(function (data) {
                $scope.projects = data;
            });

        projectService.employees()
            .success(function (data) {
                $scope.allEmployees = data;
            });

        $scope.setProjectInfo = function(project){
            $scope.proInfo = project;
            $scope.employees = project.empleados;
            console.log($scope.employees);
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
                    alert("Proyecto creado correctamente.");
                    $scope.reloadRoute();
                });
        }

        $scope.assignEmployee = function (idPro, idEmp) {
            // $scope.employees.splice()
            $scope.pk= {
                idProyecto: idPro,
                idEmpleado: idEmp
            }
            console.log($scope.pk);
            projectService.assignEmployee($scope.pk)
                .success(function (data) {
                    alert("Asignación correcta.");
                })
        }
    }]);