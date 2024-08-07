package Polskaya;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Getter
@Setter
public class Polskaya {
    private String inputString_;
    private StringBuilder resultString_;
    private Stack <Character> operatorsStack_;
    private final String operators_ = "()+-*/m%^";

    public Polskaya(){
        operatorsStack_ = new Stack<Character>();
        resultString_ = new StringBuilder();
    }
    public Polskaya(String inputString){
        operatorsStack_ = new Stack<Character>();
        resultString_ = new StringBuilder();
        this.inputString_ = inputString;
    }
    public void calculatePolska(){
        replaceFunctions();
        for (byte i = 0; i < inputString_.length(); i++){
            char current_ch = inputString_.charAt(i);
            postfixFunctions(i);
            if (Character.isDigit(current_ch) || current_ch == '.' || current_ch == 'x'){
                resultString_.append(current_ch);
            }
            else if (ifOperator(current_ch)){
                if (Polskaya.isUnary(i, inputString_)) current_ch = '~';
                workWithStack(current_ch);
            }
        }
        cleanStack();
    }

    private void replaceFunctions(){
        inputString_ = inputString_.replaceAll("asin", "S");
        inputString_ = inputString_.replaceAll("acos", "C");
        inputString_ = inputString_.replaceAll("atan", "T");
        inputString_ = inputString_.replaceAll("sqrt", "Q");
        inputString_ = inputString_.replaceAll("ln", "L");
        inputString_ = inputString_.replaceAll("log", "G");
        inputString_ = inputString_.replaceAll("mod", "m");
        inputString_ = inputString_.replaceAll("tan", "t");
        inputString_ = inputString_.replaceAll("sin", "s");
        inputString_ = inputString_.replaceAll("cos", "c");
    }

    private void postfixFunctions(int index){
        switch (inputString_.charAt(index)){
            case 's' -> operatorsStack_.push('s');
            case 'c' -> operatorsStack_.push('c');
            case 't' -> operatorsStack_.push('t');
            case 'S' -> operatorsStack_.push('S');
            case 'C' -> operatorsStack_.push('C');
            case 'T' -> operatorsStack_.push('T');
            case 'Q' -> operatorsStack_.push('Q');
            case 'G' -> operatorsStack_.push('G');
            case 'L' -> operatorsStack_.push('L');
        }
    }

    public static boolean isUnary(int index, String value){
        boolean result = false;
        if (index == 0 && value.charAt(index) == '-') result = true;
        else if (index > 0 && value.charAt(index-1) == '(' && value.charAt(index) == '-'){
            result = true;
        }
        return result;
    }

    private void cleanStack(){
        while (!operatorsStack_.isEmpty()){
            addSpacer();
            resultString_.append(operatorsStack_.pop());
        }
    }

    private void workWithStack(char ch){
        addSpacer();
        if (operatorsStack_.isEmpty()) operatorsStack_.push(ch);
        else if (ch == '(') operatorsStack_.push(ch);
        else if (ch == ')') closeBracket();
        else popHigherPriorityOperators(ch);
    }

    private void addSpacer(){
        if (!resultString_.isEmpty() && resultString_.charAt(resultString_.length()-1) != ' '){
            resultString_.append(' ');
        }
    }

    private void closeBracket(){
        char ch = operatorsStack_.pop();
        while (!operatorsStack_.isEmpty() && ch != '('){
            resultString_.append(ch);
            addSpacer();
            ch = operatorsStack_.pop();
        }
        addSpacer();
    }

    private void popHigherPriorityOperators(char ch){
        char current_ch_in_stack = operatorsStack_.peek();
        while (!operatorsStack_.isEmpty() && getPriority(current_ch_in_stack) >= getPriority(ch)){
            resultString_.append(current_ch_in_stack);
            operatorsStack_.pop();
            if (!operatorsStack_.isEmpty()) current_ch_in_stack = operatorsStack_.peek();
            addSpacer();
        }
        addSpacer();
        operatorsStack_.push(ch);
    }

    private byte getPriority(char ch){
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
        return  result;
    }
    private boolean ifOperator(Character ch){
        boolean result = false;
        for (byte i = 0; i < operators_.length(); i++){
            if (ch.equals(operators_.charAt(i))) {
                result = true;
                break;
            }
        }
        return  result;
    }
}
