package Delivery;

public class Payment {
    final private double deliveryFee = 7000;
    private boolean isPaid = false;
    
    public Payment() {
    }

    public void pay() {
        if (!isPaid) {
            isPaid = true;
            System.out.println("Pembayaran dengan COD, \n Silahkan Siapkan Uang dengan Total Pembayaran: Rp" + getDeliveryFee());
        } else {
            System.out.println("[ERROR] Sudah dibayar sebelumnya.");
        }
    }       


    public double getDeliveryFee() {
		return deliveryFee;
	}

	public boolean isPaid() {
        return isPaid;
    }
}
