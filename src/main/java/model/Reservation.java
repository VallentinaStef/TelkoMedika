package model;
import java.time.LocalDate;

public class Reservation {
	 private String doctorName;
	    private String reservationName;
	    private LocalDate appointmentDate;
	    private String keluhan;
	    private String status;

	    public Reservation(String name, String doctorName, LocalDate date,String keluhan, String status) {
	        this.reservationName = name;
	        this.doctorName = doctorName;
	        this.appointmentDate = date;
	        this.keluhan = keluhan;
	        this.status = status;
	    }
	    
	    public String getDoctorName() {
	        return doctorName;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public LocalDate getAppointmentDate() {
	        return appointmentDate;
	    }
	    
	    public String getkeluhan() {
	        return keluhan;
	    }
	    
}
