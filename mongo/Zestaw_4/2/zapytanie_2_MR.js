var fmapujaca = function(){
     for (var idx = 0; idx < this.credit.length; idx++) {
             var key = this.credit[idx].currency;
             var value = {balance: parseFloat(this.credit[idx].balance) };
             emit(key, value);
         }
 };
var fredukujaca = function(key, values){
     reducedValue = {balance:0};
     for (var i = 0; i < values.length; i++){
             reducedValue.balance += values[i].balance;
         }
     return reducedValue;
 };


 db.people.mapReduce(
         fmapujaca,
         fredukujaca,
         {
                 query:{},
         out: { merge: "wyniki_2_MR" }
     }
 );

 printjson(db.wyniki_2_MR.find().toArray())