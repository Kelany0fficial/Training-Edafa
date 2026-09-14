
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    Employee employee1 =
            new Employee(1, "Ahmed", 22, 10000);

    Employee employee2 =
            new Employee(2, "Mohamed", 25, 12000);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== EMPLOYEE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Calculate Employee Salary");
            System.out.println("7. Exit");

            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    showEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateEmployee();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    calculateSalary();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addEmployee() {

        System.out.println("\n========== ADD EMPLOYEE ==========");

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, age, salary);

        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    public static void showEmployees() {
        System.out.println("\n========== EMPLOYEES ==========");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println("--------------------");
        }
    }

    public static void searchEmployee() {
        System.out.println("\n========== SEARCH EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                employee.displayInfo();
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public static void updateEmployee() {
        System.out.println("\n========== UPDATE EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                scanner.nextLine();

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();

                System.out.print("Enter new age: ");
                int age = scanner.nextInt();

                System.out.print("Enter new salary: ");
                double salary = scanner.nextDouble();

                employee.setName(name);
                employee.setAge(age);
                employee.setSalary(salary);

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public static void deleteEmployee() {
        System.out.println("\n========== DELETE EMPLOYEE ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                employees.remove(employee);

                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    public static void calculateSalary() {
        System.out.println("\n========== CALCULATE SALARY ==========");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {

            if (employee.getId() == id) {

                System.out.println(
                        "Employee: " + employee.getName()
                );

                System.out.println(
                        "Salary: " + employee.getSalary()
                );

                return;
            }
        }

        System.out.println("Employee not found.");
    }
}