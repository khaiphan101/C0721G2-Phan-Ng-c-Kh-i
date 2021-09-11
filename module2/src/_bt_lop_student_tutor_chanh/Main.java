package _bt_lop_student_tutor_chanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerStudent managerStudent = new ManagerStudent();
        managerStudent.studentList[0] = new Student(123,"khai", 24, "ldh");
        managerStudent.studentList[1] = new Student(124,"minh", 23, "abc");
        managerStudent.studentList[2] = new Student(125,"thinh", 25, "nbk");
        managerStudent.studentList[3] = new Student(126,"long", 30, "sdc");
        managerStudent.studentList[4] = new Student(127,"dat", 20, "lhh");
        while(true) {
            System.out.println("Optione\n" +
                    "1. Add\n" +
                    "2. Show\n" +
                    "3. Delete\n" +
                    "4. Edit\n" +
                    "5. Search\n" +
                    "0. Exit\n");
            System.out.print("Your choice:");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    managerStudent.add();
                    break;
                case 2:
                    managerStudent.showList();
                    break;
                case 3:
                    //delete
                    System.out.print("Enter student's ID to delete");
                    managerStudent.deleteID(sc.nextInt());
                    break;
                case 4:
                    //edit
                    System.out.print("Enter student's ID to edit");
                    managerStudent.editID(sc.nextInt());
                    break;
                case 5:
                    //search
                    boolean searchedCheck= false;
                    do {
                        System.out.print("Enter information of student to search:");
                        searchedCheck = managerStudent.search(sc.nextLine());
                    }while(searchedCheck);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
            }
        }
    }
}
