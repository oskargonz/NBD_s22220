//6.	Dodaj siebie do bazy, zgodnie z formatem danych użytych dla innych osób (dane dotyczące karty kredytowej, adresu zamieszkania i wagi mogą być fikcyjne);

db.people.insertOne({
    "birth_date": "1995-07-04T16:10:58Z",
    "credit": [
        {
            "type": "jcb",
            "number": "4017975370327",
            "currency": "PLN",
            "balance": "6666.66"
        }
    ],
    "description": "bla bla bla",
    "email": "oskarjobs@gmail.com",
    "first_name": "Oskar",
    "height": "184.45",
    "job": "Senior Consultant",
    "last_name": "Gasior",
    "location": {
        "city": "Warsaw",
        "address": {
            "streetname": "Polna",
            "streetnumber": "11"
        }
    },
    "nationality": "Poland",
    "sex": "Male",
    "weight": "75.65"})