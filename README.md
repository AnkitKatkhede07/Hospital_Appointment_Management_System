# Hospital Appointment Management System

## Project Overview
Hospital Appointment Management System is a web-based application developed using Java Full Stack technologies. The project helps hospitals manage doctors, patients, and appointments digitally. It reduces manual work and improves appointment management efficiency.

---

# Technologies Used

- Core Java
- JDBC
- Servlet
- HTML
- CSS
- JavaScript
- MySQL
- Apache Tomcat

---

# Features

- Admin Login
- Patient Registration & Login
- Doctor Management
- Appointment Booking
- View Appointments
- CRUD Operations
- Database Connectivity
- User-Friendly Interface

---

# Modules

## Admin Module
- Add Doctor
- View Doctors
- Manage Appointments
- View Patients

## Patient Module
- Patient Registration
- Patient Login
- Book Appointment
- View Appointment Details

---

# Project Flow

1. User opens the application.
2. Patient registers or logs in.
3. Patient selects doctor and appointment date.
4. Appointment details are stored in database.
5. Admin can manage doctors and appointments.
6. Data is retrieved dynamically using JDBC.

---

# Database Information

Database Name: `hospitalapp`

## Tables Used

### 1. admins
Stores admin login details.

| Column | Type |
|---|---|
| id | int |
| email | varchar |
| password | varchar |

---

### 2. doctors
Stores doctor information.

| Column | Type |
|---|---|
| id | int |
| name | varchar |
| specialization | varchar |
| mobile | varchar |
| email | varchar |
| fees | decimal |

---

### 3. patients
Stores patient details.

| Column | Type |
|---|---|
| id | int |
| name | varchar |
| age | int |
| gender | varchar |
| mobile | varchar |
| disease | varchar |
| password | varchar |

---

### 4. appointments
Stores appointment records.

| Column | Type |
|---|---|
| id | int |
| patient_id | int |
| doctor_id | int |
| appointment_date | date |
| status | varchar |

---

# Database Relationships

- `appointments.patient_id` references `patients.id`
- `appointments.doctor_id` references `doctors.id`

Foreign keys are used to maintain relationships between tables.

---

# Advantages

- Reduces paperwork
- Easy appointment management
- Fast data access
- User-friendly system
- Digital record management

---

# Future Scope

- AI Chatbot Integration
- Online Payment Gateway
- Email/SMS Notification
- Doctor Availability Tracking
- Report Generation

---

# Conclusion

This project helps hospitals manage appointments efficiently through a digital system. It improves patient management and reduces manual work using Java Full Stack technologies.

---

# Developed By

**Ankit Gajanan Katkhede**  
BE Information Technology  
Sant Gadge Baba Amravati University
