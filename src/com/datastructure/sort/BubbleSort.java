package com.datastructure.sort;
/**
 * Created by wesley on 2016/12/12.
 * 冒泡排序
 * @author wesley
 */
public class BubbleSort {
	//升序
	public static void ascSort(int [] list){
		//n个元素则需要n-1轮循环,因为每轮都是要交换的
		for( int i = 0 ; i < list.length ; i++){
			//
			for( int j = 0 ; j < list.length-i-1 ; j++){
				//如果第j大于第j+1个元素的值，则交换顺序，大的往后排
				if( list[j] > list[j+1]){
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}

			}
		}
		StraightInsertionSort.printArr(list);
	}


	//降序
	public static void descSort(int [] list){
		//n个元素则需要n-1轮循环,因为每轮都是要交换的
		for( int i = 0 ; i < list.length ; i++){
			//
			for( int j = 0 ; j < list.length-i-1 ; j++){
				//如果第j小于第j+1个元素的值，则交换顺序，小的往后排
				if( list[j] < list[j+1]){
					int temp = list[j+1];
					list[j+1] = list[j];
					list[j] = temp;
				}

			}
		}
		StraightInsertionSort.printArr(list);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] list = {9,8,7,6,5,4,3,2,1};
		descSort(list);//降序
		ascSort(list);//升序
	}

}
