package Engineer.MainApp;

import Engineer.EngineerCalculator;
import Engineer.PolskayaCalculator.PolskayaCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EngineerCalculatorTest {
    @Test
    void simpleTest1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("1+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(2, engineerCalculator.getResult());
    }

    @Test
    void simpleTest2() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("(2+1)*2", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(6, engineerCalculator.getResult());
    }

    @Test
    void unaryTest1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-2+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(-1, engineerCalculator.getResult());
    }

    @Test
    void unaryTest2() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-2-1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(-3, engineerCalculator.getResult());
    }

    @Test
    void unaryTest3() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-(2+1)", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(-3, engineerCalculator.getResult());
    }

    @Test
    void unaryTest4() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-(-2*(-3+4))+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(3, engineerCalculator.getResult());
    }

    @Test
    void unaryTest5() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-(-5-(-5))+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(1, engineerCalculator.getResult());
    }

    @Test
    void unaryTest6() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("-(-5-(-25+10))+1", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(-9, engineerCalculator.getResult());
    }

    @Test
    void prefixTestSqrt1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("sqrt(25)", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(5, engineerCalculator.getResult());
    }

    @Test
    void prefixTestSqrt2() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("sqrt(sqrt(625))", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(5, engineerCalculator.getResult());
    }

    @Test
    void prefixTestPow1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("5^2", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(25, engineerCalculator.getResult());
    }

    @Test
    void prefixTestPow2() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("5^(2^2)", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(625, engineerCalculator.getResult());
    }

    @Test
    void prefixTestPercent1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("100%", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(1, engineerCalculator.getResult());
    }

    @Test
    void prefixTestPercent2() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("(20+1)%", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(0.21, engineerCalculator.getResult());
    }

    @Test
    void prefixTestMod1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("100mod30", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(10, engineerCalculator.getResult());
    }

    @Test
    void bigTest1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(-30.072164948453608, engineerCalculator.getResult());
    }

    @Test
    void TestDeg1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("sin(30)", PolskayaCalculator.degreeOrRadian.deg);
        engineerCalculator.calculate();
        Assertions.assertEquals(Math.sin(30 * Math.PI / 180), engineerCalculator.getResult());
    }

    @Test
    void TestXVal1() {
        EngineerCalculator engineerCalculator = new EngineerCalculator("5*x", PolskayaCalculator.degreeOrRadian.deg, 2);
        engineerCalculator.calculate();
        Assertions.assertEquals(10, engineerCalculator.getResult());
    }

}
