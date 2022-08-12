package person_management.model;

public class Teacher extends Person{
    private String best;

    public Teacher() {
    }

    public Teacher(int id, String name, String dateOfBirth, String gender, String best) {
        super(id, name, dateOfBirth, gender);
        this.best = best;
    }

    public String getBest() {
        return best;
    }

    public void setBest(String best) {
        this.best = best;
    }

    @Override
    public String toString() {
        return String.format("|%6d|%-15s|%-10s|%-6s|%-7s|",
                this.getId(), this.getName(), this.getDateOfBirth(), this.getGender(),best);
    }
}
