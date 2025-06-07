package controller;
import java.util.List;
import java.util.Scanner;
import model.News;

public class NewsManager {
	public Scanner scanner = new Scanner(System.in);
	
	public void viewNews(List<News> newsList) {
	    if (newsList.isEmpty()) {
	        System.out.println("Belum ada berita yang tersedia.");
	        return;
	    }

	    System.out.println("=== Daftar Berita ===");
	    for (int i = 0; i < newsList.size(); i++) {
	        System.out.println((i + 1) + ". " + newsList.get(i).getTitle());
	    }

	    try {
	        System.out.print("Pilih nomor berita yang ingin dibaca: ");
	        int pilihan = Integer.parseInt(scanner.nextLine());

	        if (pilihan >= 1 && pilihan <= newsList.size()) {
	            News selectedNews = newsList.get(pilihan - 1);
	            selectedNews.viewNews();
	        } else {
	            System.out.println("❌ Pilihan tidak valid.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("❌ Input harus berupa angka.");
	    }

	}

}
