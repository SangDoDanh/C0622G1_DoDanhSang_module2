package ss4_class_and_object.fan;

public class Fan {
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = 1;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String speedStr;
        if(this.speed == 1) {
            speedStr = "SLOW";
        } else if (this.speed == 2) {
            speedStr = "MEDIUM";
        } else{
            speedStr = "FAST";
        }
        if(on) {
            return String.format("Speed: %s\tColor: %s\tRadius: %f fan is on!",speedStr,this.color, this.radius);
        }
        return String.format("Color: %s\tRadius: %f fan is off!",this.color, this.radius);
    }
}
