# Spring Boot Microservices - Automated Tests

## Jenkins Job Configuration

1. On the main Jenkins dashboard page, click "New Item".
2. Enter "sbms-test" in the "name" field, select "Pipeline", and click "OK".
3. Scroll down to the "Pipeline" section and in "Definition" select "Pipeline script from SCM".
4. In "SCM", select "Git".
5. In "Repository URL", enter "https://github.com/jeromy-vandusen-obs/sbms-test.git".
6. Deselect "Lightweight checkout" and click "Save".

## Environment Variables

* URI_BASE: The base that will be used for generating URLs to access the application. The default value is
`http://localhost:8080`.
* MONGODB_HOST: The hostname or IP address that will be used to connect to MongoDB to create test data. The default
value is `localhost`.
* MONGODB_PORT: The port that will be used to connect to MongoDB to create test data. The default value is `27017`.

## To Do

* Get Chrome working when running on Jenkins server.
* Move Chrome drivers to a better location.
* Configure multiple MongoDB data sources.
