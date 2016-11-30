package com.datastructure.linearlist;

import java.util.Arrays;

/**
 * Created by wesley on 2016/11/29.
 * 顺序表实现线性表
 * @author wesley
 */
public class SequenceList<T> implements LList<T> {

    //*****************初始化***********

    private Object[] elements;  //顺序表采用数据存放数据元素
    private int len;            //顺序表的长度，记录实际元素个数
    //无参的构造函数
    public SequenceList(){
        this(5);        //创建默认容量的数组
    }
    //有参构造函数
    public SequenceList(int size){
        this.elements=new Object[size];  //初始化存储数组
        this.len=0;                     //设顺序表的初始长度为0
    }

    //*****************操作***********
    @Override
    public boolean isEmpty() {
        return this.len == 0;
    }

    @Override
    public int length() {
        return this.len;
    }

    /**
     * 取第i个元素在数组中是[i-1]
     */
    @Override
    public T get(int i) {
        if(i>=1 && i<=this.len){
            return (T) elements[i-1];
        }
        return null;
    }

    /**
     * 设置第i个元素的值为x
     */
    @Override
    public void set(int i, T x) {
        if(x==null){
            return;
        }
        if(i>=1 && i<=this.len){
            elements[i-1]=x;
        }
        else{
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    /**
     * 插入x作为第i个元素
     */
    @Override
    public void insert(int i, T x) {
        if(x==null){
            return;
        }
        //如果数组已满，则扩充顺序表容量
        if(this.len==elements.length){
            Object[] temp=this.elements;     //创建临时temp变量引用elements数组
            this.elements=new Object[temp.length*2];  //重新申请一个容量更大的数组
            //复制数组元素
            for(int j=1;j<=temp.length;j++){
                this.elements[j-1]=temp[j-1];
            }
        }
        //如果i小于1，则设i为1
        if(i<1){
            i=1;
        }
        //如果插入位置等于线性表的长度，相当于在最后插入数据
        if(i==this.len){
            i=this.len+1;
        }
        //元素后移，len+1
        for(int j=this.len;j>=i;j--){
            this.elements[j]=this.elements[j-1];
        }
        this.elements[i-1]=x;
        this.len++;
    }

    //在顺序表的最后插入元素x
    @Override
    public void append(T x) {
        this.insert(this.len, x);
    }
    //删除顺序表的第i个元素,并返回此元素
    @Override
    public T remove(int i) {
        //删除第i个元素 暂时保存第i个元素
        T tmp = (T)elements[i-1];
        elements[i-1] = null;
        //从最后一个数据开始交换，直到k==i
        for(int k=i-1;k<=len-1;k++){
            elements[k] = elements[k+1];
        }
        len--;
        return tmp;
    }

    //删除顺序表所有的元素
    @Override
    public void removeAll() {
        Arrays.fill(elements,null);
        len = 0;
    }

    //查找，返回首次出现的关键字为key元素
    @Override
    public T search(T key) {
        for( int i = 0 ; i < len ; i++){
            if( elements[i].equals(key) )
                return (T)elements[i];
        }
        return null;
    }

    /**
     * 返回顺序表所有元素的描述字符串，形式为(,)覆盖Object中的toString()方法
     */
    public String toString(){
        String str="(";
        if(this.len>0){
            str+=this.elements[0].toString();
        }
        for(int i=1;i<this.len;i++){
            str+=","+elements[i].toString();
        }
        return str+")";
    }

    //显示线性顺序表中的数据
    public void display(){
        for( int i = 0 ; i < len; i++){
            System.out.println(elements[i]);
        }
    }
}
