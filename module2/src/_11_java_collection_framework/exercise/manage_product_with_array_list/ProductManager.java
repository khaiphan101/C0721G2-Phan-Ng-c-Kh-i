package _11_java_collection_framework.exercise.manage_product_with_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager{
    ArrayList<Product> productsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void add() {
        //code them moi
        System.out.print("Enter product's ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter product's name: ");
        String name = sc.nextLine();
        System.out.println("Enter product's price: ");
        int price = Integer.parseInt(sc.nextLine());
        Product product = new Product(id, name, price);
        productsList.add(product);
    }

    public void showList() {
        System.out.println("Product's list:");
        for (int i = 0; i < productsList.size(); i++) {
                System.out.println(productsList.get(i).toString());
        }
    }

    public void editID(int idProduct) {
        System.out.println("- edit product's ID: " + idProduct);
        for (int i = 0; i < productsList.size(); i++) {
            if (idProduct == productsList.get(i).getId()) {
                boolean checkEdit = true;
                while (checkEdit) {
                    System.out.println(productsList.get(i).toString());
                    System.out.print("1.ID\n" +
                            "2.Name\n" +
                            "3.Price\n" +
                            "0.Exit\n" +
                            "Choose section you want to edit:");
                    switch (Integer.parseInt(sc.nextLine())) {
                        case 1:
                            System.out.print("Enter new ID:");
                            productsList.get(i).setId(Integer.parseInt(sc.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter new Name:");
                            productsList.get(i).setName(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("Enter new price");
                            productsList.get(i).setPrice(Integer.parseInt(sc.nextLine()));
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
    public void deleteID(int idProduct) {
        System.out.println("- remove product's ID: " + idProduct);
        for (int i = 0; i < productsList.size(); i++) {
            if (idProduct == productsList.get(i).getId()) {
                productsList.remove(i);
            }
        }
        showList();
    }

    public Boolean search(String infor) {
        System.out.println("-search product: "+ infor);
        for (int i = 0; i < productsList.size(); i++) {
            if (infor.equals(String.valueOf(productsList.get(i).getId()))
                    ||infor.equals(productsList.get(i).getName())
                    ||infor.equals(productsList.get(i).getPrice())
            ) {
                System.out.println(productsList.get(i));
                return true;
            }
        }
        System.out.println("this infor isn't exist");
        return false;
    }
//    public void sort(){
//
//    }
}
