# 💰 Money Manager – Personal Finance Tracking Web App

A full-stack personal finance management web application built using Java Spring Boot (Backend) and React + Tailwind CSS (Frontend).
The application helps users securely track income, expenses, categories, balance, and financial insights through a clean dashboard.

---

## 📌 Overview

Money Manager allows users to manage their personal finances in a structured and secure way.
Each user has isolated data access with JWT-based authentication, enabling safe tracking of income and expenses along with visual analytics.

This project demonstrates real-world backend development, RESTful APIs, authentication, and frontend-backend integration.

---

## 🎯 Problem Statement

Manual finance tracking is error-prone and lacks meaningful insights.
Money Manager solves this problem by providing:
- Centralized income and expense tracking
- Category-based transaction organization
- Auto-calculated balance and summaries
- Secure user-specific data handling

---

## 🚀 Features

### Core Features
- User registration and login
- JWT-based authentication and authorization
- Add, view, and delete income records
- Add, view, and delete expense records
- Category management
- Auto-calculated balance
- Monthly and yearly filters
- Charts for financial insights

### Security Features
- Stateless authentication using JWT
- Authorization using HTTP headers
- Password encryption
- Secure API access

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL

### Frontend
- React
- Axios
- Tailwind CSS

### Tools and Others
- Maven
- Git and GitHub
- Postman

---

## 🏗 Architecture

- Layered Architecture
  - Controller Layer
  - Service Layer
  - Repository Layer
- RESTful API design
- Stateless authentication using JWT
- Axios interceptor for token handling

---

## 🧠 OOP and Design Principles Used

- Encapsulation: Entity fields are private and accessed via methods
- Abstraction: Service interfaces hide implementation details
- Inheritance: Spring Data JPA repositories
- Loose Coupling: Dependency Injection with Spring

---

## 📂 Project Structure

### Backend (Spring Boot)
- controller – REST API endpoints
- service – Business logic
- repository – Database interaction
- entity – Domain models
- security – JWT and authentication logic
- dto – Data Transfer Objects

### Frontend (React)
- components – Reusable UI components
- pages – Application pages
- services – Axios API calls
- utils – Helper utilities

---

## 🔄 Application Flow

1. User registers or logs in
2. JWT token is generated
3. Token is stored on the client
4. Axios interceptor attaches token to each request
5. Backend validates token
6. Data is fetched or stored securely
7. Dashboard and charts update dynamically

---

## 📊 Screenshots

1. Home Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769162944/ng6j5os4h9ugu6pepdij.png
2. Login Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769162975/ezladmfkw45ugq8efgnz.png
3. Dashboard Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769163000/gcopv5otdwc4ofyt2bjx.png
4. Category Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769163035/o7r9kntuo2ppbs6upqyi.png
5. Income Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769163062/ogn90g0t9ijujowtqytr.png
6. Expense Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769163084/kccxge1pwq19rcftpyl3.png
7. Filter Page - https://res.cloudinary.com/dhpfn4umb/image/upload/v1769163111/goy8meystrrboydareyy.png
   


---

## ⚙️ Installation and Setup

### Backend Setup

git clone https://github.com/Sahil232stack/Money-Manager-Project.git  
cd backend  

- Configure database credentials in application.properties
- Run the Spring Boot application

---

### Frontend Setup

cd frontend  
npm install  
npm start  

---

## 🧪 API Testing

- APIs are tested using Postman
- JWT token is required for secured endpoints
- All endpoints follow REST standards

---

## 🧩 Future Enhancements

- Pagination for income and expenses
- Export reports (PDF or Excel)
- Budget limit alerts
- Role-based access control

---

## 👨‍💻 Author

Sahil Shankar Kokitkar  
Backend-Focused Full Stack Developer  
LinkedIn: https://www.linkedin.com/in/sahil-kokitkar-05970a227/ 
GitHub: https://github.com/Sahil232stack

---


