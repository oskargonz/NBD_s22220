db.people.aggregate([
        {$match:{$and:[{"sex":"Female"}, {"nationality":"Poland"}]}},
        {$unwind:"$credit"},
        {
            $group:{
                _id: "$credit.currency",
                totalMoney:{$sum: {$toDouble: "$credit.balance"}},
                avgMoney:{$avg: {$toDouble: "$credit.balance"}}
            }
        }
    ]
)