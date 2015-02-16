'use strict';

describe('Service: BarangService', function () {

  // load the service's module
  beforeEach(module('belajarOauth2ImplicitClientApp'));

  // instantiate service
  var BarangService;
  beforeEach(inject(function (_BarangService_) {
    BarangService = _BarangService_;
  }));

  it('should do something', function () {
    expect(!!BarangService).toBe(true);
  });

});
