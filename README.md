# 🧑‍💻 Employee Records Management System

## 📌 Project Overview

The **Employee Records Management System** (ERMS) is a comprehensive application designed to manage and centralize employee data across departments. This system facilitates efficient management of employee records, role-based access control, and an audit trail for all changes made to employee data.

---

## 🚀 Features

### 1. **Employee Data Management**

- Full Name
- Employee ID
- Job Title
- Department
- Hire Date
- Employment Status
- Contact Information
- Address

### 2. **User Roles & Permissions**

- **HR Personnel**: Full CRUD (Create, Read, Update, Delete) operations on employee data.
- **Managers**: View and update employee records within their department.
- **Administrators**: Full access to the system, including configurations and managing user permissions.

### 3. **Audit Trail**

Track changes made to employee records, with information on who made the changes and when.

### 4. **Search and Filtering**

- Search employees by name, ID, department, or job title.
- Filter based on employment status, department, and hire date.

### 5. **Validation Rules**

- Valid email formats.
- Unique employee IDs.
  
### 6. **Reporting**

Generate reports on employee data.

---

## ⚙️ Technologies Used

- **Java 17** 🖥️
- **Spring Boot 2.x** 🔧
- **Spring Security** 🔒
- **JWT** 🔑
- **Spring Data JPA** 📊
- **Oracle SQL** (or any other SQL database) 🗄️
- **Docker** 🐋
- **Swing** (for Desktop UI) 💻
- **MigLayout** & **GridBagLayout** (for layout) 🧑‍🎨
- **JUnit** & **Mockito** (for testing) 🧪
- **Postman** (for API testing) 📱

---

## 🛠️ Project Setup

### 📋 Prerequisites

Ensure the following are installed:

- **Java 17** or newer.
- **Docker** 🐳.
- **Oracle SQL Database** (or any other RDBMS).
- **Maven** (for building the project).
- **Postman** for API testing.

---

### 📥 Clone the Repository

```bash
git clone https://github.com/your-username/employee-records-management-system.git
cd employee-records-management-system
