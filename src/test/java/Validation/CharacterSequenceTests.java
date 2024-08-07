package Validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CharacterSequenceTests {
    @Test
    public void characterSequenceAfterDigitTest1(){
        Validation validation = new Validation("4+1");
        Assertions.assertTrue(validation.isValid());
    }
    @Test
    public void validCharacterSequenceAfterDigitTest2(){
        Validation validation = new Validation("sin(30)+1+2");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    public void validCharacterSequenceAfterDigitTest3(){
        Validation validation = new Validation("2");
        Assertions.assertTrue(validation.isValid());
    }

    @Test
    public void invalidCharacterSequenceAfterDigitTest1(){
        Validation validation = new Validation("4(+1");
        System.err.println(validation.getInfixExpression());
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidCharacterSequenceAfterDigitTest2(){
        Validation validation = new Validation("4+1x+2");
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void invalidCharacterSequenceAfterDigitTest3(){
        Validation validation = new Validation("4sin(30)+1x+2");
        Assertions.assertFalse(validation.isValid());
    }


    @Test
    public void invalidCharacterSequenceEmpty(){
        Validation validation = new Validation("");
        Assertions.assertFalse(validation.isValid());
    }

    @Test
    public void invalidCharacterDeleteAllSpaces1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation(" 1 + 1 ");
        Method method = Validation.class.getDeclaredMethod("deleteAllSpaces", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertEquals("1+1", validation.getInfixExpression());
    }
    @Test
    public void lowerCase() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals("sin(30)", "SiN(30)".toLowerCase());
    }
    @Test
    public void invalidCharacterDeleteAllSpaces2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation(" 1            + 1 ");
        Method method = Validation.class.getDeclaredMethod("deleteAllSpaces", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertEquals("1+1", validation.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5(2+3)");
        Method method = Validation.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertEquals("5*(2+3)", validation.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5(2+3)s(30)");
        Method method = Validation.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertEquals("5*(2+3)*s(30)", validation.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5(2+3)s(c(5s(30)2))");
        Method method = Validation.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertEquals("5*(2+3)*s(c(5*s(30)*2))", validation.getInfixExpression());
    }
    @Test
    public void dotSequence1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5..5");
        Method method = Validation.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void dotSequence2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5.5.5");
        Method method = Validation.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void dotSequence3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5+.5");
        Method method = Validation.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertFalse(validation.isValid());
    }
    @Test
    public void dotSequence4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Validation validation = new Validation("5+5.");
        Method method = Validation.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validation, null);
        Assertions.assertFalse(validation.isValid());
    }
}
