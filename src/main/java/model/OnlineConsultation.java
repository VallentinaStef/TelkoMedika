package model;
import java.time.LocalDate;

public class OnlineConsultation {
	private String doctorName;
    private String notes;
    private LocalDate consultationTime;

    public OnlineConsultation(String doctorName, String notes, LocalDate time) {
        this.doctorName = doctorName;
        this.notes = notes;
        this.consultationTime = time;
    }

    public void startConsultation() {
        System.out.println("Konsultasi dimulai dengan " + doctorName);
    }

    public void endConsultation() {
        System.out.println("Konsultasi selesai. Catatan: " + notes);
    }
    
    public void TheetConsultation() {
    	System.out.println("[Dokter Gigi] Selamat pagi, ada keluhan apa?");
    	System.out.println("[Pasien] Gusi saya bengkak dan terasa sakit saat makan.");
    	System.out.println("[Dokter Gigi] Sudah berapa lama dirasakan?");
    	System.out.println("[Pasien] Sekitar tiga hari.");
    	System.out.println("[Dokter Gigi] Kemungkinan ada infeksi. Saya akan resepkan obat gigi dan antibiotik ringan.");
    	System.out.println("[Pasien] Terima kasih, Dok.");
    	System.out.println("[Dokter Gigi] Sama-sama. Jaga kebersihan mulut dan hindari makanan keras dulu.");
    	System.out.println("--- Chat selesai ---\n");
    }
    
    public void GeneralConsultation() {
    	System.out.println("Pasien: Dok, saya merasa demam dan pusing sejak kemarin.");
    	System.out.println("Dokter " + doctorName + ": Apakah disertai batuk atau nyeri tenggorokan?");
    	System.out.println("Pasien: Iya dok, saya juga agak susah tidur.");
    	System.out.println("Dokter " + doctorName + ": Baik, saya akan resepkan Paracetamol dan sarankan istirahat cukup.");
    	System.out.println("--- Chat selesai ---\n");
    }
}
