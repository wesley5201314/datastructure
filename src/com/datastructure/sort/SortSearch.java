package com.datastructure.sort;

import java.util.ArrayList;

import javax.naming.BinaryRefAddr;

/**
 * Created by wesley on 2016/12/6.
 * 顺序查找
 * @author wesley
 */
public class SortSearch {
	//一般线性表的顺序查找，参数arr的首元素为空或者null，便于查找标识
	public static int getKeyIndex(ArrayList arr,String key){
		//设置首元素为key
		arr.set(0, key);
		//线性表的长度
		int i = arr.size();
		//如果线性表的某个元素的key和已知key相同，则结束循环，否则i--并执行相同判断
		for(  ; !arr.get(i-1).equals(key) ; i--);
		return i;
	}
	//有序表的顺序查找

	//对递增顺序线性表进行折半查找
	public static int binarySearch(ArrayList<Integer> arr, int key){
		//找到中间的元素,奇数为中间的元素，偶数为
		int low = 0 , heigh = arr.size()-1, mid = 0;
		//如果首尾元素不等
		while( heigh >= low){
			//指向中间元素
			mid = (heigh + low)/2;
			System.out.println("当前指向的mid元素："+mid);
			if( arr.get(mid) == key ){
				return mid;
			}
			if( arr.get(mid) > key ){
				//在mid左侧查找，上限指定为当前元素的左侧元素
				heigh = mid -1;
				System.out.println("当前起始点:"+low+",当前终点:"+heigh);
			}
			if( arr.get(mid) < key ){
				//在mid右侧查找，下限指定为当前元素的右侧元素
				low = mid +1 ;
				System.out.println("当前起始点:"+low+",当前终点:"+heigh);
			}
		}
		return mid;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("---------------顺序查找！---------------");
		ArrayList arr = new ArrayList();
		arr.add( "");
		arr.add( "1");
		arr.add( "2");
		arr.add( "3");
		arr.add( "4");
		arr.add( "5");
		arr.add( "6");
		arr.add("7");
		System.out.println(getKeyIndex(arr, "9"));
		System.out.println("---------------折半查找！---------------");
		ArrayList arr2 = new ArrayList();
		arr2.add(0);
		arr2.add(1);
		arr2.add(2);
		arr2.add(3);
		arr2.add(4);
		arr2.add(5);
		arr2.add(6);
		arr2.add(7);
		arr2.add(8);
		System.out.println(binarySearch(arr2, 1));

	}

}
