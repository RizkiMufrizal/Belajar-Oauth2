/**
 * @ngdoc service
 * @name belajarOauth2ImplicitClientApp.BarangService
 * @description
 * # BarangService
 * Service in the belajarOauth2ImplicitClientApp.
 */

(function() {
  'use strict';
  angular.module('belajarOauth2ImplicitClientApp')
    .service('BarangService', BarangService);

  function BarangService() {
    var barangServiceUrl = this;

    barangServiceUrl.getBarangAll = 'http://localhost:8001/api/barang?access_token=';
    barangServiceUrl.saveBarang = 'http://localhost:8001/api/SaveBarang?access_token=';
    barangServiceUrl.updateBarang = 'http://localhost:8001/api/UpdateBarang?access_token=';
    barangServiceUrl.deleteBarang = function(idBarang) {
      return '/api/DeleteBarang/' + idBarang + '?access_token=';
    };

    return barangServiceUrl;
  }

})();
