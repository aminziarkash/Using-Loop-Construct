import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by aziarkash on 18-1-2016.
 */
public class Application {

    private static final DecimalFormat idFormat = new DecimalFormat("0000");

    private static Quasar quasar = new Quasar();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        basicForLoop();

        enhancedForLoop();

        whileLoop();

        doWhileLoop();
    }

    private static void doWhileLoop() {

        Iterator<Employee> employeeIterator = quasar.iterator();
        int count = 1;

        System.out.println("Press enter to assign ID to these Employees...");

        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        do {
            Employee emp = employeeIterator.next();
            String employeeName = emp.getName();
            int employeeId = emp.getEmployeeId();
            System.out.println("Employee nr. " + count + " name\t:\t" + employeeName);
            System.out.println("Employee ID\t\t\t:\t" + idFormat.format(employeeId) + "\n");
            count++;
        } while (employeeIterator.hasNext());

        addSeparator();
    }

    private static void whileLoop() {

        Iterator<Employee> employeeIterator = quasar.iterator();
        int employeeId = 0;

        while (employeeIterator.hasNext()) {
            employeeId++;
            Employee emp = employeeIterator.next();
            emp.setEmployeeId(employeeId);
        }
    }

    private static void enhancedForLoop() {

        System.out.print("How many employees do you want to add to Quasar?\t:\t");
        int numOfEmployees = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter employee names");
        createEmployees(numOfEmployees);

        System.out.print("\nThe following employees have been added to Quasar\t\t:\t\t");
        printEmployeeNames(numOfEmployees); // Enhanced for loop

        addSeparator();
    }

    private static void printEmployeeNames(int numOfEmployees) {

        // create a string builder and append all the employee names in it
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (Employee empl : quasar) {
            sb.append(empl.getName());
            // make sure not to add (,) after the last employee object
            if (quasar.indexOf(empl) != numOfEmployees - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    private static void createEmployees(int numOfEmployees) {

        // create employee objects
        Employee employee = null;
        String employeeName = null;

        Employee[] employeeArray = new Employee[numOfEmployees];

        for (Employee emp : employeeArray) {
            employee = new Employee();
            employeeName = scanner.nextLine();
            employee.setName(employeeName);
            quasar.add(employee);
        }
    }

    private static void basicForLoop() {

        System.out.print("How many numbers do you want to display from a 6 by 6 array? (only 1-36 supported)\t:\t");

        Scanner userInput = new Scanner(System.in);
        int terminationNumber = userInput.nextInt();
        int k = 0;

        label1:
        for (int i = 0; i < 6; i++) {
            System.out.print(k);
            k++;
            for (int j = 1; j < 6; j++) {
                if (k >= terminationNumber) {
                    System.out.println();
                    break label1;
                }
                System.out.print("\t" + k);
                k++;
            }
            System.out.println();
        }
        addSeparator();
    }

    private static void addSeparator() {
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}