public class ManagementFactory {
    public static Management createManagement(String type) {
        if ("Employee".equalsIgnoreCase(type)) {
            return new EmployeeManagement();
        } else if ("Intern".equalsIgnoreCase(type)) {
            return new InternManagement();
        } else {
            throw new IllegalArgumentException("Invalid management type: " + type);
        }
    }
}
