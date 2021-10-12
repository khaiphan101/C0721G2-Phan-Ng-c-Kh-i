package ultis;

import java.util.Scanner;

public class RegexData {
    static Scanner sc = new Scanner(System.in);
    public static String regexStr(String temp, String regex){
        boolean flag = true;
        do{
            if(temp.matches(regex)){
                flag = false;
            }else{
                System.err.println("Fail input, please input again:");
                temp = sc.nextLine();
            }
        }while (flag);
        return temp;
    }
}

