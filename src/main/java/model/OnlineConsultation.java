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
}
