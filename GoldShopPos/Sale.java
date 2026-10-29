import java.util.Date;

public class Sale {

    private int saleId;
    private int customerId;
    private int itemId;
    private Date saleDate;
    private int quantity;
    private double weight;
    private String goldPurity;
    private double goldRateUsed;
    private double totalAmount;
    private String paymentStatus;

    public Sale() {
    }

    public Sale(int saleId, int customerId, int itemId, Date saleDate, int quantity,
                double weight, String goldPurity, double goldRateUsed,
                double totalAmount, String paymentStatus) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.itemId = itemId;
        this.saleDate = saleDate;
        this.quantity = quantity;
        this.weight = weight;
        this.goldPurity = goldPurity;
        this.goldRateUsed = goldRateUsed;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

}
