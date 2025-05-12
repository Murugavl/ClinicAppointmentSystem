import java.util.ArrayList;

public class Doctor {
    private int id;
    private String name;
    private String mobile;
    private String email;
    private String address;
    private String password;
    private ArrayList<Appointment> myAppointments = new ArrayList<>();

    public Doctor(int id, String name, String mobile, String email, String address, String password) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public String getAddress() { return address; }

    public void addAppointment(Appointment appointment) {
        myAppointments.add(appointment);
    }

    public void viewAppointments() {
        if (myAppointments.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }
        for (Appointment a : myAppointments) {
            System.out.println(a);
        }
    }

    public void attendPatient(int appId) {
        for (Appointment a : myAppointments) {
            if (a.getId() == appId) {
                a.setStatus("Attended");
                System.out.println("Patient attended.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public void dischargePatient(int appId) {
        for (Appointment a : myAppointments) {
            if (a.getId() == appId) {
                a.setStatus("Discharged");
                System.out.println("Patient discharged.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public void prescribeMedicine(int appId, String medicine) {
        for (Appointment a : myAppointments) {
            if (a.getId() == appId) {
                a.setMedicine(medicine);
                System.out.println("Medicine prescribed.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public void collectFees(int appId, double fee) {
        for (Appointment a : myAppointments) {
            if (a.getId() == appId) {
                a.setFee(fee);
                System.out.println("Fees collected: " + fee);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
}
