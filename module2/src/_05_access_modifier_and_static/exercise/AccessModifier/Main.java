package _05_access_modifier_and_static.exercise.AccessModifier;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0d);
        System.out.println("circle1:");
        System.out.println("r1: " + circle1.getRadius());
        System.out.println("Area1: " +circle1.getArea());
        System.out.println("circle2:");
        System.out.println("r2: " + circle2.getRadius());
        System.out.println("Area2: " + circle2.getArea());
    }
}
