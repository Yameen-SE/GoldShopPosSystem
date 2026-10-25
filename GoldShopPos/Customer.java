public class Customer {
    private int customerId;
    private String customerName;
    private String phone;
    private String address;

    public Customer(String customerName, String phone, String address) {
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

    public Customer(int customerId, String customerName, String phone, String address) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
