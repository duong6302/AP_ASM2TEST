import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InternManagement implements Management {
    private ArrayList<Intern> internList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void view() {
        if (internList.isEmpty()) {
            System.out.println("No interns found!");
            return;
        }

        for (Intern intern : internList) {
            System.out.println("Intern ID             : " + intern.getId());
            System.out.println("Intern Email          : " + intern.getEmail());
            System.out.println("Intern Name           : " + intern.getName());
            System.out.println("Intern Period         : " + intern.getPeriod());
            System.out.println("Intern End Date       : " + intern.getEndOfContract());
            System.out.println("Intern Availability   : " + intern.getStatus());
            System.out.println();
        }
    }

    @Override
    public void search() {
        if (internList.isEmpty()) {
            System.out.println("No interns found!");
            return;
        }

        System.out.print("Enter Intern ID: ");
        String internId = sc.next();
        for (Intern intern : internList) {
            if (intern.getId().equalsIgnoreCase(internId)) {
                System.out.println(intern.toString());
                return;
            }
        }

        System.out.println("Intern doesn't exist");
    }

    @Override
    public void add() {
        try {
            System.out.println("Add New Intern:");
            String temp = inputString("ID");
            for (int i = 0; i < internList.size(); i++) {
                if (internList.get(i).getId().equals(temp)) {
                    System.out.println("ID already used!");
                    System.out.println("-----------------------------------------------");
                    return;
                }
            }
            try {
                Intern tempintern = new Intern();
                tempintern.setId(temp);
                tempintern.setName(inputString("Name"));
                tempintern.setEmail(inputString("Email"));
                tempintern.setStatus(inputString("Status"));
                tempintern.setEndOfContract(inputDate("EndDate"));
                internList.add(tempintern);
            } catch (NumberFormatException e) {
                System.out.println("Check your input");
            }
        } catch (Exception e) {
            System.out.println("Please enter the field!");
        }
    }

    @Override
    public void edit() {
        if (internList.isEmpty()) {
            System.out.println("No interns found!");
            return;
        }

        System.out.println("Enter Intern ID: ");
        String internId = sc.next();
        for (Intern intern : internList) {
            if (intern.getId().equalsIgnoreCase(internId)) {
                System.out.println("Edit " + intern.getName() + " information");
                try {
                    intern.setName(inputString("Name"));
                    intern.setEmail(inputString("Email"));
                    intern.setStatus(inputString("Status"));
                    intern.setEndOfContract(inputDate("EndDate"));
                    System.out.println("Edit Successfully");
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("please enter correct input!");
                    return;
                }
            }
        }

        System.out.println("Intern doesn't exist");
    }

    @Override
    public void delete() {
        if (internList.isEmpty()) {
            System.out.println("No interns found!");
            return;
        }

        System.out.print("Enter Intern ID: ");
        String internId = sc.next();
        for (Intern intern : internList) {
            if (intern.getId().equalsIgnoreCase(internId)) {
                internList.remove(intern);
                System.out.println("Intern Deleted");
                return;
            }
        }

        System.out.println("Intern doesn't exist");
    }

    private String inputString(String temp) {
        System.out.print("Enter " + temp + ": ");
        return sc.next();
    }

    private LocalDate inputDate(String temp) {
        String date = "";
        while (true) {
            System.out.print("Enter " + temp + " (yyyy-mm-dd): ");
            date = sc.next().trim();
            try {
                LocalDate parsedDate = LocalDate.parse(date);
                return parsedDate;
            } catch (Exception e) {
                System.out.println("Please enter correct date");
            }
        }
    }
}
