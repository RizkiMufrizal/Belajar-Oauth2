'use strict';

describe('Controller: BarangCtrl', function() {

  // load the controller's module
  beforeEach(module('belajarOauth2ImplicitClientApp'));

  var BarangCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function($controller, $rootScope) {
    scope = $rootScope.$new();
    BarangCtrl = $controller('BarangCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function() {});
});
