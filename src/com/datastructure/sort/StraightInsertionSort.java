package com.datastructure.sort;

/**
 * Created by wesley on 2016/12/6.
 * 直接插入排序
 * @author wesley
 */
public class StraightInsertionSort {
    public static void insertSort(int[] list) {
        // 打印第一个元素

        // 第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
        for (int i = 1; i < list.length; i++) {
            int j = 0;
            int temp = list[i]; // 取出第i个数，和前i-1个数比较后，插入合适位置
            System.out.println("当前第"+i+"轮");
            // 因为前i-1个数都是从小到大的有序序列，所以只要当前比较的数(list[j])比temp大，就把这个数后移一位
            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
            printArr(list);
        }
    }

    public static void printArr(int[] list){
        for(int i = 0 ; i < list.length ; i++){
            System.out.print("  " + list[i] + "  ");
        }
        System.out.println("");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int [] list = {9,8,7,6,5,4,3,2,1};
        //insertSort(list);
        insertSort2(list);
        //System.out.println();
    }

    //直接插入排序算法实现
    public static int [] insertSort2(int[] list){
        int temp = 0 ;
        //依次把第i个元素在i-1的位置进行局部插入排序
        for( int i = 1 ; i < list.length ; i++ ){
            //保存要插入的元素的值，不然局部排序会丢失
            temp = list[i];
            //根据j来判断插入ude位置
            int j = 0;
            //因为在第i个元素之前已经有序，从右向左查找比当前要插入元素大的最后一个元素的位置并赋值给j
            for( j = i ; j > 0 && list[j] > temp ; j-- ){
                //移动数组元素
                list[j] = list[j-1];
            }
            //改变插入位置j的值
            list[j] = temp;
        }
        printArr(list);
        return list;
    }
}
