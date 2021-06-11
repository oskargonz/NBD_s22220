
var fmapujaca = function(){
    for (var idx = 0; idx < this.credit.length; idx++) {
        var key = this.credit[idx].currency;
        var value = {count:1, balance: parseFloat(this.credit[idx].balance) };
        emit(key, value);


    }
};
var fredukujaca = function(key, values){
    reducedValue = {count:0, balance:0};

    reducedValue.balance += values[i].balance;
    reducedValue.count += values[i].count;
    return reducedValue;
};

var ffinalizujaca = function (key, reducedValue) {
    reducedValue.balance_avg = reducedValue.balance/reducedValue.count;
    return reducedValue;
};

db.people.mapReduce(
    fmapujaca,
    fredukujaca,
    {
        out: { merge: "ascacaqg" },
        finalize: ffinalizujaca
    }
);

printjson(db.ascacaqg.find().toArray())