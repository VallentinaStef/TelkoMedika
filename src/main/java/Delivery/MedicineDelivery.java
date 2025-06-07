package Delivery;

public class MedicineDelivery {
    private String address;
    private String deliveryStatus;
    private Payment payment;

    public MedicineDelivery( String address, String status) {
        this.address = address;
        this.deliveryStatus = status;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }
    
    public void createPayment(double medicineCost, double deliveryFee) {
        this.payment = new Payment(medicineCost, deliveryFee);
    }
    
    public void payDelivery() {
        if (payment != null) {
            payment.pay();
        } else {
            System.out.println("❌ Belum ada pembayaran dibuat.");
        }
    }
}
