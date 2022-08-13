package transport_management.model;

public class Car extends Transport{
    private int seats;
    private String carStyle;

    public Car() {
    }

    public Car(String licensePlates, String manufacture, String yearOfManufacture, String owner) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
    }

    public Car(String licensePlates, String manufacture, String yearOfManufacture, String owner, int seats, String carStyle) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
        this.seats = seats;
        this.carStyle = carStyle;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCarStyle() {
        return carStyle;
    }

    public void setCarStyle(String carStyle) {
        this.carStyle = carStyle;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-10s|%-10s|%-4s|%-20s|%4d|%-10s|",
                "CAR",
                this.getLicensePlates(),
                this.getManufacture(),
                this.getYearOfManufacture(),
                this.getOwner(),
                seats,
                carStyle);
    }
}
