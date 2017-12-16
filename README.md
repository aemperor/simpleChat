# UnderArmour

Stack Overview
---
* Framework - DropWizard
* Server - Jetty
* REST - Jersey/JaxRs
* Test - JUnit/Mockito

How to start the UnderArmour application
---
1. Set the DATABASE_URL environment variable to `"postgres://fhvequzhzcsbls:6e9dcc2e81b055bd7b9772eadd4f78be036e0bc17bd8d4efc4a1e2c7ac7e4401@ec2-107-22-211-182.compute-1.amazonaws.com:5432/de0hih3bm64i62"` i.e. <br>
`export DATABASE_URL="postgres://fhvequzhzcsbls:6e9dcc2e81b055bd7b9772eadd4f78be036e0bc17bd8d4efc4a1e2c7ac7e4401@ec2-107-22-211-182.compute-1.amazonaws.com:5432/de0hih3bm64i62"`
1. Run `mvn clean install` to download dependencies
1. Run `mvn package` to create the jar
1. Start application with `java -jar target/UnderArmour-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Tests
---
* To run tests, run `mvn test`

Resources
---
- `[POST] /chat` - Creates a chat object. <br>
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
- `[GET] /chat/{id}` - Retrieves a chat object by id.
<br> <br><b>Example Response</b>

```json
[
    {
        "id": 433961,
        "text": "hello",
        "username": "user1",
        "expirationDate": "2017-12-16 22:07:29 PM UTC"
    }
]

```
- `[GET] /chat/user/{username}` - Retrieves a list of unexpired chats for the username.
<br><br> <b>Example Response</b>

```json
[
    {
        "id": 136219,
        "text": "hello"
    },
    {
        "id": 255622,
        "text": "hello"
    },
    {
        "id": 7752,
        "text": "hello"
    },
    {
        "id": 399944,
        "text": "hello"
    },
    {
        "id": 305906,
        "text": "hello"
    },
    {
        "id": 410662,
        "text": "hello"
    }
]
```

