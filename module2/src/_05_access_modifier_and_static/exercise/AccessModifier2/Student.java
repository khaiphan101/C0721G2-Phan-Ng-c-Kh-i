package _05_access_modifier_and_static.exercise.AccessModifier2;

public class Student {
    public String name = "John";
    private String className = "C02";
    Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
