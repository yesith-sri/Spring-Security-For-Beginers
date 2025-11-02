# Spring Security for Beginners: Hands-On Demo

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A **complete, beginner-friendly Spring Boot project** demonstrating **Spring Security fundamentals**:

- User registration & login  
- In-memory + database-backed authentication  
- Role-based access control  
- Password encoding (BCrypt)  
- Security filter chain configuration  
- REST API protection  

> **Perfect for learning how to secure e-commerce dashboards, admin panels, or APIs**

---

## Features

| Feature | Description |
|--------|-------------|
| **User Registration** | `POST /register` → saves user with encoded password |
| **Public Endpoint** | `GET /hello` — no login needed |
| **Protected Routes** | `GET /test/**` — requires authentication |
| **Form Login** | Default `/login` page for browsers |
| **HTTP Basic Auth** | For Postman, curl, or API clients |
| **MySQL + JPA** | Persistent user storage |
| **Custom `UserDetailsService`** | Loads users from DB |

---

## Learn the Theory First

Before diving into the code, **read the full guide** with detailed explanations, diagrams, and best practices:

[Mastering Spring Security for Beginners – A Hands-On Guide with a Real-World Demo](https://medium.com/@hansana.etec1216/mastering-spring-security-for-beginners-a-hands-on-guide-with-a-real-world-demo-f2769f22d0fa)

