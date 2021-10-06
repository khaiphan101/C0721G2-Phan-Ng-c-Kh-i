package furama_resort.services;

import furama_resort.models.Booking;
import furama_resort.models.Contract;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ContractServiceImpl implements ContractService {
    Scanner sc = new Scanner(System.in);
    private String CONTRACT_FILE = "src\\furama_resort\\data\\list_of_contract.csv";
    Queue<Contract> contractsList = this.readFile(CONTRACT_FILE);

    @Override
    public void showList() {
        System.out.println("contract's list:");
        for (Contract contract : contractsList) {
            System.out.println(contract);
        }
    }

    public void add() {
        Set<Booking> bookingList = new BookingServiceImpl().bookingsList;
        Queue<Booking> newListBooking = new ArrayDeque<>();
        newListBooking.addAll(bookingList);
        while (newListBooking.size() > 0) {
            if (newListBooking.peek().getServiceType().equals("Room")) {
                newListBooking.poll();
            } else {
                Booking booking = newListBooking.peek();
                int customerCode = booking.getCustomerCode();
                System.out.println("Doing contract with Booking: " + booking);
                Contract contract = new Contract();
                System.out.println("Enter id contract:");
                contract.setIdContract(Integer.parseInt(sc.nextLine()));
                contract.setBookingCode(booking.getCode());
                System.out.println("Enter deposit:");
                contract.setDeposit(sc.nextLine());
                System.out.println("Enter totalpay:");
                contract.setTotalPay(Integer.parseInt(sc.nextLine()));
                contract.setCustomerCode(customerCode);
                contractsList.add(contract);
                writeListContractToFile();
                newListBooking.poll();
            }
        }
    }


    @Override
    public void edit(int idContract) {
        Queue<Contract> list = new ArrayDeque<>();
        int size = contractsList.size();
        for (int i = 0; i < size; i++) {
            if (idContract == contractsList.peek().getIdContract()) {
                Contract contract = contractsList.remove();
                int checkEdit = -1;
                while (checkEdit != 0) {
                    System.out.println(contract);
                    System.out.print("1.Id contract\n" +
                            "2.bookingCode\n" +
                            "3.deposit\n" +
                            "4.totalpay\n" +
                            "5.customerCode\n" +
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    checkEdit = Integer.parseInt(sc.nextLine());
                    switch (checkEdit) {
                        case 1:
                            System.out.print("Enter new id contract:");
                            contract.setIdContract(Integer.parseInt(sc.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter new booking code:");
                            contract.setBookingCode(Integer.parseInt(sc.nextLine()));
                            break;
                        case 3:
                            System.out.print("Enter new deposit");
                            contract.setDeposit(sc.nextLine());
                            break;
                        case 4:
                            System.out.print("Enter new totalpay");
                            contract.setTotalPay(Integer.parseInt(sc.nextLine()));
                            break;
                        case 5:
                            System.out.print("Enter new customerCode");
                            contract.setCustomerCode(Integer.parseInt(sc.nextLine()));
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("invalid value, please enter ordinal number(1,2,3,4)");
                    }
                }
                System.out.println("contract edited");
                System.out.println(list.add(contract));
            } else list.add(contractsList.remove());
        }
        System.out.println("before edit");
        showList();
        for (int i = 0; i < size; i++) {
            contractsList.add(list.remove());
        }
        System.out.println("after edit");
        showList();
        writeListContractToFile();
    }

    public void delete() {

    }

    public Queue<Contract> readFile(String filePath) {
        Queue<Contract> list = new ArrayDeque<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] contract;
            while ((line = bufferedReaderFile.readLine()) != null) {
                contract = line.split(",");
                list.add(new Contract(Integer.parseInt(contract[0]), Integer.parseInt(contract[1]), contract[2], Integer.parseInt(contract[3]), Integer.parseInt(contract[4])));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(Contract contract, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(contract.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeListContractToFile() {
        try {
            File file = new File(CONTRACT_FILE);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract : contractsList) {
                bufferedWriter.write(contract.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
