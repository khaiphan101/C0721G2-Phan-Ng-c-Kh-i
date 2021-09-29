package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    private String CUSTOMER_FILE = "src/caseStudy_furamaResort/data/list_of_customer";
    LinkedList<Customer> customerList = this.readFile(CUSTOMER_FILE);

    Scanner sc = new Scanner(System.in);

    public void add() {
        //code them moi
        Customer customer = new Customer();

        System.out.println("Enter customer code:");
        customer.setCode(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter name:");
        customer.setName(sc.nextLine());

        System.out.println("Enter birthday:");
        customer.setBirthday(sc.nextLine());

        System.out.println("Enter gender:");
        customer.setGender(sc.nextLine());

        System.out.println("Enter id number:");
        customer.setIdNumber(sc.nextLine());

        System.out.println("Enter phone number:");
        customer.setPhoneNumber(sc.nextLine());

        System.out.println("Enter email:");
        customer.setEmail(sc.nextLine());

        System.out.println("Enter rank:");
        customer.setRank(sc.nextLine());

        System.out.println("Enter address:");
        customer.setAddress(sc.nextLine());

        this.writeFile(customer, CUSTOMER_FILE);
        customerList.add(customer);
    }

    public void showList() {
        System.out.println("customer's list:");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public void edit(int customerCode) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerCode == customerList.get(i).getCode()) {
                boolean checkEdit = true;
                while (checkEdit) {
                    System.out.println(customerList.get(i));
//super(code, name, birthday, gender, idNumber, phoneNumber, email);
//        this.rank = rank;
//        this.address = address;
                    System.out.print("1.Customer code\n" +
                            "2.Name\n" +
                            "3.Birthday\n" +
                            "4.Gender\n" +
                            "5.ID number\n" +
                            "6.Phone number\n" +
                            "7.Email\n" +
                            "8.rank\n" +
                            "9.address\n" +
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    switch (Integer.parseInt(sc.nextLine())) {
                        case 1:
                            System.out.print("Enter new code:");
                            customerList.get(i).setCode(Integer.parseInt(sc.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter new Name:");
                            customerList.get(i).setName(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Enter new Birthday");
                            customerList.get(i).setBirthday(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Enter new Gender");
                            customerList.get(i).setGender(sc.nextLine());
                            break;
                        case 5:
                            System.out.print("Enter new ID");
                            customerList.get(i).setIdNumber(sc.nextLine());
                            break;
                        case 6:
                            System.out.print("Enter new phone number");
                            customerList.get(i).setPhoneNumber(sc.nextLine());
                            break;
                        case 7:
                            System.out.print("Enter new email");
                            customerList.get(i).setEmail(sc.nextLine());
                            break;
                        case 8:
                            System.out.print("Enter new rank");
                            customerList.get(i).setRank(sc.nextLine());
                            break;
                        case 9:
                            System.out.print("Enter new address");
                            customerList.get(i).setAddress(sc.nextLine());
                            break;
                        case 0:
                            checkEdit = false;
                            break;
                        default:
                            System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
                    }
                }
                System.out.println("customer edited:");
                System.out.println(customerList.get(i));
                break;
            }
        }
    }

    public LinkedList<Customer> readFile(String filePath) {
        LinkedList<Customer> list = new LinkedList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] customer;
            while ((line = bufferedReaderFile.readLine()) != null) {
                customer = line.split(",");
                list.add(new Customer(Integer.parseInt(customer[0]), customer[1], customer[2], customer[3], customer[4], customer[5], customer[6], customer[7], customer[8]));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(Customer customer, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(customer.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
