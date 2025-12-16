📦 Event-Driven Order & Product Microservices

An event-driven microservices application built using Java, Spring Boot, and Apache Kafka, demonstrating 
asynchronous communication between Order Service and Product Service with database persistence.

🏗️ Architecture Overview

This project follows an event-driven microservices architecture:

Order Service

Handles order creation

Persists order data in database

Publishes order events to Kafka

Product Service

Manages product data

Consumes order events from Kafka

Can be extended for inventory management

Client
  ↓
Order Service → Database
      ↓
   Kafka Topic (order-topic)
      ↓
Product Service → Database

🛠️ Tech Stack

Java 17

Spring Boot

Spring Data JPA

Apache Kafka

H2 Database

Maven

REST APIs

📂 Services
🔹 Order Service

Port: 8082

REST Endpoints:

POST /orders – Create an order

GET /orders – Fetch all orders

Kafka Producer publishes ORDER_CREATED events

🔹 Product Service

Port: 8081

REST Endpoints:

POST /products – Create a product

GET /products – Fetch all products

Kafka Consumer listens to order events

🔄 Kafka Communication

Topic: order-topic

Producer: Order Service

Consumer: Product Service

Message Type: JSON-based order event

Example event:

{
  "orderId": 1,
  "productId": 101,
  "quantity": 2,
  "status": "ORDER_CREATED"
}
🚀 How to Run the Project
Prerequisites

Java 17+

Maven

Kafka & Zookeeper running locally

Step 1️⃣ Start Kafka

Ensure Kafka is running on:

localhost:9092

Step 2️⃣ Run Product Service
cd product-service
mvn spring-boot:run


Runs on:

http://localhost:8081

Step 3️⃣ Run Order Service
cd order-service
mvn spring-boot:run


Runs on:

http://localhost:8082

🧪 Sample API Requests
Create Product
POST /products

{
  "name": "Laptop",
  "price": 55000
}

Create Order
POST /orders

{
  "productId": 1,
  "quantity": 2
}

📌 Key Features

Event-driven architecture using Kafka

Loose coupling between microservices

Asynchronous communication

RESTful APIs

Database persistence with JPA

Clean and scalable design

🎯 Future Enhancements

Inventory stock management

Kafka retry & dead-letter queues

Docker & Docker Compose support

MySQL / PostgreSQL integration

Saga pattern implementation

Swagger/OpenAPI documentation

🧠 Learning Outcomes

Understanding event-driven microservices

Kafka producer-consumer implementation

Microservice communication patterns

Spring Boot + Kafka integration

Backend system design fundamentals

👤 Author

Santhosh
Backend Developer | Java | Spring Boot | Kafka
