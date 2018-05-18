'use strict';

angular.module('angularJS')
    .factory('projectService', ['$http', function ($http) {
        return {
            /*Muestra todos los project*/
            projects: function () {
                return $http.get('http://localhost:8080/proyecto');
            },
            /*Elimina un project*/
            delProject: function (project) {
                return $http.put('http://localhost:8080/proyecto', project)
            },
            /*Crea un project*/
            addProject: function (project) {
                return $http.post('http://localhost:8080/proyecto', project);
            },
            /*Recupera todos los employees*/
            employees: function () {
                return $http.get('http://localhost:8080/empleado');
            },

            /*Asignar empleado a proyecto*/
            assignEmployee: function (pk) {
                console.log(pk);
                return $http.post('http://localhost:8080/prem',pk);
            }
        }
}]);