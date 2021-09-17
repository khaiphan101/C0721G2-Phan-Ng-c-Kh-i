package _11_java_collection_framework.demo_comparable_comparator;

import java.util.Comparator;

public class StudentSortGrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getGrade() - o2.getGrade());
    }
}
