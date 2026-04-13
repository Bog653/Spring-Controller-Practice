# Spring Simple Controller Exercise
A simple exercise focused on REST API Request/Response patterns using Spring and Postman. Created to familiarize with I/O data handling, annotations, mappers, and DTO patterns.

### Tech Stack

* Java 21
* Spring Boot 4.x
* Postman
* Maven
* Lombok
* MapStruct

### Installation

1. Clone or download the repository to your machine.
2. Open the project with your favorite IDE.
3. Install dependencies using Maven.
4. Run the application.

### Documentation

This exercise features two main entities: Barber and Treatment (services).

Barber Endpoints.
Path: /app/v1/barber

* GET: Return all barbers.
* GET /{id}: Return a barber by ID.
* POST: Add a new barber.
* DELETE /{id}: Delete a barber by ID.

Treatment Endpoints
Path: /app/v1/treatment

* GET: Return all treatments.
* GET /{id}: Return a treatment by ID.
* POST: Add a new treatment.

### Project Structure

* Entity: Contains the domain models.
* Repository: Interfaces with a simple in-memory data store. 
* Service: Implements business logic and handles DTO mapping.
* Controller: Are stored all the controllers of the application.
* Mapper: Contains MapStruct interfaces for object mapping.
* Util: Includes custom exception handling and data validation.
* Bean: Contains simple bean implementations and configurations.

### Example
To test the API, use Postman to send a GET request to path:
../app/v1/barber

Response Example:

```JSON
{
  "data": [
    {
      "name": "Mario",
      "surname": "Rossi",
      "age": 20
    },
    {
      "name": "Chiara",
      "surname": "Bruni",
      "age": 19
    },
    {
      "name": "Marta",
      "surname": "Bianchi",
      "age": 30
    }
  ]
}
```


### Authors
[Bog653](https://github.com/Bog653)

