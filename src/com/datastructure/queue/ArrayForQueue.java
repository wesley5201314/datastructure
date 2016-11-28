package com.datastructure.queue;


import java.util.Arrays;

/**
 * Created by wesley on 2016/11/28.
 * 循环队列（定长队列），用数组实现
 * @author wesley
 */
public class ArrayForQueue<T> implements Queue<T>{

    public T[] data;

    //初始化队列的长度
    public int DEFAULT_LENGTH = 10;

    //队列中元素的个数
    public int size;
    //对首下标
    public int front;
    //队尾下标
    public int rear;


    //初始化列的方法
    private void init(int size) {
        data = (T[])new Object[size];
        size = 0; //初始化元素个数
        front = rear = 0;
    }

    /**
     * 无参构造函数
     */
    public ArrayForQueue(){
        init(DEFAULT_LENGTH);
    }

    /**
     * 有参数构造函数
     * @param size
     */
    public ArrayForQueue(int size){
        init(size);
    }


    @Override
    public void append(T t) {
        if(isFull()){
            //throw new IndexOutOfBoundsException("queue is full");
            reSize();//进行扩容
        }
        //向队尾添加一个元素
        data[rear] = t;
        //队尾指针后移
        rear = (++rear)%DEFAULT_LENGTH;
        //元素个数+1
        size++ ;
    }

    @Override
    public T remove() {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        //保留队列的rear端的元素的值
        T oldValue = (T)data[front];
        //释放队列的rear端的元素
        data[front] = null;
        //队首指向下一个元素的下标
        front = (++front)%DEFAULT_LENGTH;
        //元素个数-1
        size-- ;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 && front == rear;
    }

    @Override
    public T front() {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        return (T)data[front];
    }

    @Override
    public void clear() {
        Arrays.fill(data , null);
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void display() {
        if(isEmpty()){
            throw new IndexOutOfBoundsException("queue is empty");
        }
        //当前队首下标
        int tmp = front;
        while(tmp!=rear){
            System.out.println("current data is:"+data[tmp]);
            tmp++;
        }
    }

    public boolean isFull(){
        return size == data.length;
    }

    public void reSize()
    {
        /*注意重新扩容的时候并不需要去设置size
         * 队列的大小并不能通过数组的大小直观的显示出来。
         * 但是栈就可以直观的通过数组的大小显示出来*/
        T[] tmp = (T[]) new Object[data.length*2];
        System.arraycopy(data, 0, tmp, 0, data.length);
        data = tmp;
        tmp = null;//引用置为空，便于gc处理
    }
}
