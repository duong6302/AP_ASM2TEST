import java.time.LocalDate;
import java.time.Period;

class Intern extends Person {
    private LocalDate EndOfContract;

    public Intern() {
    }

    public Intern(String name, String id, String email, String status, LocalDate endOfContract) {
        super(name, id, email, status);
        EndOfContract = endOfContract;
    }

    public LocalDate getEndOfContract() {
        return EndOfContract;
    }

    public void setEndOfContract(LocalDate endOfContract) {
        EndOfContract = endOfContract;
    }

    public Period getPeriod() {
        LocalDate td = LocalDate.now();
        return Period.between(td, EndOfContract);
    }

    @Override
    public String toString() {
        return super.toString() + ", period='" + getPeriod() + "', EndOfContract='" + getEndOfContract() + "'";
    }
}