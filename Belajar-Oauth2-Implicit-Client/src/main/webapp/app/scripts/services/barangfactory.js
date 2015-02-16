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

  BarangFactory.$inject = ['$resource', 'BarangService'];

  function BarangFactory($resource, BarangService) {
    var barangFactory = this;

    barangFactory.getAllBarang = function(token) {
      console.log(BarangService.getBarangAll);
      return $resource(BarangService.getBarangAll + token);
    };

    return barangFactory;
  }
})();
