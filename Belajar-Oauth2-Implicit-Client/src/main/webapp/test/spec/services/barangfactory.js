'use strict';

describe('Service: BarangFactory', function() {

  // load the service's module
  beforeEach(module('belajarOauth2ImplicitClientApp'));

  // instantiate service
  var BarangFactory;
  beforeEach(inject(function(_BarangFactory_) {
    BarangFactory = _BarangFactory_;
  }));

  it('should do something', function() {
    expect(!!BarangFactory).toBe(true);
  });

});
