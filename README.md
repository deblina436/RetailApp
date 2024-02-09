# springboot-retail-product-discount-app 

# Build the project
mvn clean package

# Run unit tests
mvn test

# Generate code coverage report
mvn jacoco:report

#Reports will be generated \retail-discount-app\retail-discount-app\target\site\jacoco\index.html

#Run the project
mvn spring-boot:run

# Using the API
Once the project is running, you can hit the POST endpoint http://localhost:8080/api/v1/calculateDiscount with the following request body:

{
    "isEmployee": true,
    "isAffiliate": false,
    "memberSinceYears": 5,
    "orders": {
        "name": "Product1",
        "price": 150,
        "productType": "Grocery",
        "quantity": 5
    }
}

# Find the swagger UI -
http://localhost:8080/swagger-ui/index.html