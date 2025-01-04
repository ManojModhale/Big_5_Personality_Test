# Big 5 Personality Test Backend

## Overview

The **Big 5 Personality Test Backend** is a Spring Boot application designed to support the functionality of the Big 5 Personality Test platform. This backend handles user management, test data, and result processing while communicating with the Angular frontend and a MySQL database.

This application was collaboratively developed by a three-member team, led by the project owner. Key features include account creation, a 100-question MCQ test, email-delivered result summaries, and support for user retakes through a robust and intuitive interface.

---

## Features

- **User Management**: Account creation, login, and profile management.
- **Test Management**: Handles a 100-question MCQ personality test based on the Five-Factor Model (FFM).
- **Result Processing**: Analyzes user responses to determine personality traits and sends results via email.
- **Email Integration**: Delivers a summary of results to the user’s email.
- **Test Retakes**: Allows users to retake the test for continuous self-assessment.
- **Dashboard Support**: Provides APIs to enable an interactive user dashboard.
- **Database Integration**: Uses MySQL to store user data, questions, and test results.

---

## Technologies Used

- **Spring Boot**: For building the RESTful API backend.
- **Hibernate/JPA**: For database interaction.
- **MySQL**: To store user information, questions, and results.
- **Java Mail API**: For sending email notifications.
- **Maven**: For project management and dependency resolution.

---

## Installation

### Prerequisites

Before starting, ensure you have the following installed:

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL Server](https://dev.mysql.com/downloads/installer/)

### Steps to Set Up the Backend

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/big5-personality-test-backend.git
   cd big5-personality-test-backend
   ```

2. Configure the database:
   - Create a MySQL database named `big5_test_db`.
   - Update the database connection details in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/big5_test_db
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Backend will be accessible at:

   ```
   http://localhost:8182
   ```

---

## Folder Structure

```
big5-personality-test-backend/
|
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com\app\demo/
│   │   │   │   ├── controller/               # REST controllers for API endpoints
│   │   │   │   │   ├──UserController.java
│   │   │   │   ├── service/                  # Business logic and services
│   │   │   │   │   ├──UserService.java
│   │   │   │   │   ├──UserServiceImpl.java
│   │   │   │   ├── dao/                      # JPA repositories for database operations
│   │   │   │   │   ├──TestRepo.java
│   │   │   │   │   ├──UserRepo.java
│   │   │   │   └── bean/                     # Entity classes representing database tables
│   │   │   │   │   ├──Exam.java
│   │   │   │   │   ├──Test.java
│   │   │   │   │   ├──User.java
│   │   │   │   │   ├──UserResponses.java
│   │   └── resources/
│   │       ├── application.properties        # Configuration properties
├── pom.xml                                   # Maven configuration
└── README.md                                 # Project documentation
```

---

## REST API Endpoints

### Authentication
- **POST /auth/register**: Register a new user.
- **POST /auth/login**: Authenticate a user and return a JWT.

### Test Management
- **GET /api/questions**: Retrieve all test questions.
- **POST /api/submit**: Submit test answers and receive results.
- **GET /api/results/{userId}**: Retrieve results for a user.

### User Management
- **GET /api/users/{userId}**: Retrieve user profile.
- **PUT /api/users/{userId}**: Update user profile.

---

## How It Works

1. **Account Creation**: Users register through the frontend. User details are stored securely in the MySQL database.
2. **Test Flow**:
   - Questions are fetched from the database and displayed via the frontend.
   - Users answer questions, and responses are submitted to the backend.
   - Results are calculated and stored in the database.
3. **Email Notification**: Results are sent to the user’s registered email address using Java Mail API.
4. **Dashboard**: Users can view their profile, previous results, and retake the test through APIs provided by the backend.

---

## Future Enhancements

- Add support for multiple languages.
- Implement a more robust recommendation system for personalized feedback.
- Introduce admin panel for managing test questions and monitoring user activity.
- Use cloud storage for scalability.

---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto:manojmodhale2001@gmail.com)

