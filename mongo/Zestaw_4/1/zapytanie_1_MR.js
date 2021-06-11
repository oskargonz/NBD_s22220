var fmapujaca = function(){
    emit(this.sex, {count:1, height: parseFloat(this.height), weight: parseFloat(this.weight)});
};

var fredukujaca = function(key, values){
    reducedValue = {height:0, weight:0, count:0};

    for (var i = 0; i < values.length; i++){
        reducedValue.height += values[i].height;
        reducedValue.weight += values[i].weight;
        reducedValue.count += values[i].count;
    }
    return reducedValue;

};

var ffinalizujaca = function (key, reducedValue) {
    reducedValue.height_avg = reducedValue.height/reducedValue.count;
    reducedValue.weight_avg = reducedValue.weight/reducedValue.count;
    return reducedValue;
};

db.people.mapReduce(
    fmapujaca,
    fredukujaca,
{
    out: { merge: "wyniki_1_MR" },
    finalize: ffinalizujaca
}
);

printjson(db.wyniki_1_MR.find().toArray())