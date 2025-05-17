# 📬 Notification Service

A simple and efficient Notification Service built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. Supports multiple notification types (`EMAIL`, `SMS`, `IN_APP`) and uses a basic in-memory queue for asynchronous delivery.

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

---

## 📁 Project Structure

```
notification-service/
├── controller/
│   └── NotificationController.java
├── model/
│   └── Notification.java
├── queue/
│   └── NotificationQueueProcessor.java
├── repository/
│   └── NotificationRepository.java
├── service/
│   └── NotificationService.java
├── NotificationServiceApplication.java
```

---

## ⚙️ Features

- ✅ Queue-based notification processing
- ✅ Supports in-app, email, and SMS notification types
- ✅ Retrieve past notifications per user
- ✅ Asynchronous processing with background threads
- ✅ Auto-persistence with MySQL

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/BODUMB/NotificationService_pepsales.git
cd NotificationService_pepsales
```

### 2. Configure Database

Create a MySQL database:

```sql
CREATE DATABASE notification_db;
```

Update your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/notification_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

The app will start at: [http://localhost:5454](http://localhost:5454)

---

## 🧪 API Endpoints

### ➕ POST `/notifications`

Queue a new notification.

**Request Body:**
```json
{
  "userId": "user123",
  "message": "Welcome to the platform!",
  "type": "EMAIL"
}
```
**Response:**
```json
"Notification queued successfully!"
```

---

### 📥 GET `/notifications/users/{userId}`

Retrieve all notifications for a specific user.

**Example:**
```
GET /notifications/users/user123
```

**Response:**
```json
[
  {
    "id": 1,
    "userId": "user123",
    "message": "Welcome to the platform!",
    "type": "EMAIL",
    "sent": true
  }
]
```

---

## 🗃 Database Schema

**Table:** `notifications`

| Column  | Type    | Description                    |
| ------- | ------- | ----------------------------- |
| id      | BIGINT  | Auto-generated primary key     |
| user_id | VARCHAR | Target user ID                 |
| message | TEXT    | Notification content           |
| type    | VARCHAR | `EMAIL`, `SMS`, or `IN_APP`   |
| sent    | BOOLEAN | Status of delivery             |

---

## 💾 Sample SQL for Table Creation

```sql
CREATE TABLE notifications (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id VARCHAR(255),
  message TEXT,
  type VARCHAR(255),
  sent BOOLEAN
);
```

---

## 🖼️ Screenshots
### API Testing (Postman)
![Screenshot 2025-05-17 144730](https://github.com/user-attachments/assets/3c00919a-126a-4b04-9070-e3106c02f76a)
![Screenshot 2025-05-17 144714](https://github.com/user-attachments/assets/139ef59e-0137-451a-b186-b97bc15ef1b6)



### Database (notificationdb)
<!-- Add screenshots of your Postman tests or running UI here -->
![Screenshot 2025-05-17 141051](https://github.com/user-attachments/assets/1d514d27-e2e6-490b-bb9f-b13d75528d6f)
![Screenshot 2025-05-17 141116](https://github.com/user-attachments/assets/120de1df-ecb2-42ee-b778-809f7cefb02c)



---

## 📌 Notes

- For production, consider replacing the in-memory queue with a robust message broker (like RabbitMQ or Kafka).
- Validate input types and handle unsupported notification types as needed.

---

## 📫 Contact

For any queries or issues, please open an [issue](https://github.com/BODUMB/NotificationService_pepsales/issues) or contact: ramanvir2108@gmail.com
