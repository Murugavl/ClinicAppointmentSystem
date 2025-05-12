import java.util.*;

public class Main {
    static final ArrayList<Doctor> doctors = new ArrayList<>();
    static final ArrayList<Appointment> appointments = new ArrayList<>();
    static final ArrayList<Patient> patients = new ArrayList<>();
    static Admin admin = new Admin(doctors, appointments);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Clinic Appointment System");
            System.out.println("1. Admin");
            System.out.println("2. Doctor");
            System.out.println("3. Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1 -> adminMenu(scanner);
                case 2 -> doctorLogin(scanner);
                case 3 -> patientMenu(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Remove Doctor");
            System.out.println("4. View All Bookings");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Mobile: ");
                    String mobile = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    int id = doctors.size() + 1; // Auto generate ID
                    Doctor doc = new Doctor(id, name, mobile, email, address, password);
                    doctors.add(doc);
                    System.out.println("Doctor added: " + name);
                }
                case 2 -> {
                    if (doctors.isEmpty()) System.out.println("No doctors available.");
                    else {
                        System.out.println(String.format("%-5s%-20s%-15s%-25s%-30s", "ID", "Name", "Mobile", "Email", "Address"));
                        doctors.forEach(doc -> {
                            System.out.println(String.format("%-5d%-20s%-15s%-25s%-30s", doc.getId(), doc.getName(), doc.getMobile(), doc.getEmail(), doc.getAddress()));
                        });
                    }
                }
                case 3 -> {
                    System.out.print("Enter Doctor Name to remove: ");
                    String name = scanner.nextLine();
                    doctors.removeIf(d -> d.getName().equalsIgnoreCase(name));
                    System.out.println("Doctor removed if exists.");
                }
                case 4 -> {
                    if (appointments.isEmpty()) System.out.println("No bookings yet.");
                    else {
                        // Print Appointment Table with Borders
                        System.out.println("+------------+------------+-----------------+-----------+----------------+-------+");
                        System.out.println(String.format("| %-10s | %-10s | %-15s | %-9s | %-14s | %-5s |", "Appoint. ID", "Date", "Doctor", "Status", "Prescription", "Fee"));
                        System.out.println("+------------+------------+-----------------+-----------+----------------+-------+");

                        appointments.forEach(app -> {
                            System.out.println(String.format("| %-10d | %-10s | %-15s | %-9s | %-14s | ₹%-5.2f |",
                                    app.getId(), app.getDate(), app.getDoctor().getName(), app.getStatus(),
                                    app.getPrescription(), app.getFee()));
                        });

                        System.out.println("+------------+------------+-----------------+-----------+----------------+-------+");
                    }
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void doctorLogin(Scanner scanner) {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        Doctor doctor = doctors.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        while (true) {
            System.out.println("\nDoctor Menu");
            System.out.println("1. View Appointments");
            System.out.println("2. Attend Patient");
            System.out.println("3. Discharge Patient");
            System.out.println("4. Prescribe Medicine");
            System.out.println("5. Collect Fees");
            System.out.println("6. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> doctor.viewAppointments();
                case 2 -> {
                    System.out.print("Enter Appointment ID: ");
                    int appId = scanner.nextInt();
                    scanner.nextLine();
                    doctor.attendPatient(appId);
                }
                case 3 -> {
                    System.out.print("Enter Appointment ID: ");
                    int appId = scanner.nextInt();
                    scanner.nextLine();
                    doctor.dischargePatient(appId);
                }
                case 4 -> {
                    System.out.print("Enter Appointment ID: ");
                    int appId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Medicine: ");
                    String medicine = scanner.nextLine();
                    doctor.prescribeMedicine(appId, medicine);
                }
                case 5 -> {
                    System.out.print("Enter Appointment ID: ");
                    int appId = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Fee Amount: ");
                    double fee = scanner.nextDouble();
                    doctor.collectFees(appId, fee);
                }
                case 6 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void patientMenu(Scanner scanner) {
        System.out.print("Enter Patient Name (or 0 to register): ");
        String name = scanner.nextLine();

        Patient patient;
        if (name.equals("0")) {
            System.out.print("Name: ");
            String newName = scanner.nextLine();
            System.out.print("Mobile: ");
            String mobile = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            int id = patients.size() + 1;
            patient = new Patient(id, newName, mobile, email, address);
            patients.add(patient);
            System.out.println("Registered with ID: " + id);
        } else {
            patient = patients.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
            if (patient == null) {
                System.out.println("Patient not found.");
                return;
            }
        }

        while (true) {
            System.out.println("\nPatient Menu");
            System.out.println("1. View Doctors");
            System.out.println("2. Book Appointment");
            System.out.println("3. View My Appointments");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    if (doctors.isEmpty()) System.out.println("No doctors available.");
                    else {
                        System.out.println(String.format("%-5s%-20s%-15s%-25s%-30s", "ID", "Name", "Mobile", "Email", "Address"));
                        doctors.forEach(doc -> {
                            System.out.println(String.format("%-5d%-20s%-15s%-25s%-30s", doc.getId(), doc.getName(), doc.getMobile(), doc.getEmail(), doc.getAddress()));
                        });
                    }
                }
                case 2 -> {
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors available.");
                        return;
                    }
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    Doctor doc = doctors.stream().filter(d -> d.getName().equalsIgnoreCase(doctorName)).findFirst().orElse(null);
                    if (doc == null) {
                        System.out.println("Doctor not found.");
                        return;
                    }
                    System.out.print("Enter Appointment Date: ");
                    String date = scanner.nextLine();
                    patient.bookAppointment(doc, date);
                }
                case 3 -> patient.viewAppointments();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
