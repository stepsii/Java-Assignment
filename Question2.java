import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            //Prompt for purchase price of property
            System.out.print("Enter the purchase price of the property (enter 0 to quit): ");
            double purchasePrice = scanner.nextDouble();

            if (purchasePrice == 0) {
                break;
            }
            //Prompt for property type
            System.out.print("Enter the property type (residential/non-residential): ");
            String propertyType = scanner.next().toLowerCase();

            double bsd = calculateBSD(purchasePrice, propertyType);
            if (bsd != -1) {
                System.out.printf("The Buyer's Stamp Duty is: $%.2f%n", bsd);
            } else {
                System.out.println("Invalid property type entered.");
            }
        }

        scanner.close();
    }

    // Method to calculate the Buyer's Stamp Duty (BSD) based on the price and type
    // of the property
    public static double calculateBSD(double price, String type) {
        double rate;

        if (price <= 0) {
            return 0;
        }

        if (type.equals("residential")) {
            if (price < 180000) {
                rate = 0.01; // 1% for residential properties less than $180,000
            } else if (price <= 600000) {
                rate = 0.02; // 2% for residential properties between $180,000 and $600,000
            } else {
                rate = 0.03; // 3% for residential properties above $600,000
            }
        } else if (type.equals("non-residential")) {
            if (price < 180000) {
                rate = 0.015; // 1.5% for non-residential properties less than $180,000
            } else if (price <= 600000) {
                rate = 0.025; // 2.5% for non-residential properties between $180,000 and $600,000
            } else {
                rate = 0.035; // 3.5% for non-residential properties above $600,000
            }
        } else {
            return -1; // Return -1 for invalid property type
        }

        return price * rate;
    }
}
