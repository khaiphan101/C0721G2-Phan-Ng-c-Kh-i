package _bt_lop_student_tutor_chanh;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class ManagerStudent {
    Student[] studentList = new Student[100];
    Scanner sc = new Scanner(System.in);

    public void add() {

        //code them moi
        System.out.println("Enter ID:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter name:");
        String name = sc.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter address:");
        String address = sc.nextLine();
        Student student = new Student(id, name, age, address);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }

    }

    //st,st,st,null,null
    public void showList() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i].toString());
            } else {
                break;
            }
        }
    }

    public void deleteID(int idStudent) {
        for (int i = 0; i < studentList.length; i++) {
            if (idStudent == studentList[i].id) {
                for (int j = i; j < studentList.length; j++) {
                    if (studentList[j + 1] != null) {
                        studentList[j] = studentList[j + 1];
                    } else {
                        studentList[j] = null;
                        break;
                    }
                }
                break;
            }
        }
        showList();
    }

    public void editID(int idStudent) {
        for (int i = 0; i < studentList.length; i++) {
            if (idStudent == studentList[i].id) {
                boolean checkEdit = true;
                while (checkEdit) {
                    System.out.println(studentList[i].toString());
                    System.out.print("1.ID\n" +
                            "2.Name\n" +
                            "3.Age\n" +
                            "4.Address\n" +
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    switch (Integer.parseInt(sc.nextLine())) {
                        case 1:
                            System.out.print("Enter new ID:");
                            studentList[i].setId(Integer.parseInt(sc.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter new Name:");
                            studentList[i].setName(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Enter new age");
                            studentList[i].setAge(Integer.parseInt(sc.nextLine()));
                            break;
                        case 4:
                            System.out.print("Enter new address");
                            studentList[i].setAddress(sc.nextLine());
                            break;
                        case 0:
                            checkEdit = false;
                            break;
                        default:
                            System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
                    }
                }
                break;
            }
        }
        showList();
    }

    public Boolean search(String infor) {
        for (int i = 0; i < studentList.length; i++) {
            if (infor.equals(String.valueOf(studentList[i].getId()))
                    ||infor.equals(String.valueOf(studentList[i].getAge()))
                    ||infor.equals(studentList[i].getName())
                    ||infor.equals(studentList[i].getAddress())
            ) {
                System.out.println(studentList[i]);
                return true;
            }
        }
        System.out.println("this infor isn't exist");
        return false;
    }
}
