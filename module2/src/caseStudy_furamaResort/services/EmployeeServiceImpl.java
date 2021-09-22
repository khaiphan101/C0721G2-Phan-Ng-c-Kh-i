package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    ArrayList<Employee> employeesList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add() {
//        private int employeeCode;
//        private String name;
//        private String birthday;
//        private String gender;
//        private int idNumber;
//        private int phoneNumber;
//        private String email;
//        private String level;
//        private String position;
//        private int salary;
        //code them moi
        Employee employee = new Employee();

        System.out.println("Enter employee code:");
        employee.setEmployeeCode(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter name:");
        employee.setName(sc.nextLine());

        System.out.println("Enter birthday:");
        employee.setBirthday(sc.nextLine());

        System.out.println("Enter gender:");
        employee.setGender(sc.nextLine());

        System.out.println("Enter id number:");
        employee.setIdNumber(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter phone number:");
        employee.setPhoneNumber(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter email:");
        employee.setEmail(sc.nextLine());

        System.out.println("Enter level:");
        employee.setLevel(sc.nextLine());

        System.out.println("Enter position:");
        employee.setPosition(sc.nextLine());

        System.out.println("Enter salary:");
        employee.setSalary(Integer.parseInt(sc.nextLine()));
        employeesList.add(employee);
    }

    //st,st,st,null,null
    public void showList() {
        System.out.println("employees's list:");
        for (int i = 0; i < employeesList.size(); i++) {
            System.out.println(employeesList.get(i).toString());
        }
    }

//    public void deleteID(int idStudent) {
//        for (int i = 0; i < employeesList.size(); i++) {
//            if (idStudent == employeesList.get(i).getEmployeeCode()) {
//                for (int j = i; j < employeesList.size(); j++) {
//                    if (employeesList.get(j + 1) != null) {
//                        employeesList.get(j) = employeesList.get(j + 1);
//                    } else {
//                        employeesList.get(j) = null;
//                        break;
//                    }
//                }
//                break;
//            }
//        }
//        showList();
//    }
//
//    public void editID(int idStudent) {
//        for (int i = 0; i < employeesList.size(); i++) {
//            if (idStudent == employeesList[i].id) {
//                boolean checkEdit = true;
//                while (checkEdit) {
//                    System.out.println(employeesList[i].toString());
//                    System.out.print("1.ID\n" +
//                            "2.Name\n" +
//                            "3.Age\n" +
//                            "4.Address\n" +
//                            "0.Exit\n" +
//                            "Choose section you want to edit:");
//                    switch (Integer.parseInt(sc.nextLine())) {
//                        case 1:
//                            System.out.print("Enter new ID:");
//                            employeesList[i].setId(Integer.parseInt(sc.nextLine()));
//                            break;
//                        case 2:
//                            System.out.print("Enter new Name:");
//                            employeesList[i].setName(sc.nextLine());
//                            break;
//                        case 3:
//                            System.out.print("Enter new age");
//                            employeesList[i].setAge(Integer.parseInt(sc.nextLine()));
//                            break;
//                        case 4:
//                            System.out.print("Enter new address");
//                            employeesList[i].setAddress(sc.nextLine());
//                            break;
//                        case 0:
//                            checkEdit = false;
//                            break;
//                        default:
//                            System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
//                    }
//                }
//                break;
//            }
//        }
//        showList();
//    }
//
//    public Boolean search(String infor) {
//        for (int i = 0; i < employeesList.size(); i++) {
//            if (infor.equals(String.valueOf(employeesList[i].getId()))
//                    ||infor.equals(String.valueOf(employeesList[i].getAge()))
//                    ||infor.equals(employeesList[i].getName())
//                    ||infor.equals(employeesList[i].getAddress())
//            ) {
//                System.out.println(employeesList[i]);
//                return true;
//            }
//        }
//        System.out.println("this infor isn't exist");
//        return false;
//    }
}
class Main{
    public static void main(String[] args) {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        employeeServiceImpl.add();
        employeeServiceImpl.showList();
    }
}