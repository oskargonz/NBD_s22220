//10.	Usuń u wszystkich osób o zawodzie „Editor” własność „email”.

db.people.updateMany({"job":"Editor"}, {$unset:{"email":1}})
