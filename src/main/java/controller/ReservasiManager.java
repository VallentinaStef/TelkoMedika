package controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Doctor;
import model.OnlineConsultation;
import model.Patient;
import model.Reservation;

public class ReservasiManager {
	public Scanner scanner = new Scanner(System.in);

    public void createReservation(Patient pasien, List<Doctor> doctorList, QueueManager queueManager, Scanner scanner) {
        if (!queueManager.isQueueAvailable()) {
            System.out.println("Antrean penuh! Tidak bisa membuat reservasi.");
            return;
        }

        System.out.println("Pilih jenis konsultasi:");
        System.out.println("1. Online");
        System.out.println("2. Offline");
        System.out.print("Masukkan pilihan: ");
        int konsultasiType = Integer.parseInt(scanner.nextLine());

        switch (konsultasiType) {
            case 1:
                createOnlineReservation(pasien, doctorList, queueManager, scanner);
                break;
            case 2:
                createOfflineReservation(pasien, doctorList, queueManager, scanner);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    private static void createOfflineReservation(Patient pasien, List<Doctor> doctorList, QueueManager queueManager, Scanner scanner) {
        System.out.println("--- Konsultasi Offline ---");
        for (Doctor doctor : doctorList) {
            doctor.viewDoctorReservation();
            System.out.println();
        }

        System.out.print("Masukkan nama dokter: ");
        String doctorName = scanner.nextLine();

        System.out.print("Masukkan tanggal konsultasi (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate appointmentDate = LocalDate.parse(dateInput);

        System.out.print("Masukkan keluhan: ");
        String keluhan = scanner.nextLine();

        Doctor selectedDoctor = null;
        for (Doctor doc : doctorList) {
            if (doc.getName().equalsIgnoreCase(doctorName)) {
                selectedDoctor = doc;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Nama dokter tidak valid.");
            return;
        }

        if (!queueManager.takeQueue()) {
            System.out.println("Antrean penuh! Tidak bisa membuat reservasi.");
            return;
        }

        Reservation newReservation = pasien.createReservation(doctorName, appointmentDate, keluhan, "Menunggu");
        System.out.println("Reservasi konsultasi offline berhasil dibuat!");
        System.out.println("Sisa antrean: " + queueManager.getRemainingQueue());
        
        pasien.addNotification("Reservasi dengan Dr. " + doctorName + " berhasil dibuat untuk tanggal " + appointmentDate + ".");

    }

    private static void createOnlineReservation(Patient pasien, List<Doctor> doctorList, QueueManager queueManager, Scanner scanner) {
        System.out.println("--- Konsultasi Online ---");
        for (Doctor doctor : doctorList) {
            doctor.viewDoctorReservation();
            System.out.println();
        }

        System.out.print("Masukkan nama dokter: ");
        String doctorName = scanner.nextLine();

        System.out.print("Masukkan tanggal konsultasi (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate appointmentDate = LocalDate.parse(dateInput);

        System.out.print("Masukkan keluhan: ");
        String keluhan = scanner.nextLine();

        Doctor selectedDoctor = null;
        for (Doctor doc : doctorList) {
            if (doc.getName().equalsIgnoreCase(doctorName)) {
                selectedDoctor = doc;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Nama dokter tidak valid.");
            return;
        }

        if (!queueManager.takeQueue()) {
            System.out.println("Antrean penuh! Tidak bisa membuat reservasi.");
            return;
        }

        // Simulasi proses konsultasi online
        OnlineConsultation konsultasi = new OnlineConsultation(doctorName, "Pasien keluhan: " + keluhan, appointmentDate);
        konsultasi.startConsultation();
        if (selectedDoctor.getSpecialty().equalsIgnoreCase("Umum")) {
			konsultasi.GeneralConsultation();
		} else if (selectedDoctor.getSpecialty().equalsIgnoreCase("Gigi")) {
			konsultasi.TheetConsultation();
		}
        System.out.println();
        konsultasi.endConsultation();

        // Obat berdasarkan spesialisasi
        String obat = "";
        if (selectedDoctor.getSpecialty().equalsIgnoreCase("Umum")) {
            obat = "Paracetamol";
        } else if (selectedDoctor.getSpecialty().equalsIgnoreCase("Gigi")) {
            obat = "Obat Gigi";
        } else {
            obat = "Obat sesuai anjuran dokter";
        }

        System.out.println("Dokter memberikan obat: " + obat);

        System.out.println("Pilih metode pengambilan obat:");
        System.out.println("1. Diantar (COD, Ongkir Rp7.000)");
        System.out.println("2. Ambil langsung ke klinik");
        System.out.print("Masukkan pilihan: ");
        int pilihan = Integer.parseInt(scanner.nextLine());

        if (pilihan == 1) {
        	pasien.addNotification("Obat Anda sedang dalam perjalanan.");
            System.out.println("Obat akan dikirim ke alamat Anda. Total ongkir: Rp7.000");
        } else if (pilihan == 2) {
            System.out.println("Silakan ambil obat langsung di klinik.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        pasien.createReservation(doctorName, appointmentDate, keluhan, "Selesai");
        
        pasien.addNotification("Reservasi dengan Dr. " + doctorName + " berhasil dibuat untuk tanggal " + appointmentDate + ".");

        System.out.println("Reservasi konsultasi online selesai. Terima kasih!");
        System.out.println("Sisa antrean: " + queueManager.getRemainingQueue());
    }
    
    public void showReservationOptions(Patient pasien, Scanner scanner) {
        pasien.viewHistory();

        if (pasien.getReservations().isEmpty()) return;

        System.out.println("\nPilih aksi:");
        System.out.println("1. Update Reservasi");
        System.out.println("2. Hapus Reservasi");
        System.out.println("3. Kembali");
        System.out.print("Masukkan pilihan: ");
        int pilihan = Integer.parseInt(scanner.nextLine());

        switch (pilihan) {
            case 1:
            	updateReservasi(pasien ,pasien.getReservations());
                break;
            case 2:
                deleteReservation(pasien, scanner);
                break;
            case 3:
                return;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    
    public void updateReservasi(Patient pasien, List<Reservation> reservationList) {

        System.out.println("=== Daftar Riwayat Reservasi ===");
        for (int i = 0; i < reservationList.size(); i++) {
            System.out.println((i + 1) + ". " + reservationList.get(i).getDoctorName()
                + " - " + reservationList.get(i).getTipeKonsultasi()
                + " - " + reservationList.get(i).getStatus());
        }

        System.out.print("Pilih nomor reservasi yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (index < 0 || index >= reservationList.size()) {
            System.out.println("❌ Pilihan tidak valid.");
            return;
        }

        Reservation selected = reservationList.get(index);

        if (selected.getStatus().equalsIgnoreCase("selesai")) {
            System.out.println("❌ Tidak dapat mengubah reservasi yang sudah selesai.");
            return;
        }

        try {
        	System.out.print("Masukkan tanggal baru (YYYY-MM-DD): ");
            String tanggalBaruStr = scanner.nextLine();
            LocalDate tanggalBaru = LocalDate.parse(tanggalBaruStr);
            selected.setAppointmentDate(tanggalBaru);
            pasien.addNotification("Reservasi Anda berhasil diupdate.");   
            System.out.println("✅ Reservasi berhasil diperbarui.");
		} catch (DateTimeParseException  e) {
			System.out.println("isi dengan format yang sesuai");
		}
        
    }


    public void deleteReservation(Patient pasien, Scanner scanner) {
        ArrayList<Reservation> reservations = pasien.getReservations();

        if (reservations.isEmpty()) {
            System.out.println("Belum ada reservasi yang bisa dihapus.");
            return;
        }

        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            System.out.println((i + 1) + ". Dokter: " + r.getDoctorName() + " | Tanggal: " + r.getAppointmentDate());
        }

        try {
            System.out.print("Masukkan nomor reservasi yang ingin dihapus: ");
            int index = Integer.parseInt(scanner.nextLine()) - 1;

            Reservation removed = reservations.remove(index);
            System.out.println("Reservasi dengan dokter " + removed.getDoctorName() + " berhasil dihapus.");
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nomor reservasi tidak valid.");
        }
        pasien.addNotification("Reservasi berhasil di hapus");
    }
    
    

}
