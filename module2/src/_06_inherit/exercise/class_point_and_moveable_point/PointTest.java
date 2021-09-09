package _06_inherit.exercise.class_point_and_moveable_point;

import _06_inherit.exercise.class_point2D_and_class_point3D.Point2D;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(1.0f, 3.0f);
        System.out.println(point);

    }
}
