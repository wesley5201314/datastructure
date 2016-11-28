package com.datastructure.stack;

import java.util.EmptyStackException;

/**
 * Created by wesley on 2016/11/23.
 * 链表实现栈
 * @see Stack
 * @author wesley
 */
public class LinkedForStack<T> implements Stack<T> {

    //Node定义一个节点类
    private static class Node<T>{
        private T data; //存储的data
        private Node<T> next; //类似指针
        Node(){
            this.data = null;
            this.next = null;
        }

        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        boolean empty(){
            return data == null && next == null;
        }
    }

    private Node<T> top ; //栈顶指针

    private int size; //栈的长度

    private int MAX_SIZE = 5;

    public LinkedForStack(){
        top = new Node<T>(); //初始化栈顶元素
        size = 0;
    }

    @Override
    public void push(T t) {
        //判断栈是否已满
/*       if(isFull()){
            throw new StackOverflowError();
        }*/
        if(isFull()){
            reSize();
        }
        //创建一个节点数据
        top = new Node<T>(t,top);
        //栈长度+1
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T t = top.data; //移除栈顶的元素
        if(!top.empty())//判断栈顶元素是不是空
        {
            //移除栈顶元素，下一个作为栈顶元素
            top = top.next;
        }
        //长度-1
        size--;
        return t;
    }

    @Override
    public void display() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        //从栈顶元素开始遍历
        Node currentData = top;
        int currentIndex = size;
        //如果当前结点不为null
        while (!currentData.empty()){
            currentIndex--;
            //打印
            System.out.println("【"+currentIndex+"】stack currentData:"+currentData.data);
            //指向下一个结点
            currentData = currentData.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return top.empty();
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
        T t = top.data; //获取值栈顶元素
        return t;
    }

    @Override
    public void clear() {
        top = null;//将栈所有元素赋为null
        size = 0;
    }

    public void reSize(){
        MAX_SIZE = size*2;
        int currentIndex = 0;
        Node<T> temp = new Node<T>();
        while(currentIndex < size){
            //保存旧数组的值
            temp.data = top.data;
            temp.next = top.next;
            currentIndex++ ;
        }
        top = temp;
        temp = null;
    }

}
