db.people.aggregate(
    [{$project:{
        "_id":0,
            "nowePole":"$weight",
            "heightDouble":{$multiply:["$height", 2]}


        }
    }
    ]
)