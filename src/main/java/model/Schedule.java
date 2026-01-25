package model;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
	private Map<String, String> operationalHours;

    public Schedule() {
        operationalHours = new HashMap<>();
        operationalHours.put("Senin", "07:00 - 19:00");
        operationalHours.put("Selasa", "07:00 - 19:00");
        operationalHours.put("Rabu", "07:00 - 19:00");
        operationalHours.put("Kamis", "07:00 - 19:00");
        operationalHours.put("Jumat", "07:00 - 19:00");
        operationalHours.put("Sabtu", "08:00 - 14:00");
        operationalHours.put("Minggu", "08:00 - 14:00");
    }

    public void displaySchedule() {
        System.out.println("=== Jadwal Operasional ===");
        for (String hari : operationalHours.keySet()) {
            System.out.println(hari + ": " + operationalHours.get(hari));
        }
    }

    public String getOperationalHour(String day) {
        return operationalHours.getOrDefault(day, "Tidak tersedia");
    }
}
