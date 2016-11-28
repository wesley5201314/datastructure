package com.datastructure.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by wesley on 2016/11/23.
 * 容器实现栈
 * @see Stack
 * @author wesley
 */
public class ListForStack<T> implements Stack<T>{

    //容器实现栈
    private List<T> list;
    //栈的大小
    private int size;
    //栈最大长度
    private int MAX_SIZE = 5;

    public ListForStack(){
        list = new ArrayList<T>(MAX_SIZE);
        size = 0;
    }

    @Override
    public void push(T t) {
        //判断是否栈满了
        /*if(isFull()){
            throw new StackOverflowError();
        }*/
        if(isFull()){
            reSize();
        }
        //元素入栈
        list.add(t);
        //长度+1
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //移除一个元素
        T t = list.remove(size-1);
        //长度-1
        size--;
        return t;
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
            System.out.println("第"+(currentIndex)+"个元素："+list.get(currentIndex));
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //获取栈顶元素
        T t = list.get(size-1);
        return t;
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
    }

    //自动扩容
    private void reSize(){
        MAX_SIZE = size*2;
        //扩大2倍
        List<T> temp = new ArrayList<T>(MAX_SIZE);
        int currentIndex = 0;
        //把旧数组存到新数组temp
        while(currentIndex < size){
            //保存旧数组的值
            temp.add(list.get(currentIndex));
            currentIndex++ ;
        }
        list = temp;
        temp = null;
    }
}
