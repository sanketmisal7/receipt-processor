# 🚀 Receipt Processor API
A Spring Boot application that processes receipts and calculates reward points based on predefined rules.

---

## 📌 Prerequisites
Make sure you have installed:
- **Docker** (Ensure it's running)
- **Java 17** (If running locally)

---

## 🛠️ How to Build and Run Using Docker
### 1️⃣ Build the Docker Image
```sh
docker build -t receipt-processor .
```

### 2️⃣ Run the Docker Image
```sh
docker run -p 8080:8080 receipt-processor
```

The application will be available at
http://localhost:8080

## 📌 Run Locally Without Docker
If you want to run the project locally without Docker, follow these steps:

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/sanketmisal7/receipt-processor.git
cd receipt-processor
```
### 2️⃣ Build the Project
```sh
./gradlew clean build
```

### 3️⃣ Run the project
```sh
./gradlew bootRun
```
The application will be available at
http://localhost:8080

### 🛠️ Troubleshooting
## Issue: Docker Fails to Build
Ensure Docker is running on your system.

```sh
docker system prune -a
```
```sh
docker system prune -a
```

## Issue: Java Version Conflict
Ensure you're using Java 17:
```sh
java -version
```
