## Local development

In order to run the application run the command below and replace `Port` with desired port number

```
docker build -t purple-cow . && docker run -p {Port}:3000 purple-cow
```

Navigate to localhost:{Port}/swagger-ui.html if you prefer to use swagger for testing

# API Endpoint /items
## items   GET
Returns a list of all items from database in JSON.

## items/update-all   POST
Accepts list of JSON body and adds to database.

## items/delete-all   DEL
Deletes all Items in the database.

## items/{id}  GET
Returns a single Item linked with id from database in JSON

## items/update/{id}    PUT
Accepts JSON Body linked with {id} and updates resource in database.

## items/delete/{id}   DEL
Deletes Item linked with id in the database.

## Assumptions
- Using a SQL database

## Nice To Haves
- Database persisted with Dockerfile through Makefile
- Added Actuator for health check
- Added Swagger documentation

## Further Implementation

- Add authentication headers to safeguard PUT and DELETE methods
- Tests Tests and more Tests!(I used Swagger APIs for test purposes)
- Abstract Controllers to a Service Layer
- Quantity and search name features to retrive specific item
- Build out proper CI/CD pipeline to hide `server.port` in `application.properties` as a Github Secret
- Add Redis Cache

## Assumptions
- Local system can run Makefiles in order to persist data