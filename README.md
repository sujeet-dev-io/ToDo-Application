# ToDo Application - Spring Boot + MySQL/PostgreSQL

This is a backend ToDo application built using **Java (Spring Boot)** and **MySQL/PostgreSQL**.

## ✨ Features

- Create a ToDo item
- List all ToDos in descending order of creation date
- Mark a ToDo as completed
- Update entire ToDo (extra feature)
- Proper request validation and custom error handling

---

## 🔧 Getting Started

### Ὃb Clone the Project
```bash
git clone https://github.com/your-username/todo-app.git
cd todo-app
```

### 📊 Database Configuration
Update your `application.properties` or `application.yml` file with your **MySQL/PostgreSQL** credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### ⚡ Run the Application
```bash
./mvnw spring-boot:run
```

The backend will start at: `http://localhost:8080`

---

## 🔸 API Endpoints

### 1. Create a ToDo
- **URL:** `POST /api/v1/todo`
- **Payload:**
```json
{
    "title": "Read book",
    "description": "Continue reading 'Clean Code' by Robert C. Martin"
}
```

#### ❌ If any field is blank:
```json
{
    "status": "FAILURE",
    "title": "Title is required"
}
```
```json
{
    "status": "FAILURE",
    "description": "Description is required"
}
```

#### ✅ Success Response:
```json
{
    "status": "SUCCESS",
    "data": {
        "id": 5,
        "title": "Read book",
        "description": "Continue reading 'Clean Code' by Robert C. Martin",
        "completed": false,
        "createdAt": "2025-04-08T11:48:59.966954"
    }
}
```

---

### 2. List All ToDos in Descending Order
- **URL:** `GET /api/v1/todo/descending/all`

#### ✅ Response:
```json
{
    "status": "SUCCESS",
    "data": [
        {
            "id": 3,
            "title": "Call the doctor",
            "description": "Schedule appointment for next Monday",
            "completed": false,
            "createdAt": "2025-04-08T11:48:27.202078"
        },
        ...
    ]
}
```

---

### 3. Mark a ToDo as Completed
- **URL:** `PUT /api/v1/{id}/complete`
- **Example:** `/api/v1/6/complete`

#### ✅ Success Response:
```json
{
    "status": "SUCCESS",
    "data": {
        "id": 6,
        "title": "Practice Data Structure",
        "description": "Solve 3 problems on Leetcode related to arrays",
        "completed": true,
        "createdAt": "2025-04-08T13:03:45.219804"
    }
}
```

#### ❌ If ID not found:
```json
{
    "status": "FAILURE",
    "message": "ToDo not found with id: 60"
}
```

---

### ✪ Extra Feature: Update Entire ToDo
- **URL:** `PUT /api/v1/update/{id}`
- **Payload:**
```json
{
    "title": "Practice DSA",
    "description": "Solve 3 problems on Leetcode related to arrays"
}
```

#### ✅ Response:
```json
{
    "status": "SUCCESS",
    "data": {
        "id": 6,
        "title": "Practice DSA",
        "description": "Solve 3 problems on Leetcode related to arrays",
        "completed": true,
        "createdAt": "2025-04-08T13:03:45.219804"
    }
}
```

---

## 🌟 Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL / PostgreSQL
- ModelMapper
- Bean Validation (JSR-380)
- Lombok

---

## 🙏 Contributing
Feel free to fork and raise PRs for improvements or suggestions.

---

## 🚫 License
This project is licensed under the MIT License.

---

Happy Coding ☕

