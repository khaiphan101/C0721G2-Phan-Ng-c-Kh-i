package _10_stack_queue.exercise.demergeing_with_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        ArrayList<Staff> staffs = new ArrayList<>();
        staffs.add(new Staff("khai", "male", "26/04/1994"));
        staffs.add(new Staff("Trinh", "female", "11/01/1995"));
        staffs.add(new Staff("Khoa", "male", "16/08/1996"));
        staffs.add(new Staff("Dat", "male", "15/15/1997"));
        staffs.add(new Staff("Hanh", "female", "30/12/2001"));
        System.out.println("staffs at the begining:");
        for( int i = 0; i< staffs.size(); i++) {
            System.out.println(i+ ". "+ staffs.get(i).toString());
        }
        Queue<Staff> female = new ArrayDeque();
        Queue<Staff> male = new ArrayDeque();
        for (int i = 0; i < staffs.size(); i++) {
            if(((Staff) staffs.get(i)).getGender().equals("male")){
                male.add(staffs.get(i));
            } else if(((Staff) staffs.get(i)).getGender().equals("female")){
                female.add(staffs.get(i));
            }
        }
        ArrayList<Staff> newStaffs = new ArrayList<>();
        while(!female.isEmpty()){
            newStaffs.add(female.remove());
        }
        while(!male.isEmpty()){
            newStaffs.add(male.remove());
        }
        System.out.println("final staffs after implement:");
        for( int i = 0; i< newStaffs.size(); i++) {
            System.out.println(i+ ". "+ newStaffs.get(i).toString());
        }
    }
}
