'use strict';

/*Config*/
angular.module("angularJS")
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/employee', { //view mostrar
            templateUrl: 'view/showEmployees.html',
            controller: 'EmployeesCtrl'
        });
    }])

    /*Controllers*/
    /**Empleado*/
    .controller('EmployeesCtrl',
      ['$scope', '$route', 'employeeService', function (
          $scope, $route, employeeService) {

        /*Function to refresh page*/
        $scope.reloadRoute = function() {
            $route.reload();
        }

        $scope.date = new Date();

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

        $scope.delEmployee = function (employee) {
            console.log(employee);
            employeeService.delEmployee(employee)
                .success(function (data) {
                    $scope.reloadRoute();
            });
        }

        employeeService.employees()
            .success(function (data) {
                $scope.employees = data;
            });

        $scope.addEmployee = function () {
            console.log("ADD");
            console.log($scope.employee);
            employeeService.addEmployee($scope.employee)
                .then(function (data) {
                    $scope.reloadRoute();
                });
        }
    }]);
