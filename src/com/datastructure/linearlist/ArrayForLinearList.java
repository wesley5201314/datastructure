package com.datastructure.linearlist;

/**
 * Created by wesley on 2016/11/29.
 * 用数组实现线性顺序表
 *@author wesley
 */
public class ArrayForLinearList {
    //*****************初始化***********
    //保存数据
    private Object[] objects;
    //最大容量
    private int DEFAULT_CAPACITY = 10;
    //线性表长度
    private int length;

    public ArrayForLinearList(){
        objects = new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    //*****************操作***********
    //往线性表结尾插入数据
    public void add(Object obj){
        //结尾放入数据
        objects[length] = obj;
        //数组长度+1
        length++;
    }

    //显示线性顺序表中的数据
    public void display(){
        for( int i = 0 ; i < length ; i++){
            System.out.println(objects[i]);
        }
    }

    //根据下标查值
    public Object get(int i){
        return objects[i];
    }

    //根据值查询下表
    public int getIndex(Object obj){
        for( int i = 0 ; i < length ; i++){
            if(objects[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    //在第i个位置插入新数据
    public boolean insert(int i,Object obj){
        i = i-1;
        if( i < 0 || i > length ) return false;
        //从最后一个数据开始交换，直到k==i true
        for( int k = length ; k > i ; k--){
            objects[k] = objects[k-1];
        }
        //插入位置放入数据
        objects[i] = obj;
        //数组长度+1
        length++;
        return true;
    }
    //删除线性表中第i个元素
    public boolean delete(int i){
        if( i <= 0 || i > length ) return false;
        //从最后一个数据开始交换，直到k==i true
        for( int k = i-1 ; k < length-1 ; k++){
            objects[k] = objects[k+1];
        }
        length--;
        objects[length] = null;
        return true;
    }
}
