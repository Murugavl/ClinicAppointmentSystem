import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Admin(ArrayList<Doctor> doctors, ArrayList<Appointment> appointments) {
        this.doctors = doctors;
        this.appointments = appointments;
    }

    public void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Remove Doctor");
            System.out.println("4. View Bookings");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDoctor(scanner);
                    break;
                case 2:
                    viewDoctors();
                    break;
                case 3:
                    removeDoctor(scanner);
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Mobile: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        doctors.add(new Doctor(id, name, mobile, email, address, password));
        System.out.println("Doctor added successfully.");
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        for (Doctor d : doctors) {
            System.out.println("ID: " + d.getId() + ", Name: " + d.getName() + ", Email: " + d.getEmail());
        }
    }

    public void removeDoctor(Scanner scanner) {
        System.out.print("Enter Doctor ID to remove: ");
        int id = scanner.nextInt();

        for (Doctor d : doctors) {
            if (d.getId() == id) {
                doctors.remove(d);
                System.out.println("Doctor removed.");
                return;
            }
        }
        System.out.println("Doctor not found.");
    }

    public void viewBookings() {
        if (appointments.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}
