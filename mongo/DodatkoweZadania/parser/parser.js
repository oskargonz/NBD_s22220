db.people.find().forEach(function(data) {
    db.people.updateMany({
        "_id": data._id
    }, {
        "$set": {
            "weight": parseFloat(data.weight),
            "height": parseFloat(data.height)
        }
    });
})


db.people.find().forEach(function(data) {
    db.people.updateMany({
        "_id": data._id,
        "height": data.height
    }, {
        "$set": {
            "weight": parseFloat(data.weight)
        }
    });
})