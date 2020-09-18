package arithmetic.位运算;

import com.lsy.arithmetic.位运算.其他数都出现了K次的数组中找到出现了一次的数;
import junit.framework.TestCase;

/**
 * @author 19134
 */
public class 其他数都出现了K次的数组中找到出现了一次的数Test extends TestCase {
    其他数都出现了K次的数组中找到出现了一次的数 test = new 其他数都出现了K次的数组中找到出现了一次的数();

    public void testOnceNum1() {
        int[] arr = {1, 1, 2, 2, 3, 3, 4};
        int res = test.onceNum(arr, 2);
        System.out.println(res);
    }
    public void testOnceNum2() {
        int[] arr = {-1, -1, 2, 2, -3, -3, -4};
        int res = test.onceNum(arr, 2);
        System.out.println(res);
    }
}