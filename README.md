# Finance Dashboard Backend

Description - 
A Spring Boot backend application for managing financial records with role-based access control and dashboard analytics.

This project demonstrates backend development concepts including API design, data modeling, security, and aggregation logic.

Features-
- User Management (CRUD)
- Financial Records Management
- Filtering (type, category, date)
- Dashboard APIs (summary & category-wise totals)
- Role-based access control using Spring Security
- Input validation and error handling

Tech Stack-
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database
- Maven

Roles-
- ADMIN → Full access
- ANALYST → Dashboard + read access
- VIEWER → Read-only access

API Endpoints-
### Users
POST /users  
GET /users  
GET /users/{id}  
PUT /users/{id}  
DELETE /users/{id}

### Records
POST /records  
GET /records  
PUT /records/{id}  
DELETE /records/{id}

### Dashboard
GET /dashboard/summary  
GET /dashboard/category  

Authentication-
Basic Authentication is used.

| Username | Password   | Role    |
|----------|------------|---------|
| admin    | admin123   | ADMIN   |
| analyst  | analyst123 | ANALYST |
| viewer   | viewer123  | VIEWER  |

Setup Instructions-
1. Clone the repository
2. Run: mvn clean install
3. Start application
4. Open: http://localhost:8080

Notes -
- H2 database used for simplicity
- Basic authentication instead of JWT
- DTO layer optional for simplicity
working on these parts
