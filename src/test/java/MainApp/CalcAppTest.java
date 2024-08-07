package MainApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcAppTest {
    @Test
    void simpleTest1(){
        CalcApp calcApp = new CalcApp("1+1", "deg");
        Assertions.assertEquals(2, calcApp.getResult());
    }
    @Test
    void simpleTest2(){
        CalcApp calcApp = new CalcApp("(2+1)*2", "deg");
        Assertions.assertEquals(6, calcApp.getResult());
    }
    @Test
    void unaryTest1(){
        CalcApp calcApp = new CalcApp("-2+1", "deg");
        Assertions.assertEquals(-1, calcApp.getResult());
    }
    @Test
    void unaryTest2(){
        CalcApp calcApp = new CalcApp("-2-1", "deg");
        Assertions.assertEquals(-3, calcApp.getResult());
    }
    @Test
    void unaryTest3(){
        CalcApp calcApp = new CalcApp("-(2+1)", "deg");
        Assertions.assertEquals(-3, calcApp.getResult());
    }

    @Test
    void unaryTest4(){
        CalcApp calcApp = new CalcApp("-(-2*(-3+4))+1", "deg");
        Assertions.assertEquals(3, calcApp.getResult());
    }
    @Test
    void unaryTest5(){
        CalcApp calcApp = new CalcApp("-(-5-(-5))+1", "deg");
        Assertions.assertEquals(1, calcApp.getResult());
    }
    @Test
    void unaryTest6(){
        CalcApp calcApp = new CalcApp("-(-5-(-25+10))+1", "deg");
        Assertions.assertEquals(-9, calcApp.getResult());
    }
    @Test
    void prefixTestSqrt1(){
        CalcApp calcApp = new CalcApp("sqrt(25)", "deg");
        Assertions.assertEquals(5, calcApp.getResult());
    }
    @Test
    void prefixTestSqrt2(){
        CalcApp calcApp = new CalcApp("sqrt(sqrt(625))", "deg");
        Assertions.assertEquals(5, calcApp.getResult());
    }
    @Test
    void prefixTestPow1(){
        CalcApp calcApp = new CalcApp("5^2", "deg");
        Assertions.assertEquals(25, calcApp.getResult());
    }
    @Test
    void prefixTestPow2(){
        CalcApp calcApp = new CalcApp("5^(2^2)", "deg");
        Assertions.assertEquals(625, calcApp.getResult());
    }
    @Test
    void prefixTestPercent1(){
        CalcApp calcApp = new CalcApp("100%", "deg");
        Assertions.assertEquals(1, calcApp.getResult());
    }
    @Test
    void prefixTestPercent2(){
        CalcApp calcApp = new CalcApp("(20+1)%", "deg");
        Assertions.assertEquals(0.21, calcApp.getResult());
    }
    @Test
    void prefixTestMod1(){
        CalcApp calcApp = new CalcApp("100mod30", "deg");
        Assertions.assertEquals(10, calcApp.getResult());
    }
    @Test
    void bigTest1(){
        CalcApp calcApp = new CalcApp("15/(7-(1+1))*3-(2+(1+1))*15/(7-(200+1))*3-(2+(1+1))*(15/(7-(1+1))*3-(2+(1+1))+15/(7-(1+1))*3-(2+(1+1)))", "deg");
        Assertions.assertEquals(-30.072164948453608, calcApp.getResult());
    }
    @Test
    void TestDeg1(){
        CalcApp calcApp = new CalcApp("sin(30)", "deg");
        Assertions.assertEquals(Math.sin(30*Math.PI/180), calcApp.getResult());
    }
    @Test
    void TestXVal1(){
        CalcApp calcApp = new CalcApp("5*x", "deg", 2);
        Assertions.assertEquals(10, calcApp.getResult());
    }

}
