//4.	Lista wszystkich osób znajdujących się w bazie o wadze z przedziału <68, 71.5);

db.people.find({$and:[{"weight":{$gt:"68"}}, {"weight":{$lt:"71.5"}}]})