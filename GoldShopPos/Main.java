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

            if (choice == 1) {
                addCustomer();
            }
            else if (choice == 2) {
                viewCustomer();
            }
            else if (choice == 3) {
                searchCustomerById();
            }
            else if (choice == 4) {
                searchCustomerByName();
            }
            else if (choice == 5) {
                updateCustomer();
            }
            else if (choice == 6) {
                deleteCustomer();
            }
            else if (choice == 7) {
                addCategory();
            }
            else if (choice == 8) {
                viewCategories();
            }
            else if (choice == 9) {
                searchCategory();
            }
            else if (choice == 10) {
                updateCategory();
            }
            else if (choice == 11) {
                deleteCategory();
            }
            else if (choice == 0) {
                System.out.println("Goodbye!");
                sc.close();
                return;
            }
            else {
                System.out.println("Invalid choice. Enter 0-11.");
            }
        }
    }

    

    static void addCustomer() {

        try {

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            boolean valid = true;

            for (int i = 0; i < phone.length(); i++) {
                if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
                    valid = false;
                    break;
                }
            }

            if (valid == false || phone.length() == 0) {
                System.out.println("Enter a valid phone number.");
                return;
            }

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            empty = true;

            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Address cannot be empty.");
                return;
            }

            Customer customer = new Customer(name, phone, address);

            int id = customerDAO.addCustomer(customer);

            if (id > 0) {
                System.out.println("Customer saved! ID: " + id);
            }
            else {
                System.out.println("Customer could not be saved.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void viewCustomer() {

        try {
            List<Customer> list = customerDAO.getAllCustomers();
            printCustomers(list);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void searchCustomerById() {

        try {

            System.out.print("Enter Customer ID to search: ");
            int id = readInt();

            if (id <= 0) {
                System.out.println("Invalid Customer ID.");
                return;
            }

            Customer found = customerDAO.searchById(id);

            if (found == null) {
                System.out.println("Customer not found.");
            }
            else {
                System.out.println("Customer ID: " + found.getCustomerId());
                System.out.println("Name: " + found.getCustomerName());
                System.out.println("Phone: " + found.getPhone());
                System.out.println("Address: " + found.getAddress());
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void searchCustomerByName() {

        try {

            System.out.print("Enter Customer Name to search: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Name cannot be empty.");
                return;
            }

            List<Customer> list = customerDAO.searchByName(name);

            printCustomers(list);

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void updateCustomer() {

        try {

            System.out.print("Enter Customer ID to update: ");
            int id = readInt();

            if (id <= 0) {
                System.out.println("Invalid Customer ID.");
                return;
            }

            System.out.print("Enter new Name: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Name cannot be empty.");
                return;
            }

            System.out.print("Enter new Phone: ");
            String phone = sc.nextLine();

            boolean valid = true;

            for (int i = 0; i < phone.length(); i++) {
                if (phone.charAt(i) < '0' || phone.charAt(i) > '9') {
                    valid = false;
                    break;
                }
            }

            if (valid == false || phone.length() == 0) {
                System.out.println("Enter a valid phone number.");
                return;
            }

            System.out.print("Enter new Address: ");
            String address = sc.nextLine();

            empty = true;

            for (int i = 0; i < address.length(); i++) {
                if (address.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Address cannot be empty.");
                return;
            }

            Customer customer = new Customer(id, name, phone, address);

            boolean result = customerDAO.updateCustomer(customer);

            if (result == true) {
                System.out.println("Customer updated.");
            }
            else {
                System.out.println("Update failed.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void deleteCustomer() {

        try {

            System.out.print("Enter Customer ID to delete: ");
            int id = readInt();

            if (id <= 0) {
                System.out.println("Invalid Customer ID.");
                return;
            }

            boolean result = customerDAO.deleteCustomer(id);

            if (result == true) {
                System.out.println("Customer deleted.");
            }
            else {
                System.out.println("Delete failed.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void printCustomers(List<Customer> list) {

        if (list == null) {
            System.out.println("Unable to retrieve customers.");
            return;
        }

        int count = 0;

        for (Customer c : list) {
            count++;
        }

        if (count == 0) {
            System.out.println("No customers found.");
        }
        else {

            System.out.println("\nID\tName\t\tPhone\t\tAddress");
            System.out.println("-----------------------------------------------");

            for (Customer c : list) {
                System.out.println(c.getCustomerId() + "\t"
                        + c.getCustomerName() + "\t\t"
                        + c.getPhone() + "\t"
                        + c.getAddress());
            }
        }
    }


    // CATEGORY FUNCTIONS

    static void addCategory() {

        try {

            System.out.print("Enter Category Name: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Category name cannot be empty.");
                return;
            }

            Category found = categoryDAO.searchByName(name);

            if (found != null) {
                System.out.println("This category already exists.");
                return;
            }

            int id = categoryDAO.addCategory(new Category(name));

            if (id > 0) {
                System.out.println("Category saved! ID: " + id);
            }
            else {
                System.out.println("Category could not be saved.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void viewCategories() {

        try {
            List<Category> list = categoryDAO.getAllCategories();
            printCategories(list);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void searchCategory() {

        try {

            System.out.print("Enter Category Name to search: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Category name cannot be empty.");
                return;
            }

            Category found = categoryDAO.searchByName(name);

            if (found == null) {
                System.out.println("Category not found.");
            }
            else {
                System.out.println("Category ID: " + found.getCategoryId());
                System.out.println("Category Name: " + found.getCategoryName());
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void updateCategory() {

        try {

            System.out.print("Enter Category ID to update: ");
            int id = readInt();

            if (id <= 0) {
                System.out.println("Invalid Category ID.");
                return;
            }

            System.out.print("Enter new Category Name: ");
            String name = sc.nextLine();

            boolean empty = true;

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != ' ') {
                    empty = false;
                    break;
                }
            }

            if (empty == true) {
                System.out.println("Category name cannot be empty.");
                return;
            }

            Category category = new Category(id, name);

            boolean result = categoryDAO.updateCategory(category);

            if (result == true) {
                System.out.println("Category updated.");
            }
            else {
                System.out.println("Update failed.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void deleteCategory() {

        try {

            System.out.print("Enter Category ID to delete: ");
            int id = readInt();

            if (id <= 0) {
                System.out.println("Invalid Category ID.");
                return;
            }

            boolean result = categoryDAO.deleteCategory(id);

            if (result == true) {
                System.out.println("Category deleted.");
            }
            else {
                System.out.println("Delete failed.");
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    static void printCategories(List<Category> list) {

        if (list == null) {
            System.out.println("Unable to retrieve categories.");
            return;
        }

        int count = 0;

        for (Category c : list) {
            count++;
        }

        if (count == 0) {
            System.out.println("No categories found.");
        }
        else {

            System.out.println("\nID\tCategory Name");
            System.out.println("-------------------------");

            for (Category c : list) {
                System.out.println(c.getCategoryId() + "\t"
                        + c.getCategoryName());
            }
        }
    }


    static int readInt() {

        try {

            int number = Integer.parseInt(sc.nextLine());

            return number;

        }
        catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }

}
