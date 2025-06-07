package Layanan.TelkoMedika;
import java.util.ArrayList;
import java.util.Scanner;

import controller.QueueManager;

import java.time.LocalDate;
import model.*;
import controller.*;


public class Main {
	public static void main(String[] args) {
		
		final int MAX_LOGIN_ATTEMPTS = 3;
		int attempts = 0;
		boolean found = false;
		
        Scanner scanner = new Scanner(System.in);
        Patient pasien = null;
        Schedule schedule = new Schedule();
        ArrayList<Account> userList = new ArrayList<>();
        ArrayList<Patient> patientList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<News> newsList  = new ArrayList<>();
        
        ReservasiManager reservManager = new ReservasiManager();           
        NewsManager newsManager = new NewsManager();
        
        
        
        Patient pasien1 = new Patient("pasien1", "12345", "Tepani", "08123456789", "Bandung");
        Patient pasien2 = new Patient("pasien2", "password123", "Budi", "082233445566", "Jakarta");

        
        userList.add(pasien1);
        userList.add(pasien2);
        
        patientList.add(pasien1);
        patientList.add(pasien2);
        
        
        doctorList.add(new Doctor("Andi", "Umum", "081234111111"));
        doctorList.add(new Doctor("Budi", "Gigi", "081234222222"));
        
        
        News news1 = new News(
        	    "Waspadai Stevens-Jhonson Syndrom, Penyakit Langka yang Bisa Mengancam Nyawa",
        	    "Stevens-Johnson Syndrome (SJS) merupakan kondisi langka namun berbahaya yang menyerang kulit dan selaput lendir.\n"
        	    + "Meski jarang terjadi, penyakit ini tergolong serius karena dapat menyebabkan komplikasi multi-organ dan bahkan kematian bila tidak ditangani dengan cepat dan tepat.\n"
        	    + "SJS biasanya dipicu oleh reaksi terhadap obat-obatan tertentu, infeksi, atau faktor imunologis lainnya.",
        	    "2025-06-03"
        	);

        	News news2 = new News(
        	    "Serangga Bisa Picu Infeksi Kulit Saat Banjir, Ini Tips Pencegahannya",
        	    "Pakar dermatologi dr. R. Aj. Putri Ambarani P., Sp. D.V.E mengingatkan masyarakat untuk waspada terhadap risiko penyakit kulit\n"
        	    + "yang bisa ditimbulkan akibat gigitan serangga saat bencana banjir.\n"
        	    + "Menurut Putri, bencana banjir tidak hanya membawa dampak banjir itu sendiri,\n"
        	    + "tetapi juga memicu munculnya berbagai jenis serangga seperti nyamuk dan lipan yang berisiko menggigit dan menyebabkan masalah kesehatan.",
        	    "2022-04-20"
        	);

        	News news3 = new News(
        	    "Seperti Apa Gatal karena Diabetes? Berikut 4 Ciri-cirinya",
        	    "Kulit gatal bisa jadi gejala diabetes, khususnya jika gejala lainnya juga muncul.\n"
        	    + "Lalu, seperti apa gatal karena diabetes?\n"
        	    + "Gatal karena diabetes umumnya dirasakan di area kaki bagian bawah dan telapak kaki.\n"
        	    + "Selain mencoba mengendalikan kadar gula darah, rasa gatal yang muncul bisa dikurangi dengan mengoleskan pelembap,\n"
        	    + "mandi dengan air hangat, dan minum air putih yang cukup.",
        	    "2024-11-26"
        	);

        	News news4 = new News(
        	    "Makanan Apa yang Bisa Menurunkan Gula Darah dengan Cepat?",
        	    "Mengontrol asupan makanan dan melakukan pola hidup sehat bisa membantu untuk menurunkan kadar gula darah.\n"
        	    + "Lalu, makanan apa yang bisa menurunkan gula darah dengan cepat?\n"
        	    + "Makanan terbaik yang bisa dikonsumsi untuk menurunkan gula darah tinggi adalah karbohidrat kompleks dan makanan dengan nutrisi tertentu,\n"
        	    + "seperti serat, protein, dan lemak sehat.\n"
        	    + "Beberapa jenis makanan yang bisa dipilih, yakni alpukat, gandum utuh, brokoli, makanan fermentasi, kacang-kacangan, dan buah apel.\n"
        	    + "Untuk lebih jelasnya, ketahui beberapa jenis makanan penurun gula darah yang bisa dikonsumsi berikut ini.",
        	    "2024-11-21"
        	);

        	News news5 = new News(
        	    "7 Tips Makan Daging Kurban dengan Aman, Menurut Ahli Gizi",
        	    "Para ahli gizi mengingatkan untuk hati-hati dalam mengonsumsi daging kurban selama Idul Adha.\n"
        	    + "Ahli gizi yang berpraktik di Siloam Hospital Olivia Gresya, S.Gz mengatakan bahwa daging merah, seperti kambing dan sapi,\n"
        	    + "memiliki kandungan yang perlu diwaspadai.\n"
        	    + "“Apalagi, jika konsumsinya dalam jumlah yang tinggi,” kata Olivia kepada Kompas.com pada Senin (2/6/2025).",
        	    "2025-06-03"
        	);

        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        newsList.add(news5);

        System.out.println("=== TELKOM MEDIKA SYSTEM ===");

        
        while (attempts < MAX_LOGIN_ATTEMPTS && !found) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

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
                attempts++;
                if (attempts < MAX_LOGIN_ATTEMPTS) {
                    System.out.println("Login gagal. Coba lagi (" + (MAX_LOGIN_ATTEMPTS - attempts) + " kesempatan tersisa).\n");
                } else {
                    System.out.println("Kesempatan Habis, keluar dari system");
                    System.exit(0);
                }
            }
        }
        
        QueueManager queueManager = new QueueManager(10);

        int pilihan = -1;
        while (pilihan != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Buat Reservasi");
            System.out.println("2. Lihat Riwayat");
            System.out.println("3. Lihat Notifikasi");
            System.out.println("4. Baca Berita");
            System.out.println("5. Lihat Jam Operasional");
            System.out.println("6. Berikan Feedback");
            System.out.println("0. LogOut");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
            case 1: 
            	reservManager.createReservation(pasien, doctorList, queueManager, scanner);
                break;
                case 2:
                	reservManager.showReservationOptions(pasien, scanner);
                    break;
                case 3:
                    pasien.viewNotifications();
                    break;
                case 4:
                	newsManager.viewNews(newsList);
                    break;
                case 5:
                    schedule.displaySchedule();
                    break;
                case 6:
                	System.out.print("Masukkan ID Feedback: ");
                    String feedbackId = scanner.nextLine();

                    System.out.print("Masukkan nama pasien: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Masukkan nama dokter: ");
                    String doctorNamee = scanner.nextLine();

                    int rating = 0;
                    while (true) {
                        System.out.print("Masukkan rating (1-5): ");
                        try {
                            rating = Integer.parseInt(scanner.nextLine());
                            if (rating >= 1 && rating <= 5) break;
                            else System.out.println("Rating harus antara 1-5!");
                        } catch (NumberFormatException e) {
                            System.out.println("Input harus berupa angka!");
                        }
                    }

                    System.out.print("Masukkan komentar: ");
                    String comment = scanner.nextLine();

                    Feedback feedback = new Feedback(feedbackId, patientName, doctorNamee, rating, comment);
                    System.out.println("\nFeedback berhasil disimpan!");
                    feedback.submitFeedback();
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
