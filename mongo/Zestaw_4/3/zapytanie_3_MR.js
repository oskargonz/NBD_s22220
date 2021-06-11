var fmapujaca = function(){
    emit(this.job, this.job);
};

var fredukujaca = function(key, values){
    return key;
};

db.people.mapReduce(
    fmapujaca,
    fredukujaca,
    {
        query:{},
        out: { merge: "wyniki_3_MR" },
    }
);

printjson(db.wyniki_3_MR.find().toArray())