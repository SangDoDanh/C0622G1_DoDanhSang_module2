package transport_management.model;

public abstract class Transport {
    private String licensePlates;
    private String manufacture;
    private String yearOfManufacture;
    private String owner;

    public Transport() {
    }

    public Transport(String licensePlates, String manufacture, String yearOfManufacture, String owner) {
        this.licensePlates = licensePlates;
        this.manufacture = manufacture;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-10s|%-4s|%-20s|"
                ,this.getLicensePlates()
                , this.manufacture
                , this.yearOfManufacture
                , this.owner);
    }
}
