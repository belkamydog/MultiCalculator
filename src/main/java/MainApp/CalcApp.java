package MainApp;

import Calculator.Calculator;
import Polskaya.Polskaya;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcApp {
    private Polskaya polskaya;
    private Calculator calculator;
    private Double result;
    private String resultString;
    private double xVal;

    public CalcApp(String infix_expression, String mode){
        polskaya = new Polskaya(infix_expression);
        polskaya.calculatePolska();
        calculator = new Calculator(polskaya.getResultString_().toString(), mode);
        calculator.calculateExpression();
        result = calculator.getResult();
        resultString = calculator.getPolskaString();
    }

    public CalcApp(String infix_expression, String mode, double xVal){
        polskaya = new Polskaya(infix_expression);
        polskaya.calculatePolska();
        this.xVal = xVal;
        calculator = new Calculator(polskaya.getResultString_().toString(), mode, xVal);
        calculator.calculateExpression();
        result = calculator.getResult();
        resultString = calculator.getPolskaString();
    }
}
