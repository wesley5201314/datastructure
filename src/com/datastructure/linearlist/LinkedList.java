package com.datastructure.linearlist;

/**
 * Created by wesley on 2016/11/30.
 * 链式实现线性表
 *
 * @author wesley
 */
public class LinkedList<T> implements LList<T> {

    //Node定义一个节点类
    private static class Node<T> {
        private T data; ////数据域，保存数据元素
        private Node<T> next; //类似指针 地址域，引用后继结点

        Node() {
            this(null, null);
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /****************
     * 构造链表
     **************************/

    private Node<T> head; //头指针，指向单链表的头结点

    //默认构造方法，构造空链表，创建头结点，data和next均为null
    public LinkedList() {
        this.head = new Node<T>();
    }

    //由指定的数组中的多个对象构造单链表，采用尾插法
    public LinkedList(T[] elements) {
        this();//创建空链表
        Node<T> rear = this.head;    //rear指向单链表的最后一个结点
        for (int i = 0; i < elements.length; i++) {
            rear.next = new Node<T>(elements[i], null);  //尾插入，创建结点链入rear结点之后
            rear = rear.next;                //rear指向新的链尾结点
        }
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    /**
     * 返回单链表的长度
     *
     * @return
     */
    @Override
    public int length() {
        int i = 0;
        Node<T> p = this.head;
        while (p.next != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    /**
     * 获取第i元素
     *
     * @param i
     * @return
     */
    @Override
    public T get(int i) {
        if (i >= 0) {
            Node<T> p = this.head.next;  //第一个结点
            for (int j = 0; p.next != null && j < i - 1; j++) {
                p = p.next;
            }
            if (p.next != null) {
                return p.data;
            }
        }
        return null;
    }

    @Override
    public void set(int i, T x) {
        if (x == null) {
            return;
        }
        if (i >= 0) {
            Node<T> p = this.head.next; //第一个结点
            for (int j = 0; p.next != null && j < i - 1; j++) {
                p = p.next;
            }
            if (p.next != null) {
                p.data = x;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * 将x对象插入在序号为i结点前
     *
     * @param i
     * @param x
     */
    @Override
    public void insert(int i, T x) {
        if (x == null) {
            return;
        }
        Node<T> p = this.head;  //头结点
        for (int j = 0; p.next != null && j < i - 1; j++) {
            p = p.next;           //定位到i结点的前驱结点
        }
        p.next = new Node<T>(x, p.next);
    }

    /**
     * 添加元素
     * @param x
     */
    @Override
    public void append(T x) {
        this.insert(Integer.MAX_VALUE, x);
    }

    /**
     * 将第i个结点的元素删除
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {
        if (i >= 0) {
            Node<T> p = this.head;   //头结点
            for (int j = 0; p.next != null && j < i - 1; j++) {
                p = p.next;             //定位到待删除结点的前驱结点
            }
            if (p.next != null) {
                T d = p.next.data;
                p.next = p.next.next;
                return d;
            }
        }
        return null;
    }

    /**
     * 移除所有的元素
     */
    @Override
    public void removeAll() {
        this.head = null;//设置头结点为空 便于GC回收
    }

    @Override
    public T search(T key) {
        //从第一个结点开始遍历搜索
        Node current = this.head.next;
        //遍历链表
        while (current != null) {
            //判断当前结点值是否等于参数值
            if (current.data.equals(key)) {
                return (T) current.data;
            }
            //指向下一个节点
            current = current.next;
        }
        return (T) current;
    }

    public String toString() {
        String str = "(";
        Node<T> p = this.head.next;
        while (p != null) {
            str += p.data.toString();
            if (p.next != null) {
                str += ",";
            }
            p = p.next;
        }
        return str + ")";
    }
}
