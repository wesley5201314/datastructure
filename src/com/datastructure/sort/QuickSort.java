package com.datastructure.sort;

/**
 * Created by wesley on 2016/12/6.
 * 快速排序
 * @author wesley
 */
public class QuickSort {
    //根据中轴元素排序
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // 数组的第一个作为中轴
        //首尾相等则跳出循环，因为表明数组中元素已遍历完
        while (low < high) {
            //从右向左找到要移位的元素（也就是比中轴元素小的第一个元素）
            while (low < high && list[high] >= tmp) {
                high--;
            }
            //移位
            list[low] = list[high]; // 比中轴小的记录移到低端
            //从左向右找到要移位的元素（也就是比中轴元素大的第一个元素）
            while (low < high && list[low] <= tmp) {
                low++;
            }
            //移位
            list[high] = list[low]; // 比中轴大的记录移到高端
        }
        list[low] = tmp; // 中轴记录到尾
        return low; // 返回中轴的位置

    }
    //开始快排序
    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            //中轴元素的下标
            int middle = getMiddle(list, low, high); // 将list数组进行一分为二
            //在中轴元素的左侧子数组进行再排序
            quickSort(list, low, middle - 1); // 对低字表进行递归排序
            //在中轴元素的右侧子数组进行再排序
            quickSort(list, middle + 1, high); // 对高字表进行递归排序
        }
    }

    public static void main(String args[]) {
        int[] list = { 1, 3, 5, 7, 2, 4, 6, 8, 9 };
        quickSort(list,0,list.length-1);
        //打印排序后的结果
        StraightInsertionSort.printArr(list);
    }
}
