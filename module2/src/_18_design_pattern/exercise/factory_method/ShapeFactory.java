package _18_design_pattern.exercise.factory_method;

public class ShapeFactory {
    public Shape getShape(String type){
        if(type.equalsIgnoreCase("Circle")){
            return new Circle();
        }
        else if(type.equalsIgnoreCase("Square")){
            return new Square();
        }
        else {
            return new Rectangle();
        }

    }
}
