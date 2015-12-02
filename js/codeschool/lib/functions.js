exports.runAway = function() {
  var toAlert = "";
  for (var i = 0; i < 5; i++) {
      toAlert = toAlert + "Lions, Tigers, and Bears, Oh My!!\n";
  }
  alert(toAlert);
};

exports.fearGenerated = function(numPeeps, rainInInches, numSharks) {
  var rainFear = numPeeps * rainInInches;
  var sharkFear = numSharks * numSharks * numSharks;
  var totalFear = sharkFear + rainFear;
  return totalFear;
};

exports.fearMessage = function(fear) {
    var message = "";
    if (fear < 200) {
        message += "LOW\nStill wanna ride?";
    } else if (fear <= 300) {
        message += "MEDIUM\nThink you'll make it?";
    } else {
        return message;
    }
    message = "Fear Level: " + message;
    return message;
};
