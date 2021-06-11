db.people.aggregate([
        {
            $group:{
                _id: "$nationality",
                avgBMI:{$avg:{$divide:["$weight", {$multiply:["$height", "$height"]}]}},
                minBMI:{$min:{$divide:["$weight", {$multiply:["$height", "$height"]}]}},
                maxBMI:{$max:{$divide:["$weight", {$multiply:["$height", "$height"]}]}}
            }
        }
    ]
)