package management;

import models.Show;
import utils.Input;
import utils.ReadAndWriteShowToFile;

import java.util.List;
import java.util.Scanner;

public class ShowManagement {
    static Scanner sc = new Scanner(System.in);

    List<Show> showList = ReadAndWriteShowToFile.readFile();

    public void displayShowList() {
        for (Show show : showList) {
            System.out.println(show);
        }
    }

    public void add() {
        //code them moi
//        private String codeShow;
//        private String movieName;
//        private String showDate;
//        private int totalTicket;
        String showCode = Input.inputShowCode();
        String movieName = Input.chooseMovieName();
        String showDate = Input.inputShowDate();
        int totalTicket = Input.inputTotalTicket();
        Show show = new Show(showCode, movieName, showDate, totalTicket);
        showList.add(show);
        ReadAndWriteShowToFile.writeFile(showList);
    }

    public void deleteShow() {
        displayShowList();
        System.out.println("enter show code you want to delete:");
        try {
            String info = sc.nextLine();
            for (int i = 0; i < showList.size(); i++) {
                if (info.equals(showList.get(i).getCodeShow())) {
                    System.out.println("Confirm that you want to delete this show?\n" +
                            "1.\tYes\n" +
                            "2.\tNo\n" +
                            "Please enter your choice: ");
                    int choice = Integer.parseInt(sc.nextLine());
                    if (choice == 1) {
                        showList.remove(i);
                        ReadAndWriteShowToFile.writeFile(showList);
                        break;
                    } else if (choice == 2) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
