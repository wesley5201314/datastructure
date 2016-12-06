package com.datastructure.sort;
/**
 * Created by wesley on 2016/12/6.
 * 归并排序
 * @author wesley
 */
public class MergeSort {
	//非递归实现归并排序，从小到大。list1在start-middle和middle+1-end之间排序
	public static void mergeSort(int [] list1,int [] list2,int start,int middle){
		//i是list1在start-middle之间的下标指针，q是list1在middle+1-end之间的下标指针
		int i = 0, j = 0, q = 0;
		i = start;   //从前子列表第一个元素开始
		j = middle+1;	//从后自列表的第一个元素开始
		q = 0; //归并后的数组
		//当数组的两个分段都没遍历完
		while( i < middle && j < list1.length ){
			//当list1的前子列表的第i个元素比list1的后自列表的第j个元素的
			System.out.println("当前i="+i+";j="+j);
			System.out.println("当前i值="+list1[i]+";j值="+list1[j]);
			if( list1[i] > list1[j] ){
				//把较小元素放入归并数组
				list2[q] = list1[j];
				j++;
				q++;
			}else{
				//把较小元素放入归并数组
				list2[q] = list1[i];
				i++;
				q++;
			}
			System.out.println("当前i="+i+";j="+j);
			System.out.println("当前i值="+list1[i]+";j值="+list1[j]);
		}
		//如果前子列表有剩余，把剩余元素放入list2
		while( i < middle ){
			list2[q] = list1[i];
			++q;
			++i;
		}

		//如果后子列表有剩余，把剩余元素放入list2
		while( j < list1.length ){
			list2[q] = list1[j];
			++q;
			++j;
		}
		StraightInsertionSort.printArr(list2);
	}

	//递归实现归并排序
	public static void mergeSort(int [] list , int low ,int high){
		if( low < high ){
			int mid = ( low + high ) / 2; //从中间分开
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] list1 = {1,3,5,7,2,4,6,8,9};
		int [] list2 = new int[8];
		mergeSort(list1,list2,0,3);
	}

}
