package Array;
import java.util.Scanner;

public class dummy {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter name, age and salary:");

    // String input
    String name = sc.next();

    // Numerical input
    int age = sc.nextInt();
    double salary = sc.nextDouble();

    // Output input by user
    System.out.println("Name: " + name); 
    System.out.println("Age: " + age); 
    System.out.println("Salary: " + salary); 
    sc.close();
  }
}
