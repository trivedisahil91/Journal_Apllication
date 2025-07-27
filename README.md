# 📝 Journal Application

This is a full-stack **Spring Boot** based Journal Application that allows users to create, view, edit, and delete journal entries. It includes **user authentication**, **role-based access**, and is structured using best practices.

---

## 🚀 Features

- 🔐 User Registration & Login (with Spring Security)
- 🧑‍💼 Role-based access (Admin & User)
- 📚 Create, Read, Update, Delete Journal Entries
- 📁 RESTful APIs with versioning support
- 🛡️ Secure configuration profiles (`dev`, `prod`)
- 🧪 Unit tests for service layer
- 📊 Logging with Logback
- 🌐 Prepared for deployment

---

## 🛠️ Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Logback (for logging)
- **MongoDB** (via Spring Data MongoDB)
- Maven
- **Postman** (for API testing)

---

## 📁 Project Structure

```

src/
├── main/
│   ├── java/
│   │   └── com.example.demo/
│   │       ├── controller/
│   │       ├── entity/
│   │       ├── repository/
│   │       ├── service/
│   │       └── config/
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       ├── application-prod.yml
│       └── logback.xml
├── test/
│   └── java/
│       └── com.example.demo/
│           ├── service/
│           └── JournalApplicationTest.java

````

## ☁️ MongoDB Atlas Configuration

In `application.yml` or `application-dev.yml`, the MongoDB URI is set from **MongoDB Atlas**:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb+srv://<username>:<password>@<cluster>.mongodb.net/journaldb?retryWrites=true&w=majority
```

> ⚠️ Replace `<username>`, `<password>`, and `<cluster>` with your actual MongoDB Atlas credentials.

---
## ⚙️ Setup & Run

### 🔧 Prerequisites
- Java 17+
- Maven
- Git

### ▶️ Run the app
```bash
git clone https://github.com/trivedisahil91/Journal_Apllication.git
cd Journal_Apllication
mvn spring-boot:run
````

App will start on:
📍 `http://localhost:8080`

---


🧪 API Testing with Postman
All RESTful endpoints (User Registration, Login, Journal CRUD) have been tested using Postman.
You can import a .postman_collection.json file (if available) for quick testing.

Typical endpoints:

  -> POST /api/user/register

  -> POST /api/user/login

  -> GET /api/journal

  -> POST /api/journal

  -> PUT /api/journal/{id}

  -> DELETE /api/journal/{id}
