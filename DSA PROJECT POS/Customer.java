public class Customer {

    int CustomerID;
    String CustomerName;
    String Phone;
    String Address;

    public Customer(int CustomerID, String CustomerName, String Phone, String Address) {

        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Phone = Phone;
        this.Address = Address;
    }

    public void displayCustomer() {

        System.out.println("Customer ID: " + CustomerID);
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Phone: " + Phone);
        System.out.println("Address: " + Address);
    }
}
