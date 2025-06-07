package model;

import java.util.ArrayList;
import java.util.Scanner;

public class News {
    private String title;
    private String content;
    private String datePosted;
    ArrayList<News> newsList  = new ArrayList<>();

    public News(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.datePosted = date;
    }
    
    Scanner s = new Scanner(System.in);
    
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

	public String getDatePosted() {
		return datePosted;
	}
	
	public void viewNews() {
        System.out.println("📰 " + title);
        System.out.println("Tanggal: " + datePosted);
        System.out.println("Isi: " + content);
    }
	
	public void newsDetail() {
		System.out.println(title);
		System.out.println(content);
	}
}