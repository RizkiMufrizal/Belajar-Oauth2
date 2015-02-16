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
      BarangFactory.getAllBarang().query({}, function(data) {
        barang.dataBarang = data;
      });
    }

    refreshBarang();

  }

})();
