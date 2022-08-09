package ss7_abstract_interface.exercise.colorable.model;

public class Square extends Rectangle implements Colorable {
    private double edge;

    public Square(){
    }

    public Square(double edge) {
        super(edge, edge);
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public String toString() {
        return String.format("Circle edge: %.2f area: %.2f", this.getEdge(), this.getArea());
    }

    @Override
    public void howToColor() {
        System.out.println(" Color all four sides...");
    }

}
