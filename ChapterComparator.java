
import java.util.*;

class Employee {
    String name;
    String department;
    double salary;
    int age;

    Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public String getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return name + " | " + department + " | $" + salary + " | Age: " + age;
    }
}

public class ChapterComparator {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Engineering", 75000, 30),
                new Employee("Bob", "Marketing", 60000, 28),
                new Employee("Charlie", "Engineering", 75000, 27),
                new Employee("David", "Engineering", 90000, 35),
                new Employee("Eve", "Marketing", 60000, 25),
                new Employee("Frank", "Engineering", 75000, 29));

        // Custom Comparator using compare()
        Comparator<Employee> employeeComparator = (Employee e1, Employee e2) -> {
            // 1️⃣ Sort by Department (Alphabetically)
            int departmentComparison = e1.department.compareTo(e2.department);
            if (departmentComparison != 0) {
                return departmentComparison;
            }

            // 2️⃣ If same department, sort by Salary (Descending)
            int salaryComparison = Double.compare(e2.salary, e1.salary); // Higher salary first
            if (salaryComparison != 0) {
                return salaryComparison;
            }

            // 3️⃣ If same salary, sort by Age (Ascending)
            return Integer.compare(e1.age, e2.age); // Younger first
        };

        // Sorting employees using custom comparator
        employees.sort(employeeComparator);

        // Alternative code to sort the following with the same conditions
        employees.sort(Comparator.comparing(Employee::getDepartment)
                .thenComparing(Employee::getSalary, Comparator.reverseOrder()).thenComparing(Employee::getAge));

        // Printing sorted list
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}