'use strict';

/**
 * @ngdoc overview
 * @name belajarOauth2ImplicitClientApp
 * @description
 * # belajarOauth2ImplicitClientApp
 *
 * Main module of the application.
 */
angular
  .module('belajarOauth2ImplicitClientApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
