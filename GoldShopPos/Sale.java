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

    public int getSaleId() {
         return saleId;
         }
    public void setSaleId(int saleId) { 
        this.saleId = saleId;
         }

    public int getCustomerId() { 
        return customerId;
         }
    public void setCustomerId(int customerId) { 
        this.customerId = customerId;
         }

    public int getItemId() { 
        return itemId;
         }
    public void setItemId(int itemId) { 
        this.itemId = itemId;
         }

    public Date getSaleDate() { 
        return saleDate;
         }
    public void setSaleDate(Date saleDate) {
         this.saleDate = saleDate; 
        }

    public int getQuantity() {
         return quantity;
        }
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
        }

    public double getWeight() { 
        return weight; 
        }
    public void setWeight(double weight) { 
        this.weight = weight;
        }

    public String getGoldPurity() { 
        return goldPurity;
        }
    public void setGoldPurity(String goldPurity) { 
        this.goldPurity = goldPurity;
        }

    public double getGoldRateUsed() { 
        return goldRateUsed;
        }
    public void setGoldRateUsed(double goldRateUsed) { 
        this.goldRateUsed = goldRateUsed;
        }

    public double getTotalAmount() { 
        return totalAmount; 
        }
    public void setTotalAmount(double totalAmount) { 
        this.totalAmount = totalAmount;
        }

    public String getPaymentStatus() { 
        return paymentStatus; 
        }
    public void setPaymentStatus(String paymentStatus) { 
        this.paymentStatus = paymentStatus;
        }
}
