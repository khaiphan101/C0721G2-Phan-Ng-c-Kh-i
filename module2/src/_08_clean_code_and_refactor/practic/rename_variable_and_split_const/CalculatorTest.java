//package _08_clean_code_and_refactor.practic.rename_variable_and_split_const;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CalculatorTest {
//    public static final char ADDITION = '+';
//    public static final char SUBTRACTION = '-';
//    public static final char MULTIPLICATION = '*';
//    public static final char DIVISION = '/';
//    public static final char EQUALUTION = '=';
//    int firstOperand;
//    int secondOperand;
//    char operator;
//    int expected;
//    int result;
//
//    @Test
//    @DisplayName("Testing addition")
//    void testCalculateAdd() {
//        firstOperand = 1;
//        secondOperand = 1;
//        operator = ADDITION;
//        expected = 2;
//
//        result = Calculator.calculate(firstOperand, secondOperand, operator);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Testing subtraction")
//    void testCalculateSub() {
//        firstOperand = 2;
//        secondOperand = 1;
//        operator = SUBTRACTION;
//        expected = 1;
//
//        result = Calculator.calculate(firstOperand, secondOperand, operator);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Testing multiplication")
//    void testCalculateMul() {
//        firstOperand = 2;
//        secondOperand = 2;
//        operator = MULTIPLICATION;
//        expected = 4;
//
//        result = Calculator.calculate(firstOperand, secondOperand, operator);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Testing division")
//    void testCalculateDiv() {
//        firstOperand = 6;
//        secondOperand = 3;
//        operator = DIVISION;
//        expected = 2;
//
//        result = Calculator.calculate(firstOperand, secondOperand, operator);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    @DisplayName("Testing division by zero")
//    void testCalculateDivByZero() {
//        firstOperand = 2;
//        secondOperand = 0;
//        operator = DIVISION;
//
//        assertThrows(RuntimeException.class,
//                () -> {
//                    Calculator.calculate(firstOperand, secondOperand, operator);
//                });
//    }
//
//    @Test
//    @DisplayName("Testing wrong operator")
//    void testCalculateWrongOperator() {
//        firstOperand = 2;
//        secondOperand = 0;
//        operator = EQUALUTION;
//
//        assertThrows(RuntimeException.class,
//                () -> {
//                    Calculator.calculate(firstOperand, secondOperand, operator);
//                });
//    }
//}
