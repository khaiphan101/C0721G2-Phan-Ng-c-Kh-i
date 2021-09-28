package _17_string_and_regex.exercise.validate_phone_number;

public class Main {
    public static final String[] validNumber = new String[]{"(84)-(0783264255)", "(84)-(0978489648)", "(12)-(0353353535)", "(13)-(0983260496)"};
    public static final String[] invalidNumber = new String[]{"(a8)-22222222", "(13-1231231231)", "(13)-(012345678910)", "(123)-(0777777777)"};

    public static void main(String[] args) {
        for (String number : validNumber) {
            System.out.println("number: " + number + " is valid: " + isValidatePhoneNumber(number));
        }
        for (String number : invalidNumber) {
            System.out.println("number: " + number + " is valid: " + isValidatePhoneNumber(number));
        }
    }

    public static boolean isValidatePhoneNumber(String number) {
        String regexNumber = "[(][0-9]{2}[)]-[(]0\\d{9}[)]";
        return number.matches(regexNumber);
    }
}
