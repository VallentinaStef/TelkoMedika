package model;

public class MedicineDelivery {
	private String deliveryID;
    private String address;
    private String deliveryStatus;

    public MedicineDelivery(String deliveryID, String address, String status) {
        this.deliveryID = deliveryID;
        this.address = address;
        this.deliveryStatus = status;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }
}
