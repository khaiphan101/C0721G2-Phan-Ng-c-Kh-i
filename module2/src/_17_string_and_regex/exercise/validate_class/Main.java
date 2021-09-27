package _17_string_and_regex.exercise.validate_class;

public class Main {
    public static boolean isValidateClass(String className) {
        String regexClass = "[CAP]\\d{4}[GHIKLM]";
        return className.matches(regexClass);
    }
    public static final String[] validNumber = new String[]{"C0318G", "P1111H", "A0381M"};
    public static final String[] invalidNumber = new String[]{"M0318G", "P0323A", "C03181"};

    public static void main(String[] args) {
        for (String className : validNumber) {
            System.out.println("class: " + className + " is valid: " + isValidateClass(className));
        }
        for (String className : invalidNumber) {
            System.out.println("class: " + className + " is valid: " + isValidateClass(className));

        }

    }
}
