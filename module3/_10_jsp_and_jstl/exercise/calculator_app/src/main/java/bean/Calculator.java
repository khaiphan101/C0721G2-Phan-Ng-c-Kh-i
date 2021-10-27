package bean;

public class Calculator {
    float firstOperand;
    float SecondOperand;

    public Calculator(float firstOperand, float secondOperand) {
        this.firstOperand = firstOperand;
        SecondOperand = secondOperand;
    }

    public String add(){ return firstOperand + "+" + SecondOperand + "=" + (firstOperand + SecondOperand); }
    public String sub(){
        return firstOperand + "-" + SecondOperand + "=" + (firstOperand - SecondOperand);
    }
    public String mul(){
        return firstOperand + "*" + SecondOperand + "=" + (firstOperand * SecondOperand);
    }
    public String div(){
        return firstOperand + "/" + SecondOperand + "=" + (firstOperand / SecondOperand);
    }
}