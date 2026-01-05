# Timeout Airline Backend

## Overview
Timeout Airline Backend is a backend web application developed for **Timeout Airline**.  
It provides a RESTful API that allows customers to search for flights, book flights online, and allows administrators to manage users, clients, employees, planes, airports, flights, bookings, and miles rewards.

The application is built with **Java and Spring Boot**, uses **MySQL** as the relational database, and follows a layered architecture (Controller, Service, Repository).  

---

## Features
- **User Management**: Create, read, update, delete users.  
- **Client & Employee Management**: Linked to users for easy organization.  
- **Plane Management**: Manage all planes with brand, model, and manufacturing year.  
- **Airport Management**: CRUD operations for airports.  
- **Flight Management**: Create, update, view, and delete flights.  
- **Booking System**: Allows customers to book flights with seat type selection.  
- **Miles Rewards**: Tracks flights per client and generates random discount codes after 3 flights in a civil year.  
- **Search Feature**: Find available flights by departure city, destination city, and departure date.

---

## Technologies Used
- **Backend**: Java 21, Spring Boot
- **Build Tool**: Maven
- **Database**: MySQL
- **ORM**: Spring Data JPA / Hibernate
- **API Testing**: Postman
- **Source Control**: GitHub

---

```## Project Structure

airline_backend/
│
├─ src/main/java/com/KORNN/airline_backend
│ ├─ config/ # Application configuration
│ ├─ controller/ # REST Controllers
│ ├─ dto/ # Data Transfer Objects
│ ├─ model/ # Entities (User, Client, Flight, etc.)
│ ├─ repository/ # Spring Data JPA Repositories
│ ├─ service/ # Business logic
│ └─ exception/ # Custom exceptions & global exception handling
│
├─ src/main/resources/
│ └─ application.properties
│
└─ README.md
```
---

## Configuration

### CORS Configuration
The application includes a global CORS configuration allowing frontend applications to access the API:

- Allowed paths: `/api/**`
- Allowed methods: `GET`, `POST`, `PUT`, `DELETE`
- Allowed origins: all (`*`)

This configuration is defined in the `config` package.

---

## Installation & Running

### 1. Clone the repository

```bash
git clone https://github.com/your-username/timeoutairline.git
cd timeoutairline
```

##Create the MySQL database

Ensure MySQL is running, then execute:
```sql
CREATE DATABASE timeout_airline;
```

Configure your database in src/main/resources/application.properties:

      spring.application.name=airline_backend
      server.port=8085
      
      spring.datasource.url=jdbc:mysql://localhost:3306/timeout_airline
      spring.datasource.username=root
      spring.datasource.password=yourpassword
      
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true

Build and run the project with Maven:

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:

      http://localhost:8085

API Endpoints (Examples)

Users:
```
GET /api/v1/users

GET /api/v1/users/{id}

POST /api/v1/users

PUT /api/v1/users/{id}

DELETE /api/v1/users/{id}
```

Flights:
```
GET /api/v1/flights

GET /api/v1/flights/search?departureCity=...&arrivalCity=...&date=...

POST /api/v1/flights

PUT /api/v1/flights/{id}

DELETE /api/v1/flights/{id}
```

Booking:
```
POST /api/v1/bookings

POST /api/v1/bookings/book

GET /api/v1/bookings/{id}
```

Example JSON Requests
Create User:

```json
{
  "firstname": "John",
  "lastname": "Doe",
  "address": "123 Main Street",
  "email": "john@example.com",
  "phone": "123456789",
  "birthdate": "1990-01-01"
}
```

Book a Flight:
```json
{
  "firstname": "John",
  "lastname": "Doe",
  "passportNumber": "A12345678",
  "birthdate": "1990-01-01",
  "departureCity": "Paris",
  "arrivalCity": "London",
  "departureHour": "10:00",
  "arrivalHour": "11:30",
  "flightNumber": "FL123",
  "typeOfSeat": "BUSINESS"
}
```

## Notes

- Users must exist before creating a Client or Employee.

- Flights cannot be booked if no seats are available.

- The application automatically updates the MilesReward table when a booking is made.

- If a client completes 3 flights in the same civil year, a random discount code is generated.


## License
This project is for educational purposes and may not be used commercially without permission.

