# Job Portal

A Spring Boot-based Job Portal REST API that allows users to create, view, update, and delete job postings, with user authentication and JWT-based authorization.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Spring Security
- JWT
- Jakarta Validation
- Postman
- Git & GitHub

## Features

### Job Management
- Create a job
- Get all jobs
- Get job by ID
- Update a job
- Delete a job
- DTO-based API responses
- Request validation
- Global exception handling
- Custom `JobNotFoundException`
- MySQL database integration
- REST APIs
- Layered architecture

### User Authentication
- User registration
- User login
- BCrypt password hashing
- Password verification
- JWT token generation
- JWT token validation
- JWT authentication filter
- Stateless authentication
- Protected APIs using Spring Security
- Role-based authority support

## API Endpoints

### Job APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/job` | Create a new job |
| GET | `/job` | Get all jobs |
| GET | `/job/{id}` | Get job by ID |
| PUT | `/job/{id}` | Update a job |
| DELETE | `/job/{id}` | Delete a job |

### User APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/user` | Register a new user |
| POST | `/user/login` | Login and receive JWT |

## Authentication Flow

The application uses **Spring Security and JWT** for authentication.

```text
User Registration
       ↓
Password encoded using BCrypt
       ↓
User stored in MySQL
       ↓
User Login
       ↓
Password verification
       ↓
JWT generated
       ↓
JWT returned to client
       ↓
Client sends JWT with requests
       ↓
JwtFilter validates token
       ↓
SecurityContext
       ↓
Protected API accessed

