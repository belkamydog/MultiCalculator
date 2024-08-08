package Engineer;

import Engineer.PolskayaCalculator.PolskayaCalculator;
import Engineer.Polskaya.Polskaya;
import Engineer.ValidationAndPreparing.ValidationAndPreparing;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Efimov Artyom or Perryell
 * @version 1.0
 * Предназначен для арифметических рассчетов.
 * Если инфиксное выражение не валидно {@link #isValid()} вернет false а в строке результата будет то же инфиксное выражение.
 * Создайте обьект класса и вызовите метод {@link #calculate()}
 * Используйте Getters для получения результатов расчета.
 * */
@Getter
@Setter
public class EngineerCalculator {
    private String infixExpression;
    private PolskayaCalculator.degreeOrRadian mode;
    private double result;
    private String resultString;
    private double xVal;
    private boolean valid;

    public EngineerCalculator(String infix_expression, PolskayaCalculator.degreeOrRadian mode){
        this.infixExpression = infix_expression;
        this.mode = mode;
    }

    public EngineerCalculator(String infix_expression, PolskayaCalculator.degreeOrRadian mode, double xVal){
        this.infixExpression = infix_expression;
        this.xVal = xVal;
        this.mode = mode;
    }

    /**
     * Главная функция для рассчета
     * */
    public void calculate(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(infixExpression);
        if (validationAndPreparing.isValid()){
            infixExpression = validationAndPreparing.getInfixExpression();
            Polskaya polskaya = new Polskaya(infixExpression);
            polskaya.calculatePolska();
            PolskayaCalculator polskayaCalculator = new PolskayaCalculator(polskaya.getResultString(), mode, xVal);
            polskayaCalculator.calculateExpression();
            result = polskayaCalculator.getResult();
            resultString = polskayaCalculator.getResultString();
            valid = true;
        }
        else{
            valid = false;
            resultString = infixExpression;
            result = Double.NEGATIVE_INFINITY;
        }

    }
}
