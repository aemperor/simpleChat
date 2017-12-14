# UnderArmour

How to start the UnderArmour application
---

1. Run `mvn clean install` to download dependencies
1. Run `mvn package` to create the jar
1. Start application with `java -jar target/UnderArmour-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Resources
---
- [POST] /chat - Creates a chat object. <br>
 <br><b>Example request: </b><br>
```json
{
	"user": "user1", 
	"text": "hello"
}
```
<br><b> Example Response</b> <br>

```json
{
	"id": 0001
}
```
- [GET] /chat/{id} - Retrieves a chat object by id.
<br> <br><b>Example Response</b>

```json
[
	{
		"id": 36256,
		"text": "hello",
		"user": "user1",
		"expiration": 1513233720268
	}
]

```
- [GET] /chat/user/{username} - Retrieves a list of unexpired chats for the username.
<br><br> <b>Example Response</b>

```json
[
    {
        "id": 205533,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289431694
    },
    {
        "id": 143633,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289433084
    },
    {
        "id": 905733,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289433772
    },
    {
        "id": 398539,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289433979
    },
    {
        "id": 790527,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289434170
    },
    {
        "id": 642454,
        "user": "user1",
        "text": "hello",
        "expiration": 1513289434587
    }
]
```

