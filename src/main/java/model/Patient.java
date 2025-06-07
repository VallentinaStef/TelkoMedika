package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Account implements Reservable{
    private String name;
    private String phoneNumber;
    private String address;
    private ArrayList<Reservation> reservations;
    private List<String> notifications = new ArrayList<>();

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


    public String getAddress() {
        return address;
    }

	public Reservation createReservation(String doctorName, LocalDate date, String keluhan, String status) {
	    LocalDate today = LocalDate.now();
	    
	    if (date.isBefore(today)) {
	        System.out.println("❌ Tanggal tidak valid. Tidak bisa memilih tanggal yang sudah lewat.");
	        return null;
	    }

	    Reservation reservasi = new Reservation(name, doctorName, date, keluhan, status, "online");
	    reservations.add(reservasi); 
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
    
   
    public void addNotification(String notif) {
        notifications.add(notif);
    }

    public void viewNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("Tidak ada notifikasi.");
        } else {
            for (String notif : notifications) {
                System.out.println("- " + notif);
            }
        }
    }

    

}