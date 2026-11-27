public class Sales {

    int SaleID;
    int CustomerID;
    int ItemID;
    String SaleDate;
    int Quantity;
    double Weight;
    String GoldPurity;
    double GoldRateUsed;
    double TotalAmount;
    String PaymentStatus;

      public Sales(int SaleID, int CustomerID, int ItemID, String SaleDate,
                 int Quantity, double Weight, String GoldPurity,
                double GoldRateUsed, double TotalAmount, String PaymentStatus) {

        this.SaleID = SaleID;
        this.CustomerID = CustomerID;
        this.ItemID = ItemID;
        this.SaleDate = SaleDate;
        this.Quantity = Quantity;
        this.Weight = Weight;
        this.GoldPurity = GoldPurity;
        this.GoldRateUsed = GoldRateUsed;
        this.TotalAmount = TotalAmount;
        this.PaymentStatus = PaymentStatus;
    }
    
}
