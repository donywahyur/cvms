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

2. Configure `application.yml` for MongoDB & Redis:

```yaml
spring:
    data:
        mongodb:
            uri: mongodb://localhost:27017/cvms
    redis:
        host: localhost
        port: 6379
```

3. Build & run:

```bash
mvn clean install
mvn spring-boot:run
```

---

## API Endpoints

### Candidate

| Method | Endpoint           | Description         |
| ------ | ------------------ | ------------------- |
| POST   | `/candidates`      | Create candidate    |
| GET    | `/candidates`      | List all candidates |
| PUT    | `/candidates/{id}` | Update candidate    |
| DELETE | `/candidates/{id}` | Delete candidate    |

### Vacancy

| Method | Endpoint          | Description        |
| ------ | ----------------- | ------------------ |
| POST   | `/vacancies`      | Create vacancy     |
| GET    | `/vacancies`      | List all vacancies |
| PUT    | `/vacancies/{id}` | Update vacancy     |
| DELETE | `/vacancies/{id}` | Delete vacancy     |

### Ranking

| Method | Endpoint                | Description         |
| ------ | ----------------------- | ------------------- |
| GET    | `/rankings/{vacancyId}` | Get cached rankings |

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
