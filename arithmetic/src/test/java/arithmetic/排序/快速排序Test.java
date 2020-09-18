package arithmetic.排序;

import com.lsy.arithmetic.排序.快速排序;
import org.junit.Test;

import java.util.Arrays;

public class 快速排序Test {

    @Test
    public void quickSort0() {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        快速排序.quickSort0(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void quickSort1() {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        快速排序.quickSort1(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void quickSort2() {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        快速排序.quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}