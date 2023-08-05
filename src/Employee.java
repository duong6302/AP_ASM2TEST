class Employee extends Person {
    private double salary;

    public Employee() {
    }

    public Employee(String name, String id, String email, String status, double salary) {
        super(name, id, email, status);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", payment='" + getSalary() + "'";
    }
}

