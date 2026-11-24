public class Item {

    int ItemID;
    String ItemName;
    int CategoryID;
    String GoldPurity;
    double Weight;
    double Price;

    public Item(int ItemID, String ItemName, int CategoryID, String GoldPurity, double Weight, double Price) {

        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.CategoryID = CategoryID;
        this.GoldPurity = GoldPurity;
        this.Weight = Weight;
        this.Price = Price;
    }

    public void displayItem() {

        System.out.println("Item ID: " + ItemID);
        System.out.println("Item Name: " + ItemName);
        System.out.println("Category ID: " + CategoryID);
        System.out.println("Gold Purity: " + GoldPurity);
        System.out.println("Weight: " + Weight + " grams");
        System.out.println("Price: " + Price + "RS");
    }
}

