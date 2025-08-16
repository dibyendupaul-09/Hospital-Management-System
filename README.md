# 🏥 Hospital Management System (Java + MySQL)

A **console-based Hospital Management System** built with **Java** and **MySQL**. 
This project allows you to **add, view, update, and delete patient records** from a MySQL database.

---

## ✨Features
- Add new patients
- View all patients
- Update patient details
- Delete patient records
- Exit the system

---

## 🛠️Technologies Used
- **Java** (JDK 20+)
- **MySQL** (Workbench / Server)
- **JDBC Driver** (MySQL Connector/J)

---

## Requirements
- Java Development Kit (JDK) installed  
- MySQL Server and Workbench installed  
- MySQL Connector/J (JAR file added to project)

---
## 📂 Project Structure
```
Hospital-Management/
│
├── HospitalManagement.java # Main program
├── hospitaldb.sql # Database script
├── mysql-connector-j-x.x.x.jar # JDBC Driver
└── README.md # Project description
```

## 🛢Database Setup
1. Open MySQL Workbench.
2. Create the database(if needed):
```sql
CREATE DATABASE IF NOT EXISTS hospitaldb;
USE hospitaldb;
```
3.Create the table:
 ```sql
CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    disease VARCHAR(100)
);
 ```
## Project Setup
1. Clone or download this repository.
  ```sql
sql git clone https://github.com/dibyendupaul-09/Hospital-Management-System.git
cd hospital-management-system 
  ```
2. Add mysql-connector-j-x.x.x.jar to your project’s classpath.
3. Update database credentials in the Java file:
 ```java
   String url = "your_db_url";
   String user = "root";
   String password = "your_password";
 ```
4.Compile & run:
 ```java
   javac -cp .;mysql-connector-j-x.x.x.jar Main.java
   java -cp .;mysql-connector-j-x.x.x.jar Main
 ```
## Example Usage
```
1. Add Patient 
2. View Patients 
3. Update Patient 
4. Delete Patient 
5. Exit
```
