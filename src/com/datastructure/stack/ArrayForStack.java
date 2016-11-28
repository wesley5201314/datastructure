package com.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by wesley on 2016/11/23.
 * 数组实现栈
 * @see Stack
 * @author wesley
 */
public class ArrayForStack implements Stack{

    //用数组保存栈元素
    private Object[] obj ;
    //栈大小
    private int size;
    //栈的最大长度
    private int MAX_SIZE = 5;
    //栈顶指针
    private int top;

    public ArrayForStack(){
        //初始化数组大小为100
        obj = new Object[MAX_SIZE];
        //初始化栈长度
        size = 0;
        //初始化栈顶指针
        top = -1;
    }


    @Override
    public void push(Object object) {
        if(isFull()){
            //扩容
            reSize();
        }
        /*if(isFull()){
            //抛异常
            throw new StackOverflowError();
        }*/
        //栈顶元素保存在数组末尾
        obj[++top] = object;
        //栈长度+1
        size++ ;
    }

    public void reSize() {
        //修改最大长度
        MAX_SIZE = size*2;
        //数组长度*2
        Object[] temp = new Object[MAX_SIZE];
        int currentIndex = 0;
        //把旧数组存到新数组temp
        while( currentIndex < size){
            //保存旧数组的值
            temp[currentIndex] = obj[currentIndex];
            currentIndex++ ;
        }
        obj = temp;
        temp = null;
    }

    @Override
    public Object pop() {
        //如果栈为空
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //删除栈顶元素
        Object objects = obj[top--];
        //栈长度-1
        size--;
        return objects;
    }

    @Override
    public void display() {
        //如果栈空，报错
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //当前栈长度
        int currentIndex = size;
        //是否栈已遍历完
        while(currentIndex>0){
            //遍历下一个元素
            currentIndex-- ;
            //打印
            System.out.println("第"+(currentIndex)+"个元素："+obj[currentIndex]);
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //返回栈顶元素
        return obj[top];
    }

    @Override
    public void clear() {
        //将底层数组所有元素赋为null
        Arrays.fill(obj,null);
        size = 0;
    }

    @Override
    public boolean isFull(){
        return size == MAX_SIZE;
    }
}
