/**
 * @ngdoc service
 * @name belajarOauth2ImplicitClientApp.BarangFactory
 * @description
 * # BarangFactory
 * Factory in the belajarOauth2ImplicitClientApp.
 */

(function() {
  'use strict';
  angular.module('belajarOauth2ImplicitClientApp')
    .factory('BarangFactory', BarangFactory);

  BarangFactory.$inject = ['$resource'];

  function BarangFactory($resource) {
    var barangFactory = this;

    barangFactory.getAllBarang = function() {
      return $resource('/api/barang');
    };

    return barangFactory;
  }
})();
