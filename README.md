# Big 5 Personality Test Frontend

## Overview

**Big 5 Personality Test** is an online tool that allows users to evaluate their personality based on the Five-Factor Model (FFM). The test measures five key personality traits:

- **Openness**: Appreciation for art, emotion, adventure, and unusual ideas.
- **Conscientiousness**: Tendency to be organized, dependable, and disciplined.
- **Extraversion**: Tendency to be sociable, outgoing, and energetic.
- **Agreeableness**: Tendency to be compassionate, cooperative, and friendly.
- **Neuroticism**: Tendency to experience emotional instability, anxiety, and mood swings.

The **Big 5 Personality Test** is a Spring Boot application designed to support the functionality of the Big 5 Personality Test platform. This backend handles user management, test data, and result processing while communicating with the Angular frontend and a MySQL database.

This application was collaboratively developed by a three-member team, led by the project owner. Key features include account creation, a 100-question MCQ test, email-delivered result summaries, and support for user retakes through a robust and intuitive interface.

Collaborative & Responsive personality assessment platform developed with Spring Boot, Angular, and MySQL. Oversaw a three-member team, successfully implementing features such as account creation, a 100-question MCQ test, email delivered results, and the ability for users to retake the test. Utilized the Five-Factor Model (FFM) to evaluate personality traits, ensuring an engaging user experience.

This repository contains the frontend built with Angular, featuring a user-friendly interface that guides users through the test and displays the results. The test questions and images are fetched from local JSON files, and the app uses various services to manage test timing, fetching questions, and sending user responses to the backend.
The app communicates with a Spring Boot backend running on port `8182` for fetching test questions, sending user answers, and retrieving results.

---

## Features

- **User Management**: Account creation, login, and profile management.
- **Test Management**: Handles a 100-question MCQ personality test based on the Five-Factor Model (FFM).
- **Interactive Test**: A series of questions for evaluating personality traits.
- **Real-Time Results**: Instant results showing personality scores for each trait.
- **Result Processing**: Analyzes user responses to determine personality traits and sends results via email.
- **Service Integration**: Services to handle timing, question fetching, answer submission, and backend communication.
- **Questionnaire**: A set of 100 questions designed to evaluate the five key personality traits using 5 options consist of Strongly Agree, Agree, Neutral, Disagree, Strongly Disagree.
- **Email Integration**: Delivers a summary of results to the user’s email.
- **Test Retakes**: Allows users to retake the test for continuous self-assessment.
- **Dashboard Support**: Provides APIs to enable an interactive user dashboard.
- **Responsive Layout**: Designed to work across devices (desktop, tablet, and mobile).
- **Database Integration**: Uses MySQL to store user data, questions, and test results.

---

## Technologies Used

- **Angular**: For building the frontend user interface.
- **TypeScript**: For writing maintainable and scalable Angular code.
- **Bootstrap**: For responsive and mobile-friendly design.
- **RxJS**: For managing asynchronous operations.
- **Spring Boot**: For building the RESTful API backend.
- **Hibernate/JPA**: For database interaction.
- **MySQL**: To store user information, questions, and results.
- **Java Mail API**: For sending email notifications.
- **Maven**: For project management and dependency resolution.

---
