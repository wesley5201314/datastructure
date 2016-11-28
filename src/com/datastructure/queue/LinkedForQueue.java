package com.datastructure.queue;

/**
 * Created by wesley on 2016/11/28.
 * 链表队列（单链表）
 *
 * @author wesley
 */
public class LinkedForQueue<T> implements Queue<T> {

    //链的数据结构
    private class Node<T> {
        public T data;
        public Node<T> next;

        //无参构造函数
        public Node() {
            data = null;
            next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        boolean empty() {
            return data == null && next == null;
        }
    }

    //队列头指针
    private Node<T> front;
    //队列尾指针
    private Node<T> rear;
    //队列长度
    private int length;

    public LinkedForQueue() {
        Node n = new Node<T>();
        n.next = null;
        length = 0;
        front = rear = n;
    }


    @Override
    public void append(T t) {
       //创建一个节点
        Node node = new Node(t, null);
        //如果当前队列不为空。
        if (!rear.empty()) {
            rear.next = node; //队尾结点指向新结点
        }
        rear = node; //设置队尾结点为新结点
        //说明要插入的结点是队列的第一个结点
        if (front.empty()) {
            front = node;
        }
        length++;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        //暂存队头元素
        Node tmp = front;
        T t = (T) tmp.data;
        //将队头元素所在节点摘链
        front = tmp.next;
        //删除节点
        tmp = null;
        length--;
        return t;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T front() {
        T t = (T) front.data;
        return t;
    }

    @Override
    public void clear() {
        //队首 队尾都赋值null 便于GC回收
        front = null;
        rear = null;
        length = 0;
    }

    @Override
    public void display() {
        Node currentData = front;//从队首开始遍历
        int index = 0;//
        while (currentData!=null){
            //打印
            index++;
            System.out.println("------"+index+"queue currentData:"+currentData.data);
            currentData = currentData.next;
        }
    }
}
