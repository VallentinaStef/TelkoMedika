package model;

import java.time.LocalDate;

public interface Reservable {
	Reservation createReservation(String doctorName, LocalDate date, String keluhan, String status);
}
