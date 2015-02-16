/**
 * @ngdoc function
 * @name belajarOauth2ImplicitClientApp.controller:BarangcontrollerCtrl
 * @description
 * # BarangcontrollerCtrl
 * Controller of the belajarOauth2ImplicitClientApp
 */
(function() {
  'use strict';

  angular.module('belajarOauth2ImplicitClientApp')
    .controller('BarangCtrl', BarangCtrl);
  BarangCtrl.$inject = ['$location', 'BarangFactory', '$window'];

  function BarangCtrl($location, BarangFactory, $window) {

    var barang = this;

    barang.coba = 'hello word';

    function refreshBarang() {

      if (!$window.sessionStorage.getItem('token')) {
        console.log('token belum ada, silahkan login dulu');
      }

      BarangFactory.getAllBarang($window.sessionStorage.getItem('token')).query({}, function(data) {
        barang.dataBarang = data;
      });
    }

    refreshBarang();

  }

})();
