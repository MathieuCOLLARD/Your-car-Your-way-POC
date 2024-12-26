CREATE DATABASE YourCarYourWay;

USE YourCarYourWay;

CREATE TABLE Users (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    LastName VARCHAR(50) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Address TEXT,
    Phone VARCHAR(15)
);

CREATE TABLE Vehicles (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Category VARCHAR(50) NOT NULL,
    Model VARCHAR(50) NOT NULL,
    Availability BOOLEAN DEFAULT TRUE,
    Price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Reservations (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    VehicleID INT NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME NOT NULL,
    Status ENUM('Confirmed', 'Cancelled', 'Modified') NOT NULL,
    Amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES Users(ID),
    FOREIGN KEY (VehicleID) REFERENCES Vehicles(ID)
);

CREATE TABLE Agencies (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    City VARCHAR(50) NOT NULL,
    Address TEXT NOT NULL,
    Contact VARCHAR(100)
);

CREATE TABLE CustomerSupport (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    Type ENUM('Chat', 'Video', 'Message') NOT NULL,
    Content TEXT NOT NULL,
    Status ENUM('Pending', 'Resolved', 'Closed') DEFAULT 'Pending',
    FOREIGN KEY (UserID) REFERENCES Users(ID)
);
