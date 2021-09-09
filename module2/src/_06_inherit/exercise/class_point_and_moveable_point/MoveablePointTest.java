package _06_inherit.exercise.class_point_and_moveable_point;

import _06_inherit.exercise.class_point2D_and_class_point3D.Point2D;
import _06_inherit.exercise.class_point2D_and_class_point3D.Point3D;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1.0f, 3.0f, 4.0f, 5.0f);
        System.out.println(moveablePoint);
        System.out.println("move point: ");
        System.out.println(moveablePoint.move());

    }
}
