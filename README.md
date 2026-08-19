# Job Portal

A Spring Boot-based Job Portal REST API that allows users to create, view, update, and delete job postings.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman
- Git & GitHub

## Features

- Create a job
- Get all jobs
- Get job by ID
- Update a job
- Delete a job
- DTO-based API responses
- MySQL database integration
- REST APIs
- Layered architecture (Controller → Service → Repository)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/jobs` | Create a new job |
| GET | `/jobs` | Get all jobs |
| GET | `/jobs/{id}` | Get job by ID |
| PUT | `/jobs/{id}` | Update a job |
| DELETE | `/jobs/{id}` | Delete a job |

## Project Structure

```text
src/main/java/com/job/Portal
├── Controller
├── Service
├── Repository
├── Entity
└── DTO
