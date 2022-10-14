## Local development

In order to run the application run the command below and replace `Port` with desired port number

```
docker build -t purple-cow . && docker run -p {Port}:3000 purple-cow

```

Navigate to localhost:{Port}/swagger-ui.html if you prefer to use swagger for testing
