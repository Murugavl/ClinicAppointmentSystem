public class Appointment {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;
    private String prescription;
    private String medicine;
    private double fee;

    public Appointment(int id, Patient patient, Doctor doctor, String date) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = "Scheduled";
        this.prescription = "";
        this.fee = 0.0;
    }

    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getPrescription() { return prescription; }
    public double getFee() { return fee; }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public void setStatus(String status) { this.status = status; }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + id +
                ", Date: " + date +
                ", Doctor: " + doctor.getName() +
                ", Status: " + status +
                ", Prescription: " + (prescription.isEmpty() ? "N/A" : prescription) +
                ", Fee: ₹" + fee;
    }
}
