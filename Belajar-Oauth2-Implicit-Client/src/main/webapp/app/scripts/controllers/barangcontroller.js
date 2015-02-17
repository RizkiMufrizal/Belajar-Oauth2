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

    barang.inputanBarang = {};
    barang.enable = true;
    barang.dataBarang = {};

    barang.getBarang = function() {
      if (!$window.sessionStorage.getItem('token')) {
        console.log('token belum ada, silahkan login dulu');
      }

      BarangFactory.getAllBarang($window.sessionStorage.getItem('token')).query({}, function(data) {
        barang.dataBarang = data;
      });
    };

    function refreshBarang() {

      if (!$window.sessionStorage.getItem('token')) {
        console.log('token belum ada, silahkan login dulu');
      }

      BarangFactory.getAllBarang($window.sessionStorage.getItem('token')).query({}, function(data) {
        barang.dataBarang = data;
      });
    }

    refreshBarang();

    barang.saveBarang = function(b) {
      BarangFactory.saveBarang($window.sessionStorage.getItem('token')).query({}, b).$promise.then(function() {
        refreshBarang();
      });
    };

    barang.clear = function() {
      barang.inputanBarang.idBarang = '';
      barang.inputanBarang.namaBarang = '';
      barang.inputanBarang.jenisBarang = '';
      barang.inputanBarang.tanggalKadaluarsa = '';
      barang.enable = false;
    };

    barang.editBarang = function(b) {
      barang.inputanBarang.idBarang = b.idBarang;
      barang.inputanBarang.namaBarang = b.namaBarang;
      barang.inputanBarang.jenisBarang = b.jenisBarang;
      barang.inputanBarang.tanggalKadaluarsa = b.tanggalKadaluarsa;
      barang.enable = true;
    };

    barang.updateBarang = function(b) {
      BarangFactory.updateBarang($window.sessionStorage.getItem('token')).query({}, b).$promise.then(function() {
        refreshBarang();
      });
    };

    barang.deleteBarang = function(b) {
      BarangFactory.deleteBarang(b.idBarang, $window.sessionStorage.getItem('token')).query({}).$promise.then(function() {
        refreshBarang();
      });
    };

    barang.jenisBarangCombo = [
      {
        'jenis': 'Cair',
        'value': 'CAIR'
      },
      {
        'jenis': 'Gas',
        'value': 'GAS'
      },
      {
        'jenis': 'Padat',
        'value': 'PADAT'
      }
    ];

  }

})();
