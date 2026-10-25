import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Gold Shop Management System ===");
        System.out.println("=== Add New Customer ===");

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        Customer customer = new Customer(name, phone, address);

        CustomerDAO dao = new CustomerDAO();

        int id = dao.addCustomer(customer);

        if (id > 0) {
            System.out.println("\nCustomer saved successfully! Customer ID: " + id);
        } else {
            System.out.println("\nCustomer could not be saved.");
        }

        sc.close();
    }
}
