package model;
import java.time.LocalDate;

public class News {
	private String newsID;
    private String title;
    private String content;
    private LocalDate datePosted;

    public News(String id, String title, String content, LocalDate date) {
        this.newsID = id;
        this.title = title;
        this.content = content;
        this.datePosted = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
