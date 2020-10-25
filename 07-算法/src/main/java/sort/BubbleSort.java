package sort;

import java.util.Arrays;

/**
 * 简单冒泡排序
 * 时间复杂度为O(n^2)
 * 稳定排序
 */
public class BubbleSort {

    public static void sort(int array[]) {
        for(int i=0;i<array.length-1;i++) {
            for(int j=0;j<array.length-1-i;j++) {
                int temp = 0;
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
