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
      //redirect ke page login authorization
      $window.location.href = login.oauth2Url;
    }

    function getToken() {
      login.hashToken = $location.hash('');

      console.log(login.hashToken.$$path);

      //cek apa di url terdapat token
      if (!login.hashToken.$$path) {
        return;
      }

      login.pathUrl = login.hashToken.$$path.split('&')[0].replace('/', '');
      console.log(login.pathUrl);

      if (login.pathUrl.split('=')[0] === 'access_token') {
        console.log(login.pathUrl.split('=')[1]);

        $window.sessionStorage.setItem('token', login.pathUrl.split('=')[1]);
      }

    }

    function checkLogin() {

      //cek token di session storage dulu
      if ($window.sessionStorage.getItem('token')) {
        console.log('token ada');

        //redirect ke home page
        $window.location.href = 'http://localhost:8000/index#/';

        return;
      }

      //jika token di session storage masih kosong, cek url apakah terdapat access token
      getToken();

      //jika tidak ada token di session storage dan di url lakukan redirect ke page login authorization server
      loginUser();
    }

    //ketika statrup aplikasi lakukan pengecekan token user
    checkLogin();

  }

})();
