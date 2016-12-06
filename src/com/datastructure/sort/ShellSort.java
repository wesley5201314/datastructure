package com.datastructure.sort;

/**
 * Created by wesley on 2016/12/6.
 * 希尔排序
 * @author wesley
 */
public class ShellSort {
	//shell排序，从小到大
	public static void shellSort(int [] list){
		if( list.length <= 0){
			System.out.println("Empty List!");
			return ;
		}
		//初始间距为数组长度的一半
		int dk = list.length/2;
		//当间距大于或等于1时，继续排序，每次排序完成后间距变为原来一半
		for( ; dk >= 1 ; dk=(dk/2)){
			//对于间距为dk的子数组进行插入排序,
			for( int i = dk ; i < list.length ; i=(i+dk) ){
				//开始排序
				int j = 0;
				int temp = list[i];//取出第i个数，和前i-1个比较,找到插入位置
				for (j = i - dk; j >= 0 && temp < list[j]; j -= dk) {
					list[j + dk] = list[j];
				}
				list[j + dk] = temp;
			}

		}
		StraightInsertionSort.printArr(list);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] list = {10,9,8,7,6,5,4,3,2,1};
		shellSort(list);
	}

}

