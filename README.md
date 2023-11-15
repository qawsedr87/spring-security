# Spring Security 

Spring Security is a customizable authentication and access-control framework that focuses on providing both authentication and authorization to Java applications.

This project demonstrates MySQL with Hibernate login functionality and integrates the Spring Security framework.

## Set up 
1. Database setup:
    - Create User table with username and password
    - Create Permission table which contains the id and permission name
      - Insert 4 permissions into the Permission table: read, write, update, and delete.
      - Note that the relationship between the Permission and User table is Many-to-Many relationship. 
    - Create a conjunction table to define their relationship, named UserPermission. This table should contain id, userId, and permissionId.
    - Insert at least 4 different user-permission mapping into the UserPermission table.
2. Authentication Service
    - Create another Spring Boot Application for authentication purposes and connect it to the database you created in the RESTful assignment. Create necessary entity mapping if needed, e.g., mapping Permission and User.
    - Create 1 endpoint for authenticate user.
      - Endpoint: POST /login
      - Request Body: 
      ```{ "username": "jane", "password": "abcd" }```
      - Response: 
      
    ```json
    {
    "message": "Successfully Authenticated",
    "accessToken": "......"
    }
    ```
    - Spring Security is required to implement the authentication logic.

## Postman 
```shell
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username": "user1",
    "password": "pass1"
}'
```

## Next Step

- Protect your RESTful User Application
    - Use Spring Security to implement permission-based authorization to protect every endpoint in your RESTful User Application with corresponding permission.
    - For example, only users with “create” permission are able to do the user registration endpoint, only users with “delete” permission are able to delete a user.