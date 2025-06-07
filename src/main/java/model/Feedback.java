package model;

public class Feedback {
    private String feedbackId;
    private String patientName;
    private String doctorName;
    private int rating;
    private String comment;

    public Feedback(String feedbackId, String patientName, String doctorName, int rating, String comment) {
        this.feedbackId = feedbackId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void submitFeedback() {
        System.out.println("\n--- Feedback ---");
        System.out.println("ID: " + feedbackId);
        System.out.println("Pasien: " + patientName);
        System.out.println("Dokter: " + doctorName);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Komentar: " + comment);
    }
}

