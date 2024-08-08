package Engineer.Polskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Тесты преобразования выражения в обратную польскую нотацию
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class PolskayaAppTest {
   private final Polskaya polskaya = new Polskaya();
   @ParameterizedTest
   @ValueSource(strings = {"(2+5)*(3+4)-1"})
    void test1(String value){
      polskaya.setInputString(value);
      polskaya.calculatePolska();
      Assertions.assertEquals(polskaya.getResultString(), "2 5 + 3 4 + * 1 -");
   }
   @Test
    void test2(){
       polskaya.setInputString("(22.3+5)*(31+4)-1");
       polskaya.calculatePolska();
       Assertions.assertEquals(polskaya.getResultString(), "22.3 5 + 31 4 + * 1 -");
   }
   @Test
    void test3(){
       polskaya.setInputString("2+2");
       polskaya.calculatePolska();
       Assertions.assertEquals(polskaya.getResultString(), "2 2 +");
   }
    @Test
    void testWithUnary1(){
        polskaya.setInputString("-2+2");
        polskaya.calculatePolska();
        Assertions.assertEquals(polskaya.getResultString(), "2 ~ 2 +");
    }
    @Test
    void testWithUnary2(){
        polskaya.setInputString("2+(-2)");
        polskaya.calculatePolska();
        Assertions.assertEquals(polskaya.getResultString(), "2 2 ~ +");
    }
    @Test
    void testWithUnary3(){
        polskaya.setInputString("(-(-2)+3)+2");
        polskaya.calculatePolska();
        Assertions.assertEquals(polskaya.getResultString(), "2 ~ ~ 3 + 2 +");
    }
    @Test
    void testReplace1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Polskaya p = new Polskaya("sin(30)");
        Method method = Polskaya.class.getDeclaredMethod("replaceFunctions");
        method.setAccessible(true);
        method.invoke(p);
        Assertions.assertEquals("s(30)", p.getInputString());
    }
    @Test
    void testReplace2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Polskaya p = new Polskaya("sin(sin(30))");
        Method method = Polskaya.class.getDeclaredMethod("replaceFunctions");
        method.setAccessible(true);
        method.invoke(p);
        Assertions.assertEquals("s(s(30))", p.getInputString());
    }
    @Test
    void postfixTest1(){
       polskaya.setInputString("sin(30)");
       polskaya.calculatePolska();
       Assertions.assertEquals("30 s", polskaya.getResultString());
    }
    @Test
    void postfixTestSin(){
        polskaya.setInputString("sin(sin(30+1)-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("30 1 + s 10 - s", polskaya.getResultString());
    }

    @Test
    void postfixTestCos(){
        polskaya.setInputString("cos(cos(30+1)-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("30 1 + c 10 - c", polskaya.getResultString());
    }
    @Test
    void postfixTestTan(){
        polskaya.setInputString("tan(tan(tan(tan(tan(1))))-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("1 t t t t 10 - t", polskaya.getResultString());
    }
    @Test
    void postfixTestAtan(){
        polskaya.setInputString("atan(atan(atan(atan(atan(1))))-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("1 T T T T 10 - T", polskaya.getResultString());
    }
    @Test
    void postfixTestAsin(){
        polskaya.setInputString("asin(asin(asin(asin(asin(1))))-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("1 S S S S 10 - S", polskaya.getResultString());
    }
    @Test
    void postfixTestAcos(){
        polskaya.setInputString("acos(acos(acos(acos(acos(1))))-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("1 C C C C 10 - C", polskaya.getResultString());
    }
    @Test
    void postfixTestMultiPrefix1(){
        polskaya.setInputString("tan(cos(sin(atan(acos(1))))-10)");
        polskaya.calculatePolska();
        Assertions.assertEquals("1 C T s c 10 - t", polskaya.getResultString());
    }
    @Test
    void postfixTestPercent1(){
        polskaya.setInputString("5%");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 %", polskaya.getResultString());
    }
    @Test
    void postfixTestPercent2(){
        polskaya.setInputString("100-2%+100%");
        polskaya.calculatePolska();
        Assertions.assertEquals("100 2 - 100 + % %", polskaya.getResultString());
    }
    @Test
    void postfixTestMod1(){
        polskaya.setInputString("100mod30");
        polskaya.calculatePolska();
        Assertions.assertEquals("100 30 m", polskaya.getResultString());
    }
    @Test
    void postfixTestPow1(){
        polskaya.setInputString("5^(2+1)");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 2 1 + ^", polskaya.getResultString());
    }
    @Test
    void postfixTestPow2(){
        polskaya.setInputString("5^(5^1)");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 5 1 ^ ^", polskaya.getResultString());
    }
    @Test
    void postfixTestPow3(){
        polskaya.setInputString("5^(sqrt(5^(2.5*2)))");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 5 2.5 2 * ^ Q ^", polskaya.getResultString());
    }
    @Test
    void postfixTestPow4(){
        polskaya.setInputString("5^2");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 2 ^", polskaya.getResultString());
    }

    @Test
    void postfixTestX1(){
        polskaya.setInputString("5*x");
        polskaya.calculatePolska();
        Assertions.assertEquals("5 x *", polskaya.getResultString());
    }
}
