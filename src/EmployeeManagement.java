import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagement implements Management {
    private ArrayList<Employee> empList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        try {
            System.out.println("Add New Employee:");
            String temp = inputString("ID");

            for (int i = 0; i < empList.size(); i++) {
                if (empList.get(i).getId().equals(temp)) {
                    System.out.println("ID already used or Employee exists!");
                    System.out.println("-----------------------------------------------");
                    return;
                }
            }

            Employee emptemp = new Employee();
            emptemp.setId(temp);
            emptemp.setName(inputString("Name"));
            emptemp.setEmail(inputString("Email"));
            emptemp.setStatus(inputString("Status"));
            emptemp.setSalary(inputDouble("Salary"));
            empList.add(emptemp);
            System.out.println("Employee Added");

        } catch (Exception e) {
            System.out.println("Please enter the field!");
        }
    }

    @Override
    public void view() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee emp : empList) {
            System.out.println("Employee ID             : " + emp.getId());
            System.out.println("Employee Email          : " + emp.getEmail());
            System.out.println("Employee Name           : " + emp.getName());
            System.out.println("Employee Salary         : " + emp.getSalary());
            System.out.println("Employee Availability   : " + emp.getStatus());
            System.out.println();
        }
    }

    @Override
    public void search() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        String empId = sc.next();
        for (Employee emp : empList) {
            if (emp.getId().equalsIgnoreCase(empId)) {
                System.out.println(emp.toString());
                return;
            }
        }

        System.out.println("Employee doesn't exist");
    }

    @Override
    public void edit() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("Enter Employee ID: ");
        String empId = sc.next();
        for (Employee emp : empList) {
            if (emp.getId().equalsIgnoreCase(empId)) {
                System.out.println("Edit " + emp.getName() + " information");
                try {
                    emp.setName(inputString("Name"));
                    emp.setEmail(inputString("Email"));
                    emp.setStatus(inputString("Status"));
                    emp.setSalary(inputDouble("Salary"));
                    System.out.println("Edit Successfully");
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("please enter correct input!");
                    return;
                }
            }
        }

        System.out.println("Employee doesn't exist");
    }

    @Override
    public void delete() {
        if (empList.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        String empId = sc.next();
        for (Employee emp : empList) {
            if (emp.getId().equalsIgnoreCase(empId)) {
                empList.remove(emp);
                System.out.println("Employee Deleted");
                return;
            }
        }

        System.out.println("Employee doesn't exist");
    }

    private String inputString(String temp) {
        System.out.print("Enter " + temp + ": ");
        return sc.next();
    }

    private double inputDouble(String temp) {
        boolean check = true;
        double temp1 = 0;
        do {
            System.out.print("Enter " + temp + ": ");
            try {
                temp1 = sc.nextDouble();
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("Please enter correct input");
                sc.nextLine();
            }
        } while (check);

        return temp1;
    }
}
