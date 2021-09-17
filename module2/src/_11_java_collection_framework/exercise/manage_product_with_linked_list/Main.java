package _11_java_collection_framework.exercise.manage_product_with_linked_list;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.productsList.add(new Product(123, "Nokia", 1000));
        productManager.productsList.add(new Product(127, "Samsung", 30000));
        productManager.productsList.add(new Product(125, "Iphone", 40000));
        productManager.productsList.add(new Product(126, "Xiaomi", 20000));
        productManager.productsList.add(new Product(124, "Sony", 500000));
        while(true) {
            System.out.println("Optione\n" +
                    "1. Add\n" +
                    "2. Show\n" +
                    "3. Delete\n" +
                    "4. Edit\n" +
                    "5. Search\n" +
                    "6. Sort by price\n" +
                    "0. Exit\n");
            System.out.print("Your choice:");
            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.showList();
                    break;
                case 3:
                    //delete
                    System.out.println("------DELETE PRODUCT------");
                    productManager.showList();
                    System.out.print("Enter product's ID to delete: ");
                    productManager.deleteID(sc.nextInt());
                    break;
                case 4:
                    //edit
                    System.out.println("------EDIT PRODUCT------");
                    productManager.showList();
                    System.out.print("Enter product's ID to edit: ");
                    productManager.editID(sc.nextInt());
                    break;
                case 5:
                    //search
                    System.out.println("------SEARCH PRODUCT------");
                    productManager.showList();
                    boolean searchedCheck= false;
                    do {
                        System.out.print("Enter information of product to search: ");
                        searchedCheck = productManager.search(sc.nextLine());
                    }while(!searchedCheck);
                    break;
                case 6:
                    //sort
                    System.out.println("------SORT PRODUCT------");
                    System.out.println("Optione\n" +
                            "1. Sort in descending order(a3>a2>a1).\n" +
                            "2. Sort in ascending order(a1<a2<a3).\n" +
                            "0. Exit\n");
                    System.out.print("Your choice:");
                    int sortChoice = Integer.parseInt(sc.nextLine());
                    if(sortChoice == 1) {
                        System.out.println("Product's list is sorted in descending order by value:");
                        Collections.sort(productManager.productsList, new ProductSortDescending());
                    } else if(sortChoice == 2) {
                        System.out.println("Product's list is sorted in ascending order by value:");
                        Collections.sort(productManager.productsList, new ProductSortAscending());
                    }
                    productManager.showList();
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
