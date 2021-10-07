package utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import models.Movie;
import models.Show;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Input {
    private static final String CODE_REGEX = "CI-\\d{4}";
    //    private static final String NAME_REGEX = "[A-Z](\\s?\\w*\\s?)*";
    private static final String DAY_REGEX = "([0-9]*[0-9]\\/){2}\\d{4}";
    private static final String POSITIVE_NUMBER = "(\\d)+";
    static List<Movie> movieList = ReadAndWriteMovieToFile.readFile();
    static Scanner sc = new Scanner(System.in);


    public static String inputShowCode() {
        boolean checkDuplicate;
        List<Show> showList = ReadAndWriteShowToFile.readFile();
        String showCode;
        do {
            checkDuplicate = true;
            System.out.println("Enter show code(CI-XXXX):");
            showCode = RegexData.regexStr(sc.nextLine(), CODE_REGEX);
            for (Show show : showList) {
                if (showCode.equals(show.getCodeShow())) {
                    System.err.println(showCode + " is duplicate, please input again!");
                    checkDuplicate = false;
                    break;
                }
            }
        } while (!checkDuplicate);

        return showCode;
    }

    public static String chooseMovieName() {
        System.out.println("Movie list:");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println(i + 1 + ". " + movieList.get(i));
        }
        int choice;
        while (true) {
            try {
                System.out.println("choose movie(1,2,3...):");
                choice = Integer.parseInt(sc.nextLine());
                return movieList.get(choice - 1).getName();
            } catch (Exception e) {
                System.err.println("fail input movie, please input again!");
            }
        }
    }



    public static int inputTotalTicket() {
        System.out.println("Enter total ticket(should be a positive number):");
        return Integer.parseInt(RegexData.regexStr(sc.nextLine(), POSITIVE_NUMBER));
    }

    public static String inputShowDate() {
        while (true) {
            System.out.println("Enter show date(DD/MM/YYYY):");
            String date = sc.nextLine();
            if (checkValidateDate(date)) {
                return date;
            } else {
                System.err.println(date + " is invalid");
            }
        }
    }

    public static boolean checkValidateDate(String dateInput) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date inputDate = simpleDateFormat.parse(dateInput);
            Date currentDate = new Date();
            return currentDate.before(inputDate);
        }catch (ParseException e){
            System.err.println(dateInput + " is invalid");
        }
        return false;
    }
}
