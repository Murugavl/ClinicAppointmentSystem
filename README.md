# 🏥 Clinic Appointment System

A **console-based Java application** designed to manage appointments, doctors, patients, and clinic operations efficiently. This system helps streamline clinic workflows and ensures smooth interaction between admins, doctors, and patients.

---

## 📋 Table of Contents

- [Features](#-features)
- [User Roles](#-user-roles)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Technologies Used](#-technologies-used)
- [Future Enhancements](#-future-enhancements)
- [Contributors](#-contributors)
- [License](#-license)

---

## ✅ Features

- Console-based interactive menu system
- Role-based access for Admin, Doctor, and Patient
- Appointment booking and management
- Doctor prescription and discharge system
- Admin functionalities to manage doctors and view all bookings
- Simple data handling with Java collections

---

## 👥 User Roles

### 🧑‍💼 Admin
- Add new doctors
- View all doctors
- Remove existing doctors
- View all appointment bookings

### 🩺 Doctor
- View list of assigned patients
- Attend patients
- Discharge patients
- Prescribe medication
- Collect consultation fees

### 👤 Patient
- Book appointments with available doctors
- View appointment details
- Check doctor availability

---

## 📂 Project Structure

ClinicAppointmentSystem/
├── .idea/ # IDE settings (ignore)
├── src/
│ ├── main/
│ │ ├── Admin.java # Admin functions
│ │ ├── Doctor.java # Doctor functionalities
│ │ ├── Patient.java # Patient functionalities
│ │ ├── Login.java # Login and role authentication
│ │ ├── Booking.java # Booking-related operations
│ │ └── ClinicAppointmentSystem.java # Main class (entry point)
├── ClinicAppointmentSystem.iml # IntelliJ project file
└── .gitignore # Git ignore rules


---

## ▶️ Run via IntelliJ IDEA / Eclipse

1. Open the project in your IDE.
2. Set `ClinicAppointmentSystem.java` as the main class.
3. Run the program.

---

## ⚙️ Technologies Used

- Java (Standard Edition)
- Object-Oriented Programming (OOP)
- Console I/O

---

## 🔮 Future Enhancements

- Connect with a database for persistent storage
- Add input validation and error handling
- Create a GUI using JavaFX or Swing
- Add email/SMS notifications for appointments
- Role-based login system with encrypted passwords

---

## 👨‍💻 Contributors

- [Murugavl](https://github.com/Murugavl)

---

## 📄 License

This project is licensed under the **MIT License**.
