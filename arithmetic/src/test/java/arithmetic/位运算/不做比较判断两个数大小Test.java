package arithmetic.位运算;

import com.lsy.arithmetic.位运算.不做比较判断两个数大小;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 19134
 */
public class 不做比较判断两个数大小Test extends TestCase {
    不做比较判断两个数大小 test = new 不做比较判断两个数大小();

    public void testFlip() {
        int result = test.flip(1);
        Assert.assertEquals(result, 0);
    }

    public void testSign() {
        int result = test.sign(100);
        Assert.assertEquals(result, 1);
    }

    /**
     * 两个正数
     */
    public void testGetMax1_1() {
        int result = test.getMax1(20, 10);
        Assert.assertEquals(result, 20);
    }

    /**
     * 正数和负数
     */
    public void testGetMax1_2() {
        int result = test.getMax1(200, -1);
        Assert.assertEquals(result, 200);
    }

    /**
     * 两个负数
     */
    public void testGetMax1_3() {
        int result = test.getMax1(-1, -2);
        Assert.assertEquals(result, -1);
    }

    /**
     * 溢出测试(a-b存在溢出)
     */
    public void testGetMax1_4() {
        int result = test.getMax1(2000000000, -2000000000);
        Assert.assertEquals(result, 2000000000);
    }

    /**
     * 两个正数
     */
    public void testGetMax2_1() {
        int result = test.getMax2(2, 1);
        Assert.assertEquals(result, 2);
    }

    /**
     * 正数和负数
     */
    public void testGetMax2_2() {
        int result = test.getMax2(200, -1);
        Assert.assertEquals(result, 200);
    }

    /**
     * 正数和负数
     */
    public void testGetMax2_3() {
        int result = test.getMax2(-2, -1);
        Assert.assertEquals(result, -1);
    }

    /**
     * 溢出测试
     */
    public void testGetMax2_4() {
        int result = test.getMax2(2000000000, -2000000000);
        Assert.assertEquals(result, 2000000000);
    }

    public void testMathMax() {
        int a = 2000000000, b = -2000000000;
        System.out.println(Math.max(a, b));
    }
}