CREATE DATABASE IF NOT EXISTS demo;
USE demo;


-- Create User table
CREATE TABLE User (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL
);

-- Insert users into User table
INSERT INTO User (username, password) VALUES
                                          ('user1', 'pass1'),
                                          ('user2', 'pass2');


-- Create Permission table
CREATE TABLE Permission (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

-- Insert permissions into Permission table
INSERT INTO Permission (name) VALUES ('read'), ('write'), ('update'), ('delete');

-- Create UserPermission table
CREATE TABLE UserPermission (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                userId INT,
                                permissionId INT,
                                FOREIGN KEY (userId) REFERENCES User(id),
                                FOREIGN KEY (permissionId) REFERENCES Permission(id)
);

-- Insert user-permission mappings into UserPermission table
INSERT INTO UserPermission (userId, permissionId) VALUES
                                                      (1, 1), -- User 1 has 'read' permission
                                                      (1, 2), -- User 1 has 'write' permission
                                                      (2, 3), -- User 2 has 'update' permission
                                                      (2, 4); -- User 2 has 'delete' permission
