# GWA Calculator CLI

A command-line interface tool built in Java to help students track their courses, calculate their General Weighted Average (GWA), and estimate their Latin Honors standing based on the UP grading system.

## Features

- **Fast Bulk Input:** Parses custom string inputs (e.g., `CMSC21:1.75:3`) for rapid data entry instead of tedious one-by-one prompts.
- **Robust Error Handling:** Prevents crashes from invalid inputs using `try-catch` blocks and `NumberFormatException` handling.
- **CRUD Operations:** Allows users to Create, Read, and Update their course grades dynamically.
- **Honors Estimator:** Automatically calculates potential Dean's List or Cum Laude status based on the calculated GWA.

## Tech Stack

- **Language:** Java
- **Data Structures:** `ArrayList` for dynamic memory management
- **Core Concepts:** String manipulation (`.split()`, `.trim()`), Object-Oriented Programming, Exception Handling.

## How to Run

1. Ensure you have the Java Development Kit (JDK) installed on your machine.
2. Clone or download this repository.
3. Navigate to the project folder in your terminal.
4. Compile the code:
   ```bash
   javac GWACalculator.java

   <img width="411" height="643" alt="image" src="https://github.com/user-attachments/assets/65906acf-3921-42e5-a1ef-680d541f7785" />

