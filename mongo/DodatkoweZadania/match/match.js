db.people.aggregate(
    [{$match:{"sex":"Male"}}]
)