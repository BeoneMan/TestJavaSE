package junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 */
public class CalculatorTest {

    private Integer i = 10;

    @Before
    public void before() {
        System.out.println("start...");
    }

    @Test
    public void test() {
        Assert.assertEquals(i.intValue(),10);
        System.out.println("test");
    }

    @After
    public void end() {
        System.out.println("end...");
    }


}
