import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SalaryGenerator {
    public static void main(String[] args) {
        // Define the ranges for salary for each rank
        int[][] salaryRanges = {{50000, 80000}, {60000, 110000}, {75000, 130000}};
        String[] ranks = {"assistant", "associate", "full"};
        Random rand = new Random();
        try {
            // Open the file in write mode
            FileWriter writer = new FileWriter("Salary.txt");
            // Write 100 lines of data
            for (int i = 0; i < 100; i++) {
                // Generate the first name, last name, rank, and salary
                String firstName = "FirstName";
                String lastName = "LastName";
                String rank = ranks[rand.nextInt(3)];
                int salary = rand.nextInt(salaryRanges[rankIndex(rank)][1] - salaryRanges[rankIndex(rank)][0] + 1)
                        + salaryRanges[rankIndex(rank)][0];
                // Write the data to the file
                writer.write(firstName + " " + lastName + " " + rank + " " + salary + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Returns the index of the rank in the ranks array
    public static int rankIndex(String rank) {
        String[] ranks = {"assistant", "associate", "full"};
        for (int i = 0; i < ranks.length; i++) {
            if (rank.equals(ranks[i])) {
                return i;
            }
        }
        return -1;
    }
}

