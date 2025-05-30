package model;
import java.time.LocalDate;


public class Notification {
	private String id;
    private String content;
    private String type;
    private LocalDate date;

    public Notification(String id, String content, String type, LocalDate date) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.date = date;
    }

    public void sendNotification() {
        System.out.println("Notifikasi [" + type + "]: " + content + " (" + date + ")");
    }
}
