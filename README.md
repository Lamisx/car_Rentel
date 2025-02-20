# Car Rental Software

## Overview
A Java Swing-based desktop application for managing car rentals. It allows users to browse cars, book rentals, and manage reservations, while administrators can oversee inventory, transactions, and user accounts.

## Features
### User Features
- **Sign Up & Login:** Secure authentication for users.
- **Car Browsing:** View available cars with details.
- **Car Booking:** Rent cars with a specified duration.
- **Rental Management:** View and cancel bookings.
- **Profile Management:** Update personal details.

### Admin Features
- **Car Inventory Management:** Add, modify, or remove cars.
- **Rental History Tracking:** Monitor rental transactions.
- **User Management:** Manage user accounts and roles.
- **Reports & Analytics:** Generate reports on bookings and revenue.

## Technologies Used
- **Language:** Java
- **GUI:** Java Swing
- **Database:** MySQL (Amazon RDS)
- **IDE:** NetBeans

## Database Structure
- **Users:** Stores user credentials and roles.
- **Vehicles:** Maintains car details and availability.
- **Bookings:** Records rental transactions.
- **Reports:** Logs revenue and booking data.

## Installation & Setup
```sh
# Clone the repository
git clone https://github.com/YourUsername/Car_Rental_Software.git

# Navigate to the project directory
cd Car_Rental_Software
```
### Configure Database Connection:
- Ensure MySQL is installed and running.
- Update database credentials in the configuration file.

### Run the Application:
- Open the project in NetBeans.
- Compile and run the application.

## Exception Handling
- **EmptyFieldException:** Prevents blank required fields.
- **InvalidLoginException:** Handles incorrect login attempts.
- **SQLException:** Manages database connection errors.
- **InvalidFormatException:** Ensures input validation.

## Testing
The application was tested for:
- Button functionalities
- Login & sign-up interactions
- Booking and cancellation workflows
- Admin dashboard operations

## Contributors
- [@Lamisx](https://github.com/Lamisx) – Booking system, database design
- [@layanmoha](https://github.com/layanmoha) – Return processing, notifications, admin GUI
- [@HANANCS451](https://github.com/HANANCS451) – Authentication, car browsing, main GUI design
- [@shahadf11](https://github.com/shahadf11) – Admin dashboard, reporting module

## Supervisor
Dr. Fatimah Alkhudayr

## License
This project is licensed under the MIT License.

## Additional Documentation
For more details, see: [Car Rental Software Documentation](./Car_Rental_Software.pdf)

## Contact
For inquiries or contributions, reach out to the development team.
