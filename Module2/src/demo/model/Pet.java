package demo.model;

public abstract class Pet {
    private String name;
    private double weight;
    private double recoded;
    public Pet() {
    }

    public Pet(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.recoded = 0;
    }

    public double getRecoded() {
        return recoded;
    }

    public void setRecoded(double recoded) {
        this.recoded = recoded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%10.2f|%10.2f|",
                this.getName(), this.getWeight(), this.getRecoded());
    }
}
