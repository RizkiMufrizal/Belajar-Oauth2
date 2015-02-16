/**
 * @ngdoc function
 * @name belajarOauth2ImplicitClientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the belajarOauth2ImplicitClientApp
 */

(function() {
  'use strict';

  angular.module('belajarOauth2ImplicitClientApp')
    .controller('LoginCtrl', LoginCtrl);
  LoginCtrl.$inject = ['$location', '$window'];

  function LoginCtrl($location, $window) {
    var login = this;

    login.oauth2Url = 'http://localhost:8002/oauth/authorize?client_id=jsclient&response_type=token&scope=write';

    function loginUser() {
      $window.location.href = login.oauth2Url;
    }

    function checkLogin() {
      if ($window.sessionStorage.getItem('token')) {
        return;
      }

      loginUser();
    }

    checkLogin();

  }

})();
