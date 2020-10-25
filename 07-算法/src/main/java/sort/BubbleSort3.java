package sort;

import java.util.Arrays;

/**
 * 冒泡排序第3版----如果最后发现没有要排序的则中途停止+记录最后排序下标，解决后面都是排好序，无需排序的问题
 * 时间复杂度 O(n^2)
 * 依旧是稳定排序
 */
public class BubbleSort3 {
    public static void main(String[] args) {
        int[] array = new int[] {5,8,6,3,9,2,1,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        int lastChangeIndex = 0;
        int sortBorder = array.length-1;

        for(int i=0;i<array.length-1;i++){
            boolean isSorted = true;
            for(int j=0;j<sortBorder;j++){
                int temp = 0;
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    lastChangeIndex = j;
                }
            }
            sortBorder = lastChangeIndex;

            if(isSorted) {
                return;
            }
        }
    }
}
