package transport_management.model;

public class Motor extends Transport{
    private int power;

    public Motor() {
    }

    public Motor(String licensePlates, String manufacture, String yearOfManufacture, String owner) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
    }

    public Motor(String licensePlates, String manufacture, String yearOfManufacture, String owner, int power) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-10s|%-10s|%-4s|%-20s|%4d|",
                "MOTOR",
                this.getLicensePlates(),
                this.getManufacture(),
                this.getYearOfManufacture(),
                this.getOwner(),
                power);
    }
}
