# Car Rental Software

## Overview
This project was developed as part of the **Visual Programming (CS342)** course, focusing on GUI development using Java Swing.
Car Rental Software is a desktop application designed to facilitate the process of renting and managing cars for both customers and administrators. The system provides an intuitive interface for users to browse available cars, book rentals, and manage reservations, while administrators can oversee vehicle inventory, rental transactions, and user accounts.

## Features

### User Features
- **Sign Up & Login**: Secure authentication system allowing users to register and log in.
- **Car Browsing**: Users can view available cars with details such as model, type, color, and price per day.
- **Car Booking**: Users can select a car, specify rental duration, and confirm bookings.
- **Rental Management**: Users can view their rental history and cancel active bookings if necessary.
- **Profile Management**: Users can update personal information securely.

### Admin Features
- **Car Inventory Management**: Administrators can add, modify, or delete car listings.
- **Rental History Tracking**: A detailed overview of all rental transactions.
- **User Management**: Ability to manage user accounts and access levels.
- **Reports & Analytics**: Generate reports on revenue, bookings, and car availability.

## Technologies Used
- **Programming Language**: Java
- **Framework**: Java Swing for GUI
- **Database**: MySQL (hosted on Amazon RDS)
- **IDE**: NetBeans

## Database Structure
The database consists of four main tables:
1. **Users**: Stores login credentials, roles (customer/admin), and contact details.
2. **Vehicles**: Maintains details about available cars, including rental status.
3. **Bookings**: Records rental transactions, start and end dates, and costs.
4. **Reports**: Logs rental statistics and revenue data.

## Installation & Setup
1. **Clone the repository**:
   ```sh
   git clone https://github.com/YourUsername/Car_Rental_Software.git
   ```
2. **Navigate to the project directory**:
   ```sh
   cd Car_Rental_Software
   ```
3. **Configure Database Connection**:
   - Ensure MySQL is installed and running.
   - Update database credentials in the configuration file.
4. **Run the application**:
   - Open the project in NetBeans.
   - Compile and run the application.

## Exception Handling
The system includes built-in exception handling mechanisms such as:
- **EmptyFieldException**: Triggered when required fields are left blank.
- **InvalidLoginException**: Thrown for incorrect credentials.
- **SQLExceptions**: Handles database connection errors.
- **InvalidFormatException**: Ensures proper input validation (e.g., correct phone number format).

## Testing
The application was thoroughly tested, covering:
- Main screen button functionality
- Login & Sign-up interactions
- Booking and cancellation workflows
- Admin dashboard operations

## Contributors
- **Lamis Alharbi** – Booking system, database design
- **Layan Alswilem** – Return processing, notifications, admin GUI
- **Hanan Alrashidi** – Authentication, car browsing, main GUI design
- **Shahad Alharbi** – Admin dashboard, reporting module

## Supervisor
**Dr. Fatimah Alkhudayr**

## License
This project is licensed under the MIT License. See `LICENSE` for details.

## Additional Documentation
For more detailed information, refer to the full project documentation:
[Car Rental Software Documentation](./Car Rental Software.pdf)

## Contact
For any inquiries or contributions, please reach out to the development team.

