package Engineer.PolskayaCalculator;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Stack;

@Setter
@Getter
public class PolskayaCalculator {
    public enum degreeOrRadian{
        rad, deg
    }
    private String polskaString;
    private degreeOrRadian mode;
    private double xVal;
    private double result;
    private String resultString;
    private Stack<Double> numbers;

    public PolskayaCalculator(String polskaString, degreeOrRadian mode){
        this.polskaString = polskaString;
        this.mode = mode;
        numbers = new Stack<>();
    }

    public PolskayaCalculator(String polskaString, degreeOrRadian mode, double xVal){
        this.polskaString = polskaString;
        this.mode = mode;
        this.xVal = xVal;
        numbers = new Stack<>();
    }


    public void calculateExpression(){
        String[] tokens =  polskaString.split(" ");
        for (String i: tokens){
            if (i.equals("~")) numbers.push(numbers.pop()*(-1));
            else if (i.equals("x")) numbers.push(xVal);
            else if (PolskayaCalculator.isOperand(i)) {
                numbers.push(Double.parseDouble(i));
            }
            else {
                if ("sctSCTQLGQ%".contains(i)) prefixMenu(i);
                else operationMenu(i);
            }
        }
        result = numbers.pop();
        NumberFormat nf = new DecimalFormat("#.######");
        resultString = nf.format(result);
    }

    @Contract(pure = true)
    private @NotNull Double gradToRad(double rad){ return (rad*Math.PI/180);}

    private void prefixMenu(@NotNull String operator){
        double value = numbers.pop();
        if (mode == degreeOrRadian.deg && ("sct".contains(operator))) value = gradToRad(value);
        switch (operator) {
            case "s" -> numbers.push(Math.sin(value));
            case "c" -> numbers.push(Math.cos(value));
            case "t" -> numbers.push(Math.tan(value));
            case "S" -> numbers.push(Math.asin(value));
            case "C" -> numbers.push(Math.acos(value));
            case "T" -> numbers.push(Math.atan(value));
            case "L" -> numbers.push(Math.log(value));
            case "G" -> numbers.push(Math.log10(value));
            case "Q" -> numbers.push(Math.sqrt(value));
            case "%" -> numbers.push(value/100);
        }
    }
    private void operationMenu(@NotNull String operator){
        double b = numbers.pop();
        double a = numbers.pop();
        switch (operator) {
            case "+" -> numbers.push(a + b);
            case "-" -> numbers.push(a - b);
            case "*" -> numbers.push(a * b);
            case "/" -> numbers.push(a / b);
            case "m" -> numbers.push(a % b);
            case "^" -> numbers.push(Math.pow(a, b));
        }
    }

    public static boolean isOperand(@NotNull String str){
        boolean result = true;
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') result = false;
        }
        return result;
    }
}
