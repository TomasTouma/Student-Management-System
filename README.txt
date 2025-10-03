Student Management System

GitHub Repository: https://github.com/TomasTouma/Student-Management-System
=========================

Project Overview
----------------
This is a Java Swing-based Student Management System that provides a comprehensive interface for managing student records, including personal information, course enrollment, and assessments. The application connects to a MySQL database for data persistence.

Features
--------
- View, add, edit, and delete student records
- Manage student personal information (name, contact details, address, etc.)
- Track course enrollment and class groups
- Calculate student age automatically from date of birth
- View and edit student assessments
- Print student details
- Input validation for various fields
- Database integration with MySQL

Technical Specifications
------------------------
- Language: Java
- Framework: Swing (GUI)
- Database: MySQL
- JDBC: Database connectivity
- IDE: NetBeans
- Java Version: 1.8 or higher

Project Structure
-----------------
- Main Class: StudentForm.java
- Supporting Classes:
  - AddStudentFrame (for adding new students)
  - StudentViewFrame (for searching/viewing students)
  - StudentAssessmentFrame (for managing assessments)
  - PrintFrame (for printing student details)
  - Student (data model class)
  - ValidationAndCalculationMethods (utility class)

Database Configuration
----------------------
The application connects to a MySQL database with the following settings:
- Database Name: finaleprojectdb
- URL: jdbc:mysql://127.0.0.1:3306/finaleprojectdb
- Username: root
- Password: root

Database Setup:
--------------
1. Import the database schema:
   mysql -u root -p < database/schema.sql
   
2. Or manually create the database and import schema.sql from the database folder

Required Database Tables
------------------------
1. student
   - student_id, first_name, surname, email, phone_number, ppsn, gender, 
     date_of_birth, age, address_line_1, address_line_2, county, eircode, 
     class_group_code

2. course
   - course_name

3. class_group
   - class_group_code, course_name

Installation & Setup
--------------------
1. Ensure you have Java 1.8 or higher installed
2. Install MySQL and create a database named 'finaleprojectdb'
3. Import the provided SQL schema to create the required tables
4. Update database connection details in StudentForm.java if different from default
5. Compile and run the application

GitHub Installation:
-------------------
1. Clone the repository:
   git clone https://github.com/TomasTouma/Student-Management-System.git
   
2. Navigate to the project directory:
   cd Student-Management-System

How to Use
----------
1. Running the Application:
   - Execute StudentForm.java to start the application
   - Use the parameterized constructor to open a specific student record

2. Main Functions:
   - Add Student: Opens a form to add new students
   - Save: Updates existing student information
   - Delete: Removes student record (with confirmation)
   - View/Edit Assessment: Opens assessment management for the student
   - Print: Generates a printable version of student details
   - Search: Opens student search interface
   - Close: Exits the current form

3. Form Fields:
   - Personal Details: First Name, Surname, Email, Phone, PPSN, Gender, DOB, Age
   - Address: Address Line 1 & 2, County, Eircode
   - Academic: Course Name, Class Group

Validation Features
-------------------
- First Name: Letters only
- PPSN: Digits and letters only
- Age: Digits only
- County: Letters only

Dependencies
------------
- MySQL Connector/J (JDBC driver)
- JCalendar library (for date picker)
- Standard Java Swing components

File Information
----------------
- Filename: StudentForm.java
- Author: Tomasz Touma
- Version: 1.0
- Last Modified: 03/10/2025

Notes
-----
- The age field is automatically calculated from the date of birth
- Course and class group dropdowns are dynamically populated from the database
- All database operations include proper error handling
- The application uses prepared statements to prevent SQL injection

Troubleshooting
---------------
- Ensure MySQL service is running
- Verify database credentials in the code
- Check that all required tables exist in the database
- Confirm JDBC driver is in the classpath

License
-------

This project is available for educational and demonstration purposes. Please ensure proper attribution for any reuse or modification.

Support
-------

Repository Information
----------------------
- GitHub: https://github.com/TomasTouma/Student-Management-System
- Main Branch: main
- Last Updated: 03/10/2025

Contributing
------------
Feel free to fork this repository and submit pull requests for improvements.
