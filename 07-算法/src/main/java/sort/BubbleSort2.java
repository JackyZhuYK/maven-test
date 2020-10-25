package sort;

import java.util.Arrays;

/**
 * 冒泡排序第2版----如果最后发现没有要排序的则中途停止
 * 时间复杂度O(n^2)
 * 稳定排序
 */
public class BubbleSort2 {
    public static void main(String[] args) {
        int[] array = new int[] {5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            boolean isSorted = true;
            for(int j=0;j<array.length-1-i;j++){
                int temp = 0;
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                return;
            }
        }
    }
}
