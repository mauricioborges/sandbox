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

exports.fullNaming = function(namesArray){
    
    return namesArray?namesArray.join(" "):"";
};

exports.adventureSelector = function (userChoice) {
  switch (userChoice) {
    case 1:
      return function(){alert("You selected the Vines of Doom!");};
    case 2:
      return function(){alert("Looks like you want the Lake of Despair!");};
    case 3:
      return function(){alert("The Caves of Catastrophe!");};
  }
}

