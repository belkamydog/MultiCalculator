package Engineer.Polskaya;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

/**
 * @author Efimov Artyom or Perryell
 * @version 1.0
 * Предназначен для преобразования выражения в обратную польскую нотацию.
 * Создайте обьект класса и вызовите метод {@link #calculatePolska()}
 * Используйте {@link #getResultString()} для получения результатов расчета.
 */

@Setter
public class Polskaya {
    @Getter
    private String inputString;
    private StringBuilder resultString;
    private Stack<Character> operatorsStack;
    private final String OPERATORS = "()+-*/m%^";

    public Polskaya() {
        operatorsStack = new Stack<Character>();
        resultString = new StringBuilder();
    }

    public Polskaya(String inputString) {
        operatorsStack = new Stack<Character>();
        resultString = new StringBuilder();
        this.inputString = inputString;
    }

    public String getResultString() {
        return resultString.toString();
    }

    /**
     * Главная функция преобразования
     */
    public void calculatePolska() {
        replaceFunctions();
        for (byte i = 0; i < inputString.length(); i++) {
            char current_ch = inputString.charAt(i);
            postfixFunctions(i);
            if (Character.isDigit(current_ch) || current_ch == '.' || current_ch == 'x') {
                resultString.append(current_ch);
            } else if (ifOperator(current_ch)) {
                if (isUnary(i, inputString)) current_ch = '~';
                workWithStack(current_ch);
            }
        }
        cleanStack();
    }

    private void replaceFunctions() {
        inputString = inputString.replaceAll("asin", "S");
        inputString = inputString.replaceAll("acos", "C");
        inputString = inputString.replaceAll("atan", "T");
        inputString = inputString.replaceAll("sqrt", "Q");
        inputString = inputString.replaceAll("ln", "L");
        inputString = inputString.replaceAll("log", "G");
        inputString = inputString.replaceAll("mod", "m");
        inputString = inputString.replaceAll("tan", "t");
        inputString = inputString.replaceAll("sin", "s");
        inputString = inputString.replaceAll("cos", "c");
    }

    private void postfixFunctions(int index) {
        switch (inputString.charAt(index)) {
            case 's' -> operatorsStack.push('s');
            case 'c' -> operatorsStack.push('c');
            case 't' -> operatorsStack.push('t');
            case 'S' -> operatorsStack.push('S');
            case 'C' -> operatorsStack.push('C');
            case 'T' -> operatorsStack.push('T');
            case 'Q' -> operatorsStack.push('Q');
            case 'G' -> operatorsStack.push('G');
            case 'L' -> operatorsStack.push('L');
        }
    }

    private boolean isUnary(int index, String value) {
        boolean result = false;
        if (index == 0 && value.charAt(index) == '-') result = true;
        else if (index > 0 && value.charAt(index - 1) == '(' && value.charAt(index) == '-') {
            result = true;
        }
        return result;
    }

    private void cleanStack() {
        while (!operatorsStack.isEmpty()) {
            addSpacer();
            resultString.append(operatorsStack.pop());
        }
    }

    private void workWithStack(char ch) {
        addSpacer();
        if (operatorsStack.isEmpty()) operatorsStack.push(ch);
        else if (ch == '(') operatorsStack.push(ch);
        else if (ch == ')') closeBracket();
        else popHigherPriorityOperators(ch);
    }

    private void addSpacer() {
        if (!resultString.isEmpty() && resultString.charAt(resultString.length() - 1) != ' ') {
            resultString.append(' ');
        }
    }

    private void closeBracket() {
        char ch = operatorsStack.pop();
        while (!operatorsStack.isEmpty() && ch != '(') {
            resultString.append(ch);
            addSpacer();
            ch = operatorsStack.pop();
        }
        addSpacer();
    }

    private void popHigherPriorityOperators(char ch) {
        char current_ch_in_stack = operatorsStack.peek();
        while (!operatorsStack.isEmpty() && getPriority(current_ch_in_stack) >= getPriority(ch)) {
            resultString.append(current_ch_in_stack);
            operatorsStack.pop();
            if (!operatorsStack.isEmpty()) current_ch_in_stack = operatorsStack.peek();
            addSpacer();
        }
        addSpacer();
        operatorsStack.push(ch);
    }

    private byte getPriority(char ch) {
        byte result = -1;
        if (ch == '+' || ch == '-' || ch == 'm') result = 2;
        else if (ch == '*' || ch == '/') result = 3;
        else if (ch == '(') result = 0;
        else if (ch == ')') result = 1;
        else if (ch == '~') result = 4;
        else if (ch == 's' || ch == 'c' || ch == 't') result = 5;
        else if (ch == 'S' || ch == 'C' || ch == 'T') result = 5;
        else if (ch == 'Q' || ch == 'L' || ch == 'G') result = 5;
        else if (ch == '%') result = 1;
        else if (ch == '^') result = 6;
        return result;
    }

    private boolean ifOperator(Character ch) {
        boolean result = false;
        for (byte i = 0; i < OPERATORS.length(); i++) {
            if (ch.equals(OPERATORS.charAt(i))) {
                result = true;
                break;
            }
        }
        return result;
    }
}
