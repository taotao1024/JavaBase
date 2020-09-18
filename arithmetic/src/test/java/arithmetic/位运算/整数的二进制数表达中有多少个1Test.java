package arithmetic.位运算;

import com.lsy.arithmetic.位运算.整数的二进制数表达中有多少个1;
import junit.framework.TestCase;

/**
 * @author 19134
 */
public class 整数的二进制数表达中有多少个1Test extends TestCase {
    整数的二进制数表达中有多少个1 test = new 整数的二进制数表达中有多少个1();

    public void testCount1() {
        // 100 = 1100100B
        int result = test.count1(100);
        System.out.println(result);
    }

    public void testCount2() {
        // 100 = 1100100B
        int result = test.count2(100);
        System.out.println(result);
    }

    public void testCount3() {
        // 100 = 1100100B
        int result = test.count3(100);
        System.out.println(result);
    }

    public void testCount4() {
        // 100 = 1100100B
        int result = test.count4(100);
        System.out.println(result);
    }
}