import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight;

        while (true) {
            // Prompt the user to enter the parcel weight
            System.out.print("Enter parcel weight (enter 0 to quit): ");
            weight = scanner.nextDouble(); // Read the weight entered by the user

            // Check if the entered weight is 0
            if (weight == 0) {
                break; // Exit the loop if the weight is 0
            }

            // Calculate the delivery charge based on the weight
            double charge = calculateCharge(weight);
            // Print the calculated delivery charge
            System.out.printf("The delivery charge is: $%.2f%n", charge);
        }

        scanner.close(); // Close the Scanner object
    }

    // Method to calculate the delivery charge based on the weight of the parcel
    public static double calculateCharge(double weight) {
        if (weight < 0 || weight > 30) {
            return 0;
        }
        if (weight <= 3) {
            // Charge $8 if the weight is less than or equal to 3 kg
            return 8.00;
        } else if (weight <= 5) {
            // Charge $12 if the weight is greater than 3 kg and less than or equal to 5 kg
            return 12.00;
        } else {
            // Charge $12 plus $1.50 for each additional kg if the weight is greater than 5kg
            return 12.00 + (weight - 5) * 1.50;
        }
    }
}
