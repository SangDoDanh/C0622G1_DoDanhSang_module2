package transport_management.model;

public class Truck extends Transport {
    private double tonnage;

    public Truck() {
    }

    public Truck(String licensePlates, String manufacture, String yearOfManufacture, String owner) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
    }

    public Truck(String licensePlates, String manufacture, String yearOfManufacture, String owner, double tonnage) {
        super(licensePlates, manufacture, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-10s|%-10s|%-4s|%-20s|%4.2f|",
                "TRUCK",
                this.getLicensePlates(),
                this.getManufacture(),
                this.getYearOfManufacture(),
                this.getOwner(),
                tonnage);
    }
}
