### PRODUCT API
Simple API for products and orders

Run as standalone Spring Boot application. Just execute in your favourite IDE. Maven can be used as well.

This API uses H2 as a storage solution as it's fast and simple for the demo purposes.

This solution is very simple one, but the more advanced could use BASIC authentication or JWT.

To make it redundant this solution could be prepared also as a Docker image for easy instantiation on target deployment environment.

API has been documented in a minimalistic way using Swagger API. You can find it here: http://localhost:8080/swagger-ui.html

Import product-api.postman_collection.json to your local Postman. Execute requests according to the scenario.

Class ProductServiceTest demonstrates how unit tests can be written.