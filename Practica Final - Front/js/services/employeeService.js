'use strict';

angular.module('angularJS')
    .factory('employeeService', ['$http', function ($http) {
        return {
            /*Muestra todos los employees*/
            employees: function () {
                return $http.get('http://localhost:8080/empleado');
            },
            /*Elimina un employee*/
            delEmployee: function (employee) {
                return $http.put('http://localhost:8080/empleado', employee)
            },
            /*Crea un employee*/
            addEmployee: function (employee) {
                console.log("ADD 2");
                console.log(employee);
                return $http.post('http://localhost:8080/empleado', employee);
            }
        }
}]);