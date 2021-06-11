//Zastąp nazwę miasta „Moscow” przez „Moskwa” u wszystkich osób w bazie;

db.people.updateMany({"location.city":"Moscow"}, {$set:{"location":{"city":"Moskwa"}}})