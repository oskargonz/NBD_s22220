db.people.aggregate(
    [
        {
            $group: {
                _id: null,
                totalWaga: {$avg: {$toDouble:"$weight"}},
                maxWaga: {$max: {$toDouble:"$weight"}},
                minWaga: {$min: {$toDouble:"$weight"}},
                avgWaga: {$avg: {$toDouble:"$weight"}}
            }
        }
    ]
)
