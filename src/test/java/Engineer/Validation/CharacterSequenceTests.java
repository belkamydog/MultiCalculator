package Engineer.Validation;

import Engineer.ValidationAndPreparing.ValidationAndPreparing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Тесты валидации инфиксного выражения на последовательность символов
 * @author Efimov Artyom / perryell
 * @version 1.0
 * */

public class CharacterSequenceTests {
    @Test
    public void characterSequenceAfterDigitTest1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("4+1");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }
    @Test
    public void validCharacterSequenceAfterDigitTest2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("sin(30)+1+2");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    public void validCharacterSequenceAfterDigitTest3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("2");
        Assertions.assertTrue(validationAndPreparing.isValid());
    }

    @Test
    public void invalidCharacterSequenceAfterDigitTest1(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("4(+1");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidCharacterSequenceAfterDigitTest2(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("4+1x+2");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void invalidCharacterSequenceAfterDigitTest3(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("4sin(30)+1x+2");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }


    @Test
    public void invalidCharacterSequenceEmpty(){
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("");
        Assertions.assertFalse(validationAndPreparing.isValid());
    }

    @Test
    public void invalidCharacterDeleteAllSpaces1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(" 1 + 1 ");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("deleteAllSpaces", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertEquals("1+1", validationAndPreparing.getInfixExpression());
    }
    @Test
    public void lowerCase() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals("sin(30)", "SiN(30)".toLowerCase());
    }
    @Test
    public void invalidCharacterDeleteAllSpaces2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing(" 1            + 1 ");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("deleteAllSpaces", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertEquals("1+1", validationAndPreparing.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5(2+3)");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertEquals("5*(2+3)", validationAndPreparing.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5(2+3)s(30)");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertEquals("5*(2+3)*s(30)", validationAndPreparing.getInfixExpression());
    }
    @Test
    public void insertMultiplyIfItAbsence3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5(2+3)s(c(5s(30)2))");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("insertMultiplyIfAbsence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertEquals("5*(2+3)*s(c(5*s(30)*2))", validationAndPreparing.getInfixExpression());
    }
    @Test
    public void dotSequence1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5..5");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void dotSequence2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5.5.5");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void dotSequence3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5+.5");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
    @Test
    public void dotSequence4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ValidationAndPreparing validationAndPreparing = new ValidationAndPreparing("5+5.");
        Method method = ValidationAndPreparing.class.getDeclaredMethod("checkDotSequence", null);
        method.setAccessible(true);
        method.invoke(validationAndPreparing, null);
        Assertions.assertFalse(validationAndPreparing.isValid());
    }
}
