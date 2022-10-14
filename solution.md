## Local development

In order to run the application run the command below and replace `Port` with desired port number

```
docker build -t purple-cow . && docker run -p {Port}:3000 purple-cow

```

Navigate to localhost:{Port}/swagger-ui.html if you prefer to use swagger for testing

## Assumptions
- Using a SQL database

## Nice To Haves
- Added Actuator for health check
- Added Swagger documentation

# Further Implementation

- Add authentication headers to safeguard PUT and DELETE methods
- Tests Tests and more Tests!(I used Swagger APIs for test purposes)
- Abstract Controllers to a Service Layer
- Build out proper CI/CD pipeline to hide `server.port` in `application.properties` as a Github Secret
