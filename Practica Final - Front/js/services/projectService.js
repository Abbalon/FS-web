'use strict';

angular.module('angularJS')
    .factory('projectService', ['$http', function ($http) {
        return {
            /*Muestra todos los project*/
            projects: function () {
                return $http.get('http://localhost:8080/proyecto');
            },
 /*           /!*Muestra info de un project*!/
            getProjectInfo: function (idPro) {
                return $http.get('http://localhost:8080/proyecto/'+idPro);
            },*/
            /*Elimina un project*/
            delProject: function (project) {
                return $http.put('http://localhost:8080/proyecto', project)
            },
            /*Crea un project*/
            addProject: function (project) {
                return $http.post('http://localhost:8080/proyecto', project);
            }
        }
}]);