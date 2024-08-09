package Chart;

import Engineer.EngineerCalculator;
import Engineer.PolskayaCalculator.PolskayaCalculator;
import Engineer.ValidationAndPreparing.ValidationAndPreparing;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Efimov Artyom or Perryell
 * @version 1.0
 * Предназначен для рассчета и получения массивов значений для построения графика.
 * Оперирует значением переменной 'x' подставляя в нее значения из выбранной области опоеделения.
 * Если инфиксное выражение не валидно {@link #isValid()} вернет false, а массивы xVal & yVal будут пусты.
 * Создайте обьект класса и вызовите метод {@link #calculateChart()} ()}
 * Используйте Getters для получения результатов расчета.
 */
@Getter
@Setter
public class Chart {
    /**
     * Входные данные
     */
    private String infixExpression;
    private final double xMinInterval;
    private final double xMaxInterval;
    private double step;
    /**
     * Рассчетные данные
     */
    private boolean valid;
    private List<Double> xAxis;
    private List<Double> yAxis;

    /**
     * Конструктор рассчета графика
     *
     * @param infixExpression - выражение в инфиксной нотации
     * @param xMax            - максимальный предел области значений
     * @param xMin            - минимальный предел области значений
     */
    public Chart(double xMin, double xMax, String infixExpression, double step) {
        this.xMaxInterval = xMax;
        this.xMinInterval = xMin;
        this.infixExpression = infixExpression;
        xAxis = new ArrayList<>();
        yAxis = new ArrayList<>();
        this.step = step;
    }

    /**
     * Главная вычисляющая функция
     */
    public void calculateChart() {
        ValidationAndPreparing validation = new ValidationAndPreparing(infixExpression);
        if (validation.isValid()) {
            valid = true;
            for (double i = xMinInterval; i < xMaxInterval; i += step) {
                EngineerCalculator engineerCalculator = new EngineerCalculator(infixExpression, PolskayaCalculator.degreeOrRadian.deg, i);
                engineerCalculator.calculate();
                xAxis.add(i);
                yAxis.add(engineerCalculator.getResult());
            }
        } else {
            valid = false;
        }
    }
}
