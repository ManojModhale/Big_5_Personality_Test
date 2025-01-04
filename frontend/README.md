# Big 5 Personality Test Frontend

## Overview

**Big 5 Personality Test** is an online tool that allows users to evaluate their personality based on the Five-Factor Model (FFM). The test measures five key personality traits:

- **Openness**: Appreciation for art, emotion, adventure, and unusual ideas.
- **Conscientiousness**: Tendency to be organized, dependable, and disciplined.
- **Extraversion**: Tendency to be sociable, outgoing, and energetic.
- **Agreeableness**: Tendency to be compassionate, cooperative, and friendly.
- **Neuroticism**: Tendency to experience emotional instability, anxiety, and mood swings.

This repository contains the frontend built with Angular, featuring a user-friendly interface that guides users through the test and displays the results. The test questions and images are fetched from local JSON files, and the app uses various services to manage test timing, fetching questions, and sending user responses to the backend.
The app communicates with a Spring Boot backend running on port `8182` for fetching test questions, sending user answers, and retrieving results.

---

## Features

- **Interactive Test**: A series of questions for evaluating personality traits.
- **Real-Time Results**: Instant results showing personality scores for each trait.
- **Responsive Layout**: Designed to work across devices (desktop, tablet, and mobile).
- **User Authentication**: Login, registration, and profile management.
- **Service Integration**: Services to handle timing, question fetching, answer submission, and backend communication.
- **Questionnaire**: A set of 100 questions designed to evaluate the five key personality traits using 5 options consist of Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree.
- **Results Visualization**: Graphical representation of the user’s personality scores for each trait.

---

## Technologies Used

- **Angular**: For building the frontend user interface.
- **TypeScript**: For writing maintainable and scalable Angular code.
- **Bootstrap**: For responsive and mobile-friendly design.
- **RxJS**: For managing asynchronous operations.
- **Spring Boot**: Backend server running on port `8182`.

---

## Installation

### Prerequisites

Before starting, ensure you have the following installed:

- [Node.js](https://nodejs.org/) (which includes npm)
- [Angular CLI](https://angular.io/cli)

Additionally, the backend (Spring Boot) should be running on port `8182`. Ensure that the backend is up and running before interacting with the frontend.

### Steps to Run the Angular Frontend

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/big-5-personality-test.git
   cd big-5-personality-test
   ```

2. Install the dependencies:

   ```bash
   npm install
   ```

3. Start the development server:

   ```bash
   ng serve
   ```

4. Open your browser and navigate to:

   ```
   http://localhost:4200
   ```

The Angular frontend will be running and communicating with the backend on port `8182`.

---

## Folder Structure

```
big-5-personality-test/
|
├── src/
|   ├── app/
|   │   ├── components/                    # Reusable UI components like Welcome, HomePage, etc.
|   │   │   ├── welcome/                   # Welcome page component
|   │   │   ├── homepage/                  # Homepage component
|   │   │   ├── login-page/                # Login page component
|   │   │   ├── registration-page/         # Registration page component
|   │   │   ├── logout-page/               # Logout page component
|   │   │   ├── profile/                   # User profile component
|   │   │   ├── dashboard/                 # User dashboard component
|   │   │   ├── exam/                      # Test start page component
|   │   │   └── questionpage/              # Test question page component
|   │   ├── services/                      # Services to handle business logic
|   │   │   ├── exam-time.service.ts       # Service to track exam time
|   │   │   ├── get-test.service.ts        # Service to fetch the test
|   │   │   ├── fetch-question.service.ts  # Service to fetch questions one by one
|   │   │   ├── send-answer.service.ts     # Service to send answers to the backend
|   │   │   └── all-services.module.ts     # Aggregates all services
|   │   ├── models/                        # TypeScript models (e.g., User, Question)
|   │   └── app.module.ts                  # Root module for the Angular app
|   ├── assets/                            # Static files like images and JSON files
|   │   ├── questions.json                 # JSON file containing the test questions
|   │   └── images/                        # Folder with images used in the test
|   ├── environments/                      # Environment configurations (e.g., dev, prod)
|
├── angular.json                           # Angular CLI configuration
├── package.json                           # Node.js dependencies and scripts
└── README.md                              # Project documentation
```

---

## Folder Description

- src/app/components/: Contains components for different pages like the homepage, login, registration, dashboard, etc.
- src/app/services/: Contains services to handle the logic of exam timing, fetching questions, submitting answers, and communicating with the backend.
- src/assets/: Contains static assets like images and JSON files that hold the test questions.
- src/app/models/: Defines TypeScript interfaces and models used throughout the application (e.g., User, Question).

---

## Backend Communication

The Angular frontend communicates with the Spring Boot backend running on port `8182` using Angular's `HttpClientModule`. All HTTP requests (GET, POST) to fetch test data, send answers, and receive results are made to the backend URL `http://localhost:8182`.

**Example API Endpoints**

- `GET /api/test`: Fetches the test data (questions) from the Spring Boot backend.
- `POST /api/answers`: Sends the user’s answers to the backend for processing and storing.

**CORS Configuration (Backend)**

Since the frontend is served on a different port (e.g., port `4200` for development) and the backend is running on port `8182`, CORS (Cross-Origin Resource Sharing) must be enabled in the Spring Boot application.

---

## How It Works

- **Test Questions**: The questions for the test are stored in a JSON file located in the `assets` folder. These are dynamically loaded and displayed in the test pages.
- **Services**: Angular services manage the test's logic, including timing, fetching questions, and sending responses to the backend for analysis.
- **User Interface**: Components in the `components/` folder render the various pages of the app, such as the homepage, test interface, and results dashboard.

---

## Future Enhancements

- Implement advanced results analysis with additional visualizations.
- Add support for multilingual questions and interface.
- Enable offline functionality with progressive web app (PWA) capabilities.
- Integrate a recommendation system based on test results.

---

## Contact

Maintainer: Manoj Modhale

- GitHub: [https://github.com/ManojModhale](https://github.com/ManojModhale)
- Email: [manojmodhale2001@gmail.com](mailto:manojmodhale2001@gmail.com)

---

