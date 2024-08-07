package Polskaya;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnaryTest {
    @Test
    void test1(){
        Assertions.assertTrue(Polskaya.isUnary(0, "-1+1"));
    }
    @Test
    void test2(){
        Assertions.assertTrue(Polskaya.isUnary(1, "(-1)+1"));
    }
    @Test
    void test3(){
        Assertions.assertFalse(Polskaya.isUnary(4, "(-1)+1"));
    }
}
