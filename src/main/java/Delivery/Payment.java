package Delivery;

import java.time.LocalDate;

import model.Reservation;

public class Payment {
	private double medicineCost;
    private double deliveryFee;
    private boolean isPaid;

    public Payment(double medicineCost, double deliveryFee) {
        this.medicineCost = medicineCost;
        this.deliveryFee = deliveryFee;
        this.isPaid = false;
    }

    public double getTotalPayment() {
        return medicineCost + deliveryFee;
    }

    public void pay() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("✅ Pembayaran berhasil! Total: Rp" + getTotalPayment());
        } else {
            System.out.println("⚠️ Sudah dibayar sebelumnya.");
        }
    }
    


    public boolean isPaid() {
        return isPaid;
    }
}
