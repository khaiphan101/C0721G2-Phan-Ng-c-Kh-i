package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private String EMPLOYEES_FILE = "src/caseStudy_furamaResort/data/list_of_employee";
    ArrayList<Employee> employeesList = this.readFile(EMPLOYEES_FILE);

    Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        //code them moi
        Employee employee = new Employee();

        System.out.println("Enter employee code:");
        employee.setCode(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter name:");
        employee.setName(sc.nextLine());

        System.out.println("Enter birthday:");
        employee.setBirthday(sc.nextLine());

        System.out.println("Enter gender:");
        employee.setGender(sc.nextLine());

        System.out.println("Enter id number:");
        employee.setIdNumber(sc.nextLine());

        System.out.println("Enter phone number:");
        employee.setPhoneNumber(sc.nextLine());

        System.out.println("Enter email:");
        employee.setEmail(sc.nextLine());

        System.out.println("Enter level:");
        employee.setLevel(sc.nextLine());

        System.out.println("Enter position:");
        employee.setPosition(sc.nextLine());

        System.out.println("Enter salary:");
        employee.setSalary(Integer.parseInt(sc.nextLine()));
        this.writeFile(employee, EMPLOYEES_FILE);
        employeesList.add(employee);
    }

    @Override
    public void showList() {
        System.out.println("employees's list:");
//        employeesList = this.readFile(EMPLOYEES_FILE);
        for (Employee employee : employeesList) {
            System.out.println(employee);
        }
    }
    @Override
    public void edit(int employeeCode) {
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeeCode == employeesList.get(i).getCode()) {
                boolean checkEdit = true;
                while (checkEdit) {
                    System.out.println(employeesList.get(i));
                    System.out.print("1.Employee code\n" +
                            "2.Name\n" +
                            "3.Birthday\n" +
                            "4.Gender\n" +
                            "5.ID number\n" +
                            "6.Phone number\n" +
                            "7.Email\n" +
                            "8.Level\n" +
                            "9.Position\n" +
                            "10.Salary\n" +
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    switch (Integer.parseInt(sc.nextLine())) {
                        case 1:
                            System.out.print("Enter new code:");
                            employeesList.get(i).setCode(Integer.parseInt(sc.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter new Name:");
                            employeesList.get(i).setName(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Enter new Birthday");
                            employeesList.get(i).setBirthday(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Enter new Gender");
                            employeesList.get(i).setGender(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Enter new ID");
                            employeesList.get(i).setIdNumber(sc.nextLine());
                            break;
                        case 6:
                            System.out.print("Enter new phone number");
                            employeesList.get(i).setPhoneNumber(sc.nextLine());
                            break;
                        case 7:
                            System.out.print("Enter new email");
                            employeesList.get(i).setEmail(sc.nextLine());
                            break;
                        case 8:
                            System.out.print("Enter new level");
                            employeesList.get(i).setLevel(sc.nextLine());
                            break;
                        case 9:
                            System.out.print("Enter new position");
                            employeesList.get(i).setPosition(sc.nextLine());
                            break;
                        case 10:
                            System.out.print("Enter new salary");
                            employeesList.get(i).setSalary(Long.parseLong(sc.nextLine()));
                            break;

                        case 0:
                            checkEdit = false;
                            break;
                        default:
                            System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
                    }
                }
                System.out.println("employee edited:");
                System.out.println(employeesList.get(i));
                break;
            }
        }
    }
    @Override
    public ArrayList<Employee> readFile(String filePath) {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] employees;
            while ((line = bufferedReaderFile.readLine()) != null) {
                employees = line.split(",");
                list.add(new Employee(Integer.parseInt(employees[0]), employees[1], employees[2], employees[3], employees[4], employees[5], employees[6], employees[7], employees[8], Long.parseLong(employees[9])));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void writeFile(Employee employee, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(employee.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
//public void deleteID(int idStudent) {
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
}