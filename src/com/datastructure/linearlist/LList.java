package com.datastructure.linearlist;

/**
 * Created by wesley on 2016/11/29.
 * 线性表接口
 * @author wesley
 */
public interface LList<T> {

    public boolean isEmpty();  //判断线性表是否为空
    public int length();       //返回线性表的长度
    public T get(int i);       //返回第i个元素
    public void set(int i,T x); //设置第i个元素为x
    public void insert(int i,T x);//插入x作为第i个元素
    public void append(T x);    //在线性表最后插入x元素
    public T remove(int i);     //删除第i个元素并返回被删除的对象
    public void removeAll();    //删除线性表的所有元素
    public T search(T key);     //查找，返回首次出现的关键字为key元素

}
