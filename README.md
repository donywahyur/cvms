# Candidate Vacancy Management & Ranking System

## Overview

Spring Boot API for managing **job vacancies** and **candidate profiles**, including a **ranking system** based on vacancy criteria.
Features include:

-   Candidate management (CRUD)
-   Vacancy management (CRUD + criteria)
-   Candidate ranking with **criteria-based scoring**
-   SOLID architecture with DTOs, mappers, and service interfaces
-   Global validation and exception handling

---

## Folder Structure

```
src/main/java/com/cvms/api
 ├── config          # configuration
 ├── controller      # REST controllers
 ├── dto             # Request & Response DTOs
 ├── entity          # MongoDB document entities
 ├── exception       # Global exception handling & custom exceptions
 ├── mapper          # DTO ↔ Entity mappers
 ├── repository      # Spring Data MongoDB repositories
 └── service         # Service interfaces and implementations
```

---

## Installation

1. Clone the repository:

```bash
git clone https://github.com/donywahyur/cvms.git
cd cvms
```

2. Run docker compose for mongoDB:

```bash
docker compose up -d
```

3. Build & run:

```bash
mvn clean install
mvn spring-boot:run
```

---

### Accessing Swagger UI

1. Make sure your application is running (default: `http://localhost:8080`).
2. Open your browser and navigate to: http://localhost:8080/swagger-ui/index.html#/

---

## API Endpoints

### Candidate

| Method | Endpoint               | Description         |
| ------ | ---------------------- | ------------------- |
| POST   | `/api/candidates`      | Create candidate    |
| GET    | `/api/candidates`      | List all candidates |
| PUT    | `/api/candidates/{id}` | Update candidate    |
| DELETE | `/api/candidates/{id}` | Delete candidate    |

### Vacancy

| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| POST   | `/api/vacancies`      | Create vacancy     |
| GET    | `/api/vacancies`      | List all vacancies |
| PUT    | `/api/vacancies/{id}` | Update vacancy     |
| DELETE | `/api/vacancies/{id}` | Delete vacancy     |

### Ranking

| Method | Endpoint                   | Description  |
| ------ | -------------------------- | ------------ |
| GET    | `/api/ranking/{vacancyId}` | Get rankings |

---

## Scoring & Ranking

-   **Criteria Calculators** compute a score for each candidate per vacancy:

    -   Age
    -   Gender
    -   Salary

---

## Validation & Exception Handling

-   **Jakarta Validation API** with custom messages
-   **GlobalExceptionHandler** handles:

    -   `MethodArgumentNotValidException`
    -   `NotFoundException`
    -   Other custom exceptions

---
