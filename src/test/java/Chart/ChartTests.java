package Chart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChartTests {
    @Test
    public void simpleChartTest1(){
        Chart chart = new Chart(0, 3, "x", 0.5);
        chart.calculateChart();
        double trueCompareNum = 0;
        for (double i : chart.getYAxis()){
            Assertions.assertEquals(i, trueCompareNum);
            trueCompareNum += 0.5;
        }
    }
    @Test
    public void simpleChartTest2(){
        Chart chart = new Chart(0, 3, "x+1", 0.5);
        chart.calculateChart();
        double trueY = 0;
        double x = 0;
        for (double i : chart.getYAxis()){
            trueY = x + 1;
            Assertions.assertEquals(i, trueY);
            x += 0.5;
        }
    }
}
