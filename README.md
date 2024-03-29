# Act of God API

## Features

* City db operations
* District db operations
* User db operations
* CRUD location operations

## Technologies
* Java 11
* Spring Boot
  * JPA Repository
  * Model Mapper
  * Lombok
  * Json Path
  * Rest Template
* PostgreSQL
* Google Maps Directions API
 

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 11+
* Maven 3+

To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/ahmettyavzz/ActOfGod_API.git`
* Navigate to the project directory
* service/RouteService on line 20;
```java
+ "&mode=walking&sensor=false&key=YOUR_API_KEY";
```
Put your Google Maps API Key instead of "YOUR_API_KEY"
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run

-> The application will be available at http://localhost:8080