package com.datastructure.sort;

/**
 * Created by wesley on 2016/12/6.
 * 选择排序
 * @author wesley
 */
public class SelectSort {
	//选择排序  从小到大
	public static void selectSort(int [] list){
		//总共循环n-1趟，因为中间有交换
		for( int i = 0 ; i < list.length-1 ; i++){
			//记录每次查找到的最小的元素
			int min = i;
			//i之前的元素已有序，从第i个元素开始查找剩余元素中的最小值
			for( int j = i ; j < list.length ; j++){
				//如果当前min指向元素大于下一个元素，则让min指向下一个元素的索引，始终让min指向剩余元素中最小的元素的索引
				if(  list[min] > list[j] ){
					min = j;
				}
				//如果当前元素小于下一个元素，则交换
			}
			//第i+1趟结束，让min指向元素与第i个元素交换
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
		StraightInsertionSort.printArr(list);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] list = {9,8,7,6,5,4,3,2,1};
		selectSort(list);
	}

}
