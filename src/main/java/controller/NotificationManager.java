package controller;

import java.time.LocalDate;
import java.util.List;

import model.Patient;
import model.Reservation;

public class NotificationManager {
	public static void sendReservationCreated(Patient patient, String doctorName, LocalDate date) {
        patient.addNotification("Reservasi dengan Dr. " + doctorName + " berhasil dibuat untuk tanggal " + date + ".");
    }

    public static void sendMedicineOnDelivery(Patient patient) {
        patient.addNotification("Obat Anda sedang dalam perjalanan.");
    }

    public static void sendReservationUpdated(Patient pasien, LocalDate date) {
        pasien.addNotification("Reservasi Anda berhasil diupdate.");
    }

    public static void sendObatDiambilLangsung(Patient patient) {
        patient.addNotification("Silakan ambil obat Anda langsung di apotek.");
    }
}
