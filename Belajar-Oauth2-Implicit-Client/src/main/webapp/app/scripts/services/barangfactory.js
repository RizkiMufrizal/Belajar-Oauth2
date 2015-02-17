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
      return $resource(BarangService.getBarangAll + token);
    };

    barangFactory.saveBarang = function(token) {
      return $resource(BarangService.saveBarang + token, {}, {
        query: {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    barangFactory.updateBarang = function(token) {
      return $resource(BarangService.updateBarang + token, {}, {
        query: {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    barangFactory.deleteBarang = function(idBarang, token) {
      return $resource(BarangService.deleteBarang(idBarang) + token, {}, {
        query: {
          method: 'DELETE',
          headers: {
            'Content-Type': 'application/json'
          }
        }
      });
    };

    return barangFactory;
  }
})();
