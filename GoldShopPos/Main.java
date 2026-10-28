import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static CategoryDAO categoryDAO = new CategoryDAO();
    static CustomerDAO customerDAO = new CustomerDAO();

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Gold Shop Management System ===");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer by ID");
            System.out.println("4. Search Customer by Name");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Add Category");
            System.out.println("8. View Categories");
            System.out.println("9. Search Category by Name");
            System.out.println("10. Update Category");
            System.out.println("11. Delete Category");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1: addCustomer();            break;
                case 2: viewCustomer();           break;
                case 3: searchCustomerById();     break;
                case 4: searchCustomerByName();   break;
                case 5: updateCustomer();         break;
                case 6: deleteCustomer();         break;
                case 7: addCategory();            break;
                case 8: viewCategories();         break;
                case 9: searchCategory();         break;
                case 10: updateCategory();        break;
                case 11: deleteCategory();        break;
                case 0:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // CUSTOMER Main here:

    static void addCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        Customer customer = new Customer(name, phone, address);
        int id = customerDAO.addCustomer(customer);

        if (id > 0) {
            System.out.println("Customer saved! ID: " + id);
        } else {
            System.out.println("Customer could not be saved.");
        }
    }

    static void viewCustomer() {
        List<Customer> list = customerDAO.getAllCustomers();

        if (list.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\nID\tName\t\tPhone\t\tAddress");
        System.out.println("------------------------------------------------");
        for (Customer c : list) {
            System.out.println(c.getCustomerId() + "\t"
                    + c.getCustomerName() + "\t\t"
                    + c.getPhone() + "\t"
                    + c.getAddress());
        }
    }

    static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        int id = readInt();

        System.out.print("Enter new Name: ");
        String name = sc.nextLine();
        System.out.print("Enter new Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter new Address: ");
        String address = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        boolean ok = customerDAO.updateCustomer(new Customer(id, name, phone, address));
        if (ok) {
            System.out.println("Customer updated.");
        } else {
            System.out.println("Update failed (ID not found?).");
        }
    }

    static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        int id = readInt();

        boolean ok = customerDAO.deleteCustomer(id);
        if (ok) {
            System.out.println("Customer deleted.");
        } else {
            System.out.println("Delete failed (ID not found or in use).");
        }
    }

    // CATEGORY Main here:

    static void addCategory() {
        System.out.print("Enter Category Name: ");
        String name = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        int id = categoryDAO.addCategory(new Category(name));

        if (id > 0) {
            System.out.println("Category saved! ID: " + id);
        } else {
            System.out.println("Category could not be saved.");
        }
    }

    static void viewCategories() {
        List<Category> list = categoryDAO.getAllCategories();

        if (list.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }

        System.out.println("\nID\tName");
        System.out.println("----------------");
        for (Category c : list) {
            System.out.println(c.getCategoryId() + "\t" + c.getCategoryName());
        }
    }

    static void updateCategory() {
        System.out.print("Enter Category ID to update: ");
        int id = readInt();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        boolean ok = categoryDAO.updateCategory(new Category(id, name));
        if (ok) {
            System.out.println("Category updated.");
        } else {
            System.out.println("Update failed (ID not found?).");
        }
    }

    static void deleteCategory() {
        System.out.print("Enter Category ID to delete: ");
        int id = readInt();

        boolean ok = categoryDAO.deleteCategory(id);
        if (ok) {
            System.out.println("Category deleted.");
        } else {
            System.out.println("Delete failed (ID not found or in use).");
        }
    }
    
    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
