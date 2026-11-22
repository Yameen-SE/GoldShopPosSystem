import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Customer[] C = new Customer[15];
        int U = -1;
        int customerID = 0;

        while (true) {

            try {

                System.out.println("===== GOLD SHOP POS SYSTEM =====");
                System.out.println("1. Add Customer");
                System.out.println("2. Display Customers");

                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();


          
