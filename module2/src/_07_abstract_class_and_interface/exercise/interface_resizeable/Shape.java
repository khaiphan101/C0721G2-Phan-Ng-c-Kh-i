package _07_abstract_class_and_interface.exercise.interface_resizeable;

public abstract class Shape implements Resizeable{
    private String color = "green";
    private Boolean filled = true;

    public Shape() {
    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String isFilled() {
        return (filled) ? "filled" : "not filled";
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with " +
                "color of " + color + " and " + this.isFilled();
    }

    public abstract void resize(double percent);
}
