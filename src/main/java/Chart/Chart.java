package Chart;

import MainApp.CalcApp;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Chart {
    private String infixExpression;
    private double xMinInterval;
    private double xMaxInterval;
    private List<Double> xAxis;
    private List<Double> yAxis;

    public Chart(double xMin, double xMax, String infixExpression){
        this.xMaxInterval = xMax;
        this.xMinInterval = xMin;
        this.infixExpression = infixExpression;
        xAxis = new ArrayList<>();
        yAxis = new ArrayList<>();
    }

    public void calculateChart(){
        for (double i = xMinInterval; i < xMaxInterval; i+= 0.5){
            CalcApp calcApp = new CalcApp(infixExpression, "rad", i);
            xAxis.add(i);
            yAxis.add(calcApp.getResult());
        }
    }
}
