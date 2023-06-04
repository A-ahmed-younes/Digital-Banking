# Digital-Banking [![Stack](https://skillicons.dev/icons?i=spring,java,mysql,hibernate,angular,ts,bootstrap)](https://skillicons.dev) 

## Overview

Full-stack banking web application that allows users to manage their accounts, transfer money using debit or credit, and view their transaction history.

## Tech Stack

- **Frontend:** HTML, CSS, TypeScript, Angular, Bootstrap
- **Backend:** Java, Spring Boot, Spring Security, OpenAPI
- **Database:** MySQL
- **ORM:** Hibernate

## Setup

**Clone the repository:**
   ```bash
   git clone https://github.com/A-ahmed-younes/Digital-Banking.git
   ```

### Backend

1. **Open the project in your IDE: (IntelliJ IDEA recommended)**

2. **Wait for the Maven dependencies to be downloaded.**

3. **Configure the MySQL database connection in `src/main/resources/application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/E-BANK?createDatabaseIfNotExist=true
   spring.datasource.username=<your_username>
   spring.datasource.password=<your_password>
   ```
4. **Run the application from the IDE or using the following command:**
   ```bash
   mvn spring-boot:run
   ```

5. **Navigate to `http://localhost:8090`**

6. **Navigate to `http://localhost:8090/swagger-ui.html` to view the API documentation.**

### Frontend

1. **Install dependencies:**
   ```bash
   npm install
   ```

2. **Run the development server in your IDE or using the following command:**
   ```bash
   ng serve
   ```

3. **Navigate to `http://localhost:4200`**