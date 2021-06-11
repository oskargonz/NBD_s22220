var fmapujaca = function(){
    emit(this.nationality, {count:1, BMI: (parseFloat(this.weight) / (parseFloat(this.height) * parseFloat(this.height))), MaxBMI:0, MinBMI:100});

};
var fredukujaca = function(key, values){
    reducedValue = {count:0, BMI:0, MaxBMI:0, MinBMI:100};

    for (var i = 0; i < values.length; i++){
        reducedValue.BMI += values[i].BMI;
        reducedValue.count += values[i].count;
        if (reducedValue.MaxBMI < values[i].BMI){
            reducedValue.MaxBMI = values[i].BMI
        };
        if (reducedValue.MinBMI > values[i].BMI){
            reducedValue.MinBMI = values[i].BMI
        };
    }
    return reducedValue;
};

var ffinalizujaca = function (key, reducedValue) {
    reducedValue.BMI_avg = reducedValue.BMI/reducedValue.count;
    return reducedValue;
};


db.people.mapReduce(
    fmapujaca,
    fredukujaca,
    {
        out: { merge: "qgeqrsdvwsacsgergewrg" },
        finalize: ffinalizujaca
    }
);

printjson(db.qgeqrsdvwsacsgergewrg.find().toArray())