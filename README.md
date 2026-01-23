💰 Money Manager – Personal Finance Tracking Web App
A full-stack personal finance management web application built using Java Spring Boot and React.js, designed to help users track income, expenses, and financial trends through a secure and intuitive dashboard. This project demonstrates real-world backend development, REST API design, JWT-based authentication, and modern frontend state management—making it well-suited for backend / full-stack (3–5 LPA) roles.

🚀 Key Highlights
JWT-based stateless authentication
Clean REST API architecture
Backend-calculated balance & analytics
User-specific data isolation
DTO validation and global exception handling
React Context API for state management
Axios interceptor for JWT handling
Modular, reusable UI components
Responsive UI with Tailwind CSS

✨ Features
🔐 Authentication & Security
User registration and login
JWT token generation & validation
Stateless authentication using Spring Security
CORS configuration for frontend–backend communication

💸 Transaction Management
Add income and expense transactions
Category-wise transaction tracking
Delete transactions
User-specific transaction history

📊 Dashboard & Analytics
Auto-calculated total balance
Monthly and yearly filters
Backend-driven analytics for charts
Clean and responsive dashboard UI

⚙️ Technical Features
RESTful API architecture
DTO-based request and response validation
Global exception handling
React Context API for global state management
Environment-based configuration

🛠️ Tech Stack
Frontend
React.js
Tailwind CSS
Axios
React Router
Context API
Backend
Java
Spring Boot
Spring Security
Spring Data JPA
JWT
Lombok
Database
MySQL

🧱 Project Structure
Money-Manager/
├── backend/
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── model/
│ ├── dto/
│ ├── config/
│ └── resources/
│ └── application.properties
│
├── frontend/
│ ├── components/
│ ├── pages/
│ ├── context/
│ ├── utils/
│ └── assets/
│
└── README.md

🔌 API Overview
🔑 Authentication
Method	Endpoint	Description
POST	/auth/register	Register new user
POST	/auth/login	Login and receive JWT token
💳 Transactions
Method	Endpoint	Description
POST	/transactions/add	Add income or expense
GET	/transactions/user	Fetch user transactions
GET	/transactions/chart	Fetch analytics data
DELETE	/transactions/{id}	Delete transaction

▶️ Running the Project Locally
Backend
cd backend
mvn clean install
mvn spring-boot:run
application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/money_manager
spring.datasource.username=root
spring.datasource.password=your_password
jwt.secret=your_secret_key
Backend runs at: http://localhost:8080

Frontend
cd frontend
npm install
npm start
Frontend runs at: http://localhost:5173

🔮 Future Enhancements
Budget planning and alerts
Export data to PDF / Excel
AI-based spending analysis
Notification system
Dark mode

👨‍💻 Author
Sahil Shankar Kokitkar
Java Full Stack Developer 
GitHub: https://github.com/Sahil232stack
LinkedIn: https://www.linkedin.com/in/sahil-kokitkar-05970a227/
