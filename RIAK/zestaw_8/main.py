import json
import requests

urlBasic = 'http://localhost:8098/buckets/s22220/keys/'

headers = {'Content-Type': 'application/json'}

def myRead(key):
    urlAddress = urlBasic + str(key)
    return requests.get(urlAddress)

def myPut(key, doc):
    urlAddress = urlBasic + str(key)
    body = json.dumps(doc)
    return requests.put(urlAddress, headers=headers, data=body)

def myDelete(key):
    urlAddress = urlBasic + str(key)
    return requests.delete(urlAddress)

if __name__ == '__main__':
    myInput = {"index":5,"isActive":True,"balance":21449.53,"age":28,"name":"Janusz Kowalski"}

    myOutput = open("komunikaty.txt", "w")

    putOutput = myPut("Janusz", myInput)
    myOutput.write(str(myRead("Janusz").content)+ '\n')

    myPut("Janusz", {"index":5,"isActive":True,"balance":0.53,"age":29,"name":"Janusz Kowalski"})
    myOutput.write(str(myRead("Janusz").content)+ '\n')

    deleteResult = myDelete("Janusz")
    myOutput.write(str(myRead("Janusz").content) + '\n')

    myOutput.close()