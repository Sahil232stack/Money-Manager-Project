# Money Manager – Personal Finance Tracking Web App

A full-stack Money Management Web Application built using Java Spring Boot (Backend) and React + Tailwind CSS (Frontend).
This application helps users track income, expenses, categories, balance, and financial insights through a clean dashboard.

------------------------------------------------------------

## Features

### Core Features
- JWT-based authentication
- Add and manage income and expenses
- Category-wise transaction tracking
- Charts and analytics
- Monthly and yearly filters
- Auto-calculated total balance
- Transaction history
- Responsive UI

### Technical Features
- REST API architecture
- DTO validation
- Global exception handling
- React Context API for state management
- Modular and reusable UI components
- Environment-based configuration
- CORS + JWT setup

------------------------------------------------------------

## Tech Stack

Frontend: React.js, Tailwind CSS, Axios, React Router, Context API  
Backend: Java 17, Spring Boot, Spring Data JPA, Lombok, JWT  
Database: MySQL  

------------------------------------------------------------

## Project Structure

Money-Manager/
- backend/
  - controller/
  - service/
  - repository/
  - model/
  - config/
  - dto/
  - resources/application.properties
- frontend/
  - components/
  - pages/
  - context/
  - assets/
  - utils/
- README.md

------------------------------------------------------------

## API Overview

### Authentication
POST /auth/register – Register user  
POST /auth/login – Login and get JWT token  

### Transactions
POST /transactions/add – Add income/expense  
GET /transactions/user – Get user transactions  
GET /transactions/chart – Fetch analytics data  
DELETE /transactions/{id} – Delete transaction  

------------------------------------------------------------

## Running the Project Locally

### Backend
cd backend  
mvn clean install  
mvn spring-boot:run  

application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/money_manager  
spring.datasource.username=root  
spring.datasource.password=your_password  
jwt.secret=your_secret_key  

### Frontend
cd frontend  
npm install  
npm start  

Frontend: http://localhost:5173  
Backend: http://localhost:8080  

------------------------------------------------------------

## Future Enhancements
- Budget planning
- Export to PDF/Excel
- AI-based spending analysis
- Notification system
- Dark mode

------------------------------------------------------------

## Author
Sahil Shankar Kokitkar  
GitHub: https://github.com/Sahil232stack  
LinkedIn: https://www.linkedin.com/in/sahil-kokitkar-05970a227/
