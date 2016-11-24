'use strict';

var moment = require('moment-timezone');
//var TimeShift = require('timeshift-js')

describe('timezone testing', function() {
  var hourInNY = null;
  var hourHere = null;
  var hourInDocker = null;
  beforeEach(function() {
    hourInNY = moment(new Date()).tz('America/New_York').format('HH');
    hourInDocker = moment(new Date()).tz('America/Los_Angeles').format('HH');
    hourHere = moment(new Date()).format('HH');
    moment.tz.guess();

  });

  it('would not use the timezone you want', function() {
    browser.get('http://10.27.15.107:3000/static');
    expect(element(by.model('ctrl.model.currentDate')).getAttribute('value')).not.toBe(hourHere);
    expect(element(by.model('ctrl.model.currentDate')).getAttribute('value')).toBe(hourInDocker);
    expect(element(by.model('ctrl.model.dateInNY')).getAttribute('value')).toBe(hourInNY);
  });

  it('would not use the timezone if you set as default either', function() {
    browser.get('http://10.27.15.107:3000/static');
    expect(element(by.model('ctrl.model.currentDate')).getAttribute('value')).toBe(hourInNY);
    expect(element(by.model('ctrl.model.dateInLA')).getAttribute('value')).toBe(hourInNY);
  });

});
