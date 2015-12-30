exports.clone = function(obj1) {
    var obj2 = {};
    for (var k in obj1){
        if (obj1.hasOwnProperty(k)) {
            obj2[k] = obj1[k]
        }
    }
    return obj2;
};
