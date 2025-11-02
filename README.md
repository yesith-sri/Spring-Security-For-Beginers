# Spring Security for Beginners: Hands-On Demo

A **complete, beginner-friendly Spring Boot project** demonstrating core **Spring Security** concepts:

- User registration & login
- In-memory and database-backed authentication
- Role-based access control
- Password encoding with BCrypt
- Security filter chain configuration
- REST API protection with HTTP Basic & form login

Perfect for learning how to secure modern web applications — think **e-commerce user dashboards**, **admin panels**, or **API gateways**.

---

## Features

| Feature | Description |
|-------|-----------|
| **User Registration** | `POST /register` with email, password, role |
| **Public Access** | `/hello` — no login required |
| **Protected Endpoints** | `/test/**` — requires authentication |
| **Form Login** | Default `/login` page for browser users |
| **HTTP Basic Auth** | For API clients (Postman, curl) |
| **Database Integration** | MySQL + JPA + Custom `UserDetailsService` |
| **Password Encoding** | `DelegatingPasswordEncoder` (supports BCrypt, etc.) |

---

## Project Structure
