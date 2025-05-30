package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Patient extends Account {
    private String name;
    private String phoneNumber;
    private String address;
    private ArrayList<Reservation> reservations;

    public Patient(String username, String password, String name,String phoneNumber, String address) {
        super(username, password);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.reservations = new ArrayList<>();
    }

    public String getName() {
		return name;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public ArrayList<Reservation> getReservations() {
		return reservations;
	}



	public Reservation createReservation(String doctorName, LocalDate date, String keluhan, String status) {
	    LocalDate today = LocalDate.now();
	    
	    if (date.isBefore(today)) {
	        System.out.println("❌ Tanggal tidak valid. Tidak bisa memilih tanggal yang sudah lewat.");
	        return null;
	    }

	    Reservation reservasi = new Reservation(name, doctorName, date, keluhan, status);
	    reservations.add(reservasi); // Simpan ke list jika valid
	    return reservasi;
	}


    public void viewHistory() {
        System.out.println("=== Riwayat Reservasi ===");
        if (reservations.isEmpty()) {
            System.out.println("Belum ada riwayat.");
        } else {
            for (Reservation r : reservations) {
                System.out.println("Dokter: " + r.getDoctorName() + 
                                   " | Tanggal: " + r.getAppointmentDate() +
                                   " | Keluhan: " + r.getkeluhan() +
                                   " | Status: " + r.getStatus());
            }
        }
    }

    public String getAddress() {
        return address;
    }
}