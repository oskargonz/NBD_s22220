db.people.aggregate([
        {
            $group:{
                _id: "$nationality",
                avgBMI:{$avg:{$divide:[{$toDouble:"$weight"}, {$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"}]}]}},
                minBMI:{$min:{$divide:[{$toDouble:"$weight"}, {$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"}]}]}},
                maxBMI:{$max:{$divide:[{$toDouble:"$weight"}, {$multiply:[{$toDouble:"$height"}, {$toDouble:"$height"}]}]}}
            }
        }
    ]
)