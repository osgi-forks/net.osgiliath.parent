'use strict';

describe('Controller: myController', function () {

  // load the controller's module
  beforeEach(module('myApp'));

  var scope, mockedService;
  var myCtrl;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    myCtrl = $controller('myController', {
      $scope: scope,
      stompservice: mockedService
    });
  }));

  it('should attach the myMessage', function () {
//    expect(scope.helloMessage).toBe('');
  });
});
