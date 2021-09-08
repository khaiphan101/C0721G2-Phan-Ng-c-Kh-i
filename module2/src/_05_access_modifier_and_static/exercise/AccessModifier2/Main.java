package _05_access_modifier_and_static.exercise.AccessModifier2;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(student1.toString());
        student1.setName("Khai");
        System.out.println(student1.toString());
        student1.setClassName("C07");
        System.out.println(student1.toString());
        student1.name = "Khoa";
        System.out.println(student1.toString());

    }
}
