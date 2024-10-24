import java.util.Scanner;
class Bills{
    String itemName;
    int quantity;
    double price;

    /*Constructor to store the details of each item to the respective variables*/
    Bills(String itemName, int quantity, double price){
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    /*function to display the item details*/
    public void display(){
        System.out.printf("%-15s %-10d %-15.2f%n", itemName, quantity, price);
    }
}

public class BillingItems {

    /* To validate the name */
    static String validName() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        boolean isValid = true; // To validate the name string
        while (isValid) {
            System.out.print("Item Name : ");
            name = sc.nextLine();
            isValid = !(name.matches("[a-zA-Z\\s]+") && !name.isEmpty());
            if (isValid) {
                System.out.println("Enter a valid item name");
            }
        }
        return name;
    }

    /* Method to get validated quantity */
    public static int getQuantity() {
        int quantity = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Quantity: ");
            if (sc.hasNextInt()) {
                quantity = sc.nextInt();
                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0. Please re-enter.");
                } else {
                    sc.nextLine();  // Consume the newline character
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter an integer for quantity.");
                sc.next(); // Clear the invalid input
            }
        }
        return quantity; // Return the validated quantity
    }

    /* Method to get validated price*/
    public static double getPrice() {
        double price = 0.0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Price per unit: ");
            if (sc.hasNextDouble()) {
                price = sc.nextDouble();
                if (price <= 0) {
                    System.out.println("Price must be greater than 0. Please re-enter.");
                } else {
                    sc.nextLine();
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a decimal number for price.");
                sc.next(); // Clear the invalid input
            }
        }
        return price; // Return the validated price
    }


    /* main function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no:of items to be billed");
        int itemNumber = sc.nextInt();

        /*Initialising the item data*/
        String itemName;
        int quantity;
        double price;

        Bills[] bill = new Bills[itemNumber]; // Creating the array of objects to store each
                                              // instance of the items

        System.out.println("Enter the details of each item"); //Taking the details of each item
        for (int i = 0; i < itemNumber; i++) {
            System.out.println("\nEnter the " + (i+1) + " item details");
            itemName = validName();

            quantity = getQuantity();

            price = getPrice();

            bill[i] = new Bills(itemName, quantity, price); //Storing the details in the array
        }

        System.out.println("\nBill----");
        System.out.printf("%-15s %-10s %-15s%n", "Name", "Quantity", "Price Per Unit");
        for (Bills b : bill) {
            b.display(); //Displaying each item
        }
    }
}
