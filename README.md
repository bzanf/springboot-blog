# springboot-blog

## Overview
This is an application developed with Java and Spring Boot. The goal of this project is to provide a RESTful API to manage users, posts and comments, with CRUD (Create, Read, Update, Delete) operations.

## Technologies
This project is built with:
- Spring Boot 3.x
- Spring Data MongoDB
- MongoDB
- Maven

## Getting Started
To get a local copy of this project running, follow these steps.

### Prerequisites
Make sure you have the following installed:
- Java 21+
- Maven 3+

### Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the org.blog.springboot.Application class from your IDE.

## API
The application will be available at the address: http://localhost:8080.
All available endpoints can be found at: org.blog.springboot.infrastructure.adapters.inbound.rest.* classes.

Some available endpoints:
- GET: ```/users``` - returns all users.
- PUT: ```/users/{id}``` - updates the user information with the specified ID.
- DELETE: ```/users/{id}``` - removes the user with the specified ID.
- GET: ```/users/{id}/posts``` - returns all posts for the given user ID.
- GET: ```/posts/{id}``` - returns the post with the specified ID.

Example body for updating a user:
```
{
    "name": "Robert de Niro",
    "email": "robert@email.com"
}
```
