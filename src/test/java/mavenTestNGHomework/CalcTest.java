package mavenTestNGHomework;

import Homework.Calculator2;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalcTest {

    Calculator2 calculator;

    @BeforeSuite
    public void initCalculatorObject() {
        calculator = new Calculator2();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Starting test!");
    }

    @Test
    public void testAddMethod() {
        Assert.assertEquals(calculator.add(10, 20), 30, "Test for AddMethod failed");
    }

    @Test
    public void testSubtractMethod() {
        Assert.assertEquals(calculator.subtract(30, 20), 10, "Test for SubtractMethod failed");
    }

    @Test
    public void testMultiplyMethod() {
        Assert.assertEquals(calculator.multiply(3, 5), 15, "Test for MultiplyMethod failed");
    }

    @Test
    public void testDivideMethod() {
        Assert.assertEquals(calculator.divide(20, 10), 2.00, "Test for DivideMethod failed");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished!");
    }


}
