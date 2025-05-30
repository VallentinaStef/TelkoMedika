package model;

public class Doctor {
	private String name;
    private String specialty;
    private String numberPhone;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.numberPhone = "08123456789"; 
    }

    public Doctor(String name, String specialty, String numberPhone) {
        this.name = name;
        this.specialty = specialty;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void viewDoctorReservation() {
        System.out.println("Nama Dr.: " + name);
        System.out.println("Spesialisasi: " + specialty);
    }
    
    public void viewDoctorOnlineConsultation() {
        System.out.println("Nama Dr.: " + name);
        System.out.println("Spesialisasi: " + specialty);
        System.out.println("Kontak Tersedia: "+ numberPhone);
    }
}
