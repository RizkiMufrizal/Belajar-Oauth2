/**
 * @ngdoc overview
 * @name belajarOauth2ImplicitClientApp
 * @description
 * # belajarOauth2ImplicitClientApp
 *
 * Main module of the application.
 */

(function() {
  'use strict';
  angular
    .module('belajarOauth2ImplicitClientApp', [
      'ngAnimate',
      'ngAria',
      'ngCookies',
      'ngMessages',
      'ngResource',
      'ngRoute',
      'ngSanitize',
      'ngTouch',
      'ui.router',
      'ngBootbox',
      'ui.select2'
      ])
    .config(function($stateProvider) {

      $stateProvider
        .state('Home', {
          url: '/',
          templateUrl: '../views/main.html',
          controller: 'LoginCtrl',
          controllerAs: 'login'
        })
        .state('About', {
          url: '/About',
          templateUrl: '../views/about.html'
        })
        .state('Barang', {
          url: '/Barang',
          templateUrl: '../views/barang.html',
          controller: 'BarangCtrl',
          controllerAs: 'barang'
        });
    });
})();
