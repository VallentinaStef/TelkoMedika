package Layanan.TelkoMedika;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import model.*;


public class Main {
    private static final Doctor Doctor = null;

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patient pasien = null;
        ArrayList<Account> userList = new ArrayList<>();
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        
        Patient pasien1 = new Patient("pasien1", "12345", "Tepani", "08123456789", "Bandung");
        Patient pasien2 = new Patient("pasien2", "password123", "Budi", "082233445566", "Jakarta");
        
        userList.add(pasien1);
        userList.add(pasien2);
        
        patientList.add(pasien1);
        patientList.add(pasien2);
        
        Doctor[] doctor = {
        	new Doctor("Andi", "Umum", "081234111111"),
        	new Doctor("Budi", "Gigi", "081234222222"),
        	new Doctor("Citra", "Kulit", "081234333333")
        }; 

        System.out.println("=== TELKOM MEDIKA SYSTEM ===");

        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean found = false;
        for (Account acc : userList) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                if (acc instanceof Patient) {
                    pasien = (Patient) acc;
                    System.out.println("Login berhasil sebagai " + pasien.getName() + "!\n");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Login gagal.");
            System.exit(0);
        }
        
        QueueManager queueManager = new QueueManager(10);

        int pilihan = -1;
        while (pilihan != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Buat Reservasi");
            System.out.println("2. Lihat Riwayat");
            System.out.println("3. Konsultasi Online");
            System.out.println("4. Minta Pengiriman Obat");
            System.out.println("5. Lihat Notifikasi");
            System.out.println("6. Baca Berita");
            System.out.println("0. LogOut");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
            case 1: 
                if (!queueManager.isQueueAvailable()) {
                    System.out.println("Antrean penuh! Tidak bisa membuat reservasi.");
                    break;
                }
                
                for (Doctor doctor2 : doctor) {
        			doctorList.add(doctor2);
        			doctor2.viewDoctorReservation();
        			System.out.println();
        		}

                System.out.print("Masukkan nama dokter: ");
                String doctorName = scanner.nextLine();

                System.out.print("Masukkan tanggal (yyyy-mm-dd): ");
                String dateInput = scanner.nextLine();
                LocalDate appointmentDate = LocalDate.parse(dateInput);
                
                System.out.print("Masukkan keluhan: ");
                String keluhan = scanner.nextLine();

                String status = "Menunggu";
                
                Doctor selectedDoctor = null;
                boolean check = false;
                for (Doctor namadoc : doctorList) {
                	 if (doctorName.equalsIgnoreCase(namadoc.getName())) {
                         if (namadoc instanceof Doctor) {
                        	 selectedDoctor = namadoc;
                             check = true;
                         }
                     }
                }
                if (!check) {
                    System.out.println("Nama dokter tidak valid");
                    continue;
                }

                if (queueManager.takeQueue()) {
                	Reservation newReservation = pasien.createReservation(doctorName, appointmentDate, keluhan, status);
                	if (newReservation != null) {
                	    System.out.println("Reservasi berhasil dibuat!");
                	} else {
                	    
                	    System.out.println("Reservasi gagal. Antrean dikembalikan.");
                	    queueManager.returnQueue(); 
                	}
                    System.out.println("Sisa antrean: " + queueManager.getRemainingQueue());
                } else {
                    System.out.println("Antrean penuh! Tidak bisa membuat reservasi.");
                }
                
                break;
                case 2:
                    pasien.viewHistory();
                    break;
                case 3:
                    OnlineConsultation konsultasi = new OnlineConsultation("Dr. Andi", "Keluhan: pusing", LocalDate.now());
                    konsultasi.startConsultation();
                    konsultasi.endConsultation();
                    break;
                case 4:
                    MedicineDelivery pengiriman = new MedicineDelivery("DELIV001", pasien.getAddress(), "Dalam Perjalanan");
                    System.out.println("Status: " + pengiriman.getDeliveryStatus());
                    break;
                case 5:
                    Notification notif = new Notification("NTF01", "Obat Anda sedang dikirim", "info", LocalDate.now());
                    notif.sendNotification();
                    break;
                case 6:
                    News berita = new News("NEWS01", "Tips Sehat", "Minum air putih", LocalDate.now());
                    System.out.println("Berita: " + berita.getTitle() + " - " + berita.getContent());
                    break;
                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
