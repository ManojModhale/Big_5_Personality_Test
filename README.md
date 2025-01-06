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
