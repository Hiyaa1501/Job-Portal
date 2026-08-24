# Job Portal

A Spring Boot-based Job Portal REST API that allows users to create, view, update, and delete job postings.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman
* Git & GitHub

## Features

* Create a job
* Get all jobs
* Get job by ID
* Update a job
* Delete a job
* DTO-based API responses
* Request validation using Jakarta Validation
* Global exception handling
* Custom `JobNotFoundException`
* MySQL database integration
* REST APIs
* Layered architecture

## API Endpoints

| Method | Endpoint    | Description      |
| ------ | ----------- | ---------------- |
| POST   | `/job`      | Create a new job |
| GET    | `/job`      | Get all jobs     |
| GET    | `/job/{id}` | Get job by ID    |
| PUT    | `/job/{id}` | Update a job     |
| DELETE | `/job/{id}` | Delete a job     |

## Project Structure

```text
src/main/java/com/job/Portal
│
├── Controller
│   └── JobController.java
│
├── Service
│   └── JobService.java
│
├── Repository
│   └── JobRepository.java
│
├── Entity
│   └── Job.java
│
├── DTO
│   └── JobDto.java
│
└── Exception
    ├── JobNotFoundException.java
    └── GlobalExceptionHandler.java
```

## Architecture

```text
Client (Postman)
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
MySQL Database
```

## Job Fields

The Job entity contains:

* `id`
* `title`
* `description`
* `company`
* `location`
* `salary`

## Validation & Exception Handling

The project uses `@Valid` for validating incoming job requests.

Global exception handling is implemented using:

* `@RestControllerAdvice`
* `@ExceptionHandler`
* `JobNotFoundException`
* `MethodArgumentNotValidException`

This provides meaningful HTTP responses when a job is not found or when request validation fails.

## API Response

The API uses `JobDto` for request and response data instead of directly exposing the entity.

## Database

The application uses **MySQL** with **Spring Data JPA/Hibernate** for database operations.

## Tools

* IntelliJ IDEA
* Maven
* MySQL
* Postman
* Git
* GitHub

