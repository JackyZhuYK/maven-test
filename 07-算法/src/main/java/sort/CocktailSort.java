package sort;

import java.util.Arrays;

/**
 * 鸡尾酒排序----基于冒泡排序的一种升级排序法,两边查，各查一半，防止其他都有序，最小的一个元素在最后面
 */
public class CocktailSort {

    public static void main(String[] args) {
        int[] array = new int[] {5,8,6,3,9,13,2,1,7,10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        int temp = 0;
        for(int i=0;i<array.length/2;i++) {
            //奇数轮
            boolean isSorted = true;
            for(int j=i;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }

            isSorted = true;
            //偶数轮
            for(int j=array.length-1-i;j>i;j--){
                if(array[j]<array[j-1]){
                    temp = array[j];
                    array[j]= array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
