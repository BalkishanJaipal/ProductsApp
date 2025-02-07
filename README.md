# Project Setup

## Prerequisites
Ensure you have the following installed on your local machine:
- Java 17 (or compatible version)
- Maven
- PostgreSQL (or any configured database)
- cURL (for API testing)

## Setup Project in Your Local Environment

### Step 1: Clone the Repository
```sh
git clone <repository_url>
cd <project_directory>
```

### Step 2: Configure Database
Update the `application.properties` file with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<your_database>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>
```

### Step 3: Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### 1. Create a Product
```sh
curl --location 'http://localhost:8080/api/products' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse with USB receiver",
    "price": 25.99
}'
```

### 2. Get All Products
```sh
curl --location --request GET 'http://localhost:8080/api/products'
```

### 3. Get Product by ID
```sh
curl --location --request GET 'http://localhost:8080/api/products/1'
```

### 4. Update Product by ID
```sh
curl --location --request PUT 'http://localhost:8080/api/products/1' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Wireless Mouse",
    "description": "Ergonomic wireless mouse with USB receiver",
    "price": 25.00
}'
```

### 5. Delete Product by ID
```sh
curl --location --request DELETE 'http://localhost:8080/api/products/1'
```

## Additional Notes
- Ensure your database is running before starting the application.
- Use `Postman` or similar tools to test APIs interactively.
- Contributions are welcome! Fork the repository and submit a PR.

