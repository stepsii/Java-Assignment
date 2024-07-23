import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sales performance percentage: ");
        double salesPerformance = scanner.nextDouble();

        // Check if the sales performance percentage is 100% or more
        if (salesPerformance >= 100) {
            String fileName = "employee.csv";
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                // Print the header for the output table
                System.out.printf("%-10s %-20s %-10s%n", "Employee ID", "Employee Name", "Bonus");
                br.readLine(); // Skip the header line in the CSV file
                while ((line = br.readLine()) != null) {
                    // Split each line of the file into employee details using a comma as the
                    // delimiter
                    String[] employeeDetails = line.split(",");
                    String employeeID = employeeDetails[0].trim();
                    String employeeName = employeeDetails[1].trim();
                    double employeeSalary = Double.parseDouble(employeeDetails[2].trim());

                    // Calculate the bonus using the formula: bonus = salary * (sales performance percentage / 200)
                    double bonus = employeeSalary * (salesPerformance / 200);
                    System.out.printf("%-10s %-20s $%.2f%n", employeeID, employeeName, bonus);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("No bonus for performance below 100%");
        }

        scanner.close();
    }
}
