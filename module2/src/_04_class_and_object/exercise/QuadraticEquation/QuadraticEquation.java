package _04_class_and_object.exercise.QuadraticEquation;

public class QuadraticEquation {
    //ax2 + bx + c = 0;
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public QuadraticEquation() {

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant(){
        double delta = b*b - 4*a*c;
        return delta;
    }
    public String showRoot(){
        if(getDiscriminant() > 0){
            return "The equation has 2 root:" +

            "\nx1= " + getRoot1() +
            "\nx2= " +getRoot2();
        }
        if(getDiscriminant() == 0){
            return "The equation has 1 root:" +
                    "\nx= " + getRoot1();
        }
        else{
            return "The equation has no roots";
        }
    }
    double getRoot1(){
            return (-b - Math.sqrt(b*b - 4*a*c)) / (2*a);
    }
    double getRoot2(){
            return (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
    }

    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}' + "\n" +
                a+"x^2 + "+ b + "x + " + c + " = 0";
    }
}
