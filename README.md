# Timeout Airline Backend

## Overview
This project is a backend web application for **KORNN Airline**, built with **Java Spring Boot**.  
It allows customers to book flights online, manages planes, airports, flights, users, clients, and employees, and keeps track of miles rewards and discounts.

The backend exposes a **REST API** and uses a relational database (PostgreSQL) for data storage.  

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
- **Backend**: Java 17, Spring Boot  
- **Build Tool**: Maven  
- **Database**: PostgreSQL (configurable in `application.properties`)  
- **API Testing**: Postman (Swagger not used in this project)  
- **Source Control**: GitHub  

---

```## Project Structure

airline_backend/
│
├─ src/main/java/com/KORNN/airline_backend
│ ├─ controller/ # REST Controllers
│ ├─ dto/ # Data Transfer Objects
│ ├─ model/ # Entities (User, Client, Flight, etc.)
│ ├─ repository/ # Spring Data JPA Repositories
│ └─ service/ # Business logic
│
├─ src/main/resources/
│ └─ application.properties
│
└─ README.md
```
---

## Installation & Running

1. Clone the repository:

```bash
git clone https://github.com/your-username/Java-Project.git
cd Java-Project
```
Configure your database in src/main/resources/application.properties:

      spring.datasource.url=jdbc:mysql://localhost:3306/airline_db
      spring.datasource.username=root
      spring.datasource.password=yourpassword
      spring.jpa.hibernate.ddl-auto=update

Build and run the project with Maven:

```bash
mvn clean install
mvn spring-boot:run
```
The API runs on http://localhost:8080/ by default.

API Endpoints (Examples)

Users:
```
GET /users → List all users

GET /users/{id} → Get user by ID

POST /users → Create a new user

PUT /users/{id} → Update user

DELETE /users/{id} → Delete user
```

Flights:
```
GET /flights → List all flights

GET /flights/search?departureCity=...&arrivalCity=...&date=... → Search flights

POST /flights → Create new flight

PUT /flights/{id} → Update flight

DELETE /flights/{id} → Delete flight
```
Booking
```
POST /bookings → Book a flight

GET /bookings/{clientPassport} → List bookings for a client"
```

Example JSON Requests
Create User:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "address": "123 Main Street",
  "email": "john@example.com",
  "phone": "123456789",
  "birthdate": "1990-01-01"
}
```

Book a Flight:
```json
{
  "clientPassport": "A12345678",
  "flightNumber": "FL123",
  "typeOfSeat": "Business"
}
```

## Notes

Users must exist before creating a Client or Employee.

Flights cannot be booked if no seats are available.

The application automatically updates the MilesReward table when a booking is made.

If a client completes 3 flights in the same civil year, a random discount code is generated.


## License
This project is for educational purposes and may not be used commercially without permission.

