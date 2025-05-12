import java.util.ArrayList;

public class Patient {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private ArrayList<Appointment> myAppointments = new ArrayList<>();

    public Patient(int id, String name, String mobile, String email, String address) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void bookAppointment(Doctor doctor, String date) {
        int appointmentId = myAppointments.size() + 1;
        Appointment appointment = new Appointment(appointmentId, this, doctor, date);
        myAppointments.add(appointment);
        doctor.addAppointment(appointment);
        System.out.println("Appointment booked successfully.");
    }

    public void viewDoctors(ArrayList<Doctor> doctors) {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
            return;
        }
        for (Doctor doc : doctors) {
            System.out.println("ID: " + doc.getId() + ", Name: " + doc.getName() + ", Email: " + doc.getEmail());
        }
    }

    public void viewAppointments() {
        if (myAppointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        for (Appointment a : myAppointments) {
            System.out.println(a);
        }
    }
}
