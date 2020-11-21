DROP DATABASE alaorden_dev;
CREATE DATABASE alaorden_dev;
USE alaorden_dev;

CREATE TABLE Role(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30),
	description VARCHAR(60)
);

CREATE TABLE City(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL
);

CREATE TABLE Country(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL
);

CREATE TABLE DocumentType(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(30) NOT NULL
);

CREATE TABLE User(
	id VARCHAR(50) NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	document VARCHAR(30) NOT NULL,
	documentType INT NOT NULL,
	lastName VARCHAR(60) NOT NULL,
	country INT,
	city INT,
	phone VARCHAR(20),
	FOREIGN KEY (documentType) REFERENCES DocumentType(id),
	FOREIGN KEY (country) REFERENCES Country(id),
	FOREIGN KEY (city) REFERENCES City(id)
);

CREATE TABLE Account(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	roleId INT NOT NULL,
	password VARCHAR(50) NOT NULL,
	status BOOLEAN,
	FOREIGN KEY (roleId) REFERENCES Role(id),
    FOREIGN KEY (userId) REFERENCES User(id)
);

CREATE TABLE RecoveryData(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	accountId INT NOT NULL,
	recoveryToken VARCHAR(100) NOT NULL,
	expiredAt DATETIME,
	FOREIGN KEY (accountId) REFERENCES Account(id)
);



CREATE TABLE Company(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(70) NOT NULL,
	isActive BOOLEAN,
	owner VARCHAR(50) NOT NULL,
	segmentCode VARCHAR(10) NOT NULL,
	longitude FLOAT,
	latitude FLOAT,
	country INT,
	city INT,
	FOREIGN KEY (country) REFERENCES Country(id),
	FOREIGN KEY (city) REFERENCES City(id),
	FOREIGN KEY (owner) REFERENCES User(id)
);

CREATE TABLE Company_Collaborators(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId VARCHAR(50) NOT NULL,
	companyId INT NOT NULL,
	FOREIGN KEY (userId) REFERENCES User(id),
	FOREIGN KEY (companyId) REFERENCES Company(id)
);

CREATE TABLE PaymentType(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(30) NOT NULL
);

CREATE TABLE Contract(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	companyId INT NOT NULL,
	userId VARCHAR(50) NOT NULL,
	paymentTypeId INT NOT NULL,
	contractDate DATE,
	FOREIGN KEY (companyId) REFERENCES Company(id),
	FOREIGN KEY (userId) REFERENCES User(id),
	FOREIGN KEY (paymentTypeId) REFERENCES PaymentType(id)
);

CREATE TABLE ServiceType(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(30)  NOT NULL,
	description VARCHAR(50) NOT NULL
);

CREATE TABLE Service(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	companyId INT NOT NULL,
	serviceType INT NOT NULL,
	name VARCHAR(80) NOT NULL,
	description VARCHAR(150) NOT NULL,
	price FLOAT NOT NULL,
	isNegotiable BOOLEAN,
	score FLOAT,
	FOREIGN KEY (companyId) REFERENCES Company(id),
	FOREIGN KEY (serviceType) REFERENCES ServiceType(id)
);

CREATE TABLE Contract_Services(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	contractId INT NOT NULL,
	serviceId INT NOT NULL,
	FOREIGN KEY (contractId) REFERENCES Contract(id),
	FOREIGN KEY (serviceId) REFERENCES Service(id)
);

CREATE TABLE Address(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId VARCHAR(50) NOT NULL,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(70)  NOT NULL,
	isTheMainAddress BOOLEAN,
	longitude FLOAT,
	latitude FLOAT,
    cityId INT,
	FOREIGN KEY (userId) REFERENCES User(id),
    FOREIGN KEY (cityId) REFERENCES City(id)
);

CREATE TABLE Comment(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	userId VARCHAR(50) NOT NULL,
	contractId INT NOT NULL,
	comment VARCHAR(3000) NOT NULL,
	createdAt DATE,
	FOREIGN KEY (userId) REFERENCES User(id),
	FOREIGN KEY (contractId) REFERENCES Contract(id)
);

CREATE TABLE Notifications (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  notificationMessage TEXT NOT NULL,
  readStatus BOOLEAN NOT NULL,
  User_id VARCHAR(50) NOT NULL,
  FOREIGN KEY (User_id) REFERENCES User (id)
);