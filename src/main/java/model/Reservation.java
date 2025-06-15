package model;
import java.time.LocalDate;

public class Reservation {
	 	private String doctorName;
	    private LocalDate appointmentDate;
	    private String tipeKonsultasi;
	    private String keluhan;
	    private String status;

	    public Reservation(String doctorName, LocalDate date,String keluhan, String status, String tipeKonsultasi) {
	        this.doctorName = doctorName;
	        this.appointmentDate = date;
	        this.keluhan = keluhan;
	        this.status = status;
	        this.tipeKonsultasi = tipeKonsultasi;
	    }
	    
	    public String getTipeKonsultasi() {
	        return tipeKonsultasi;
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

		public void setAppointmentDate(LocalDate appointmentDate) {
			this.appointmentDate = appointmentDate;
		}
	    
	    

}
