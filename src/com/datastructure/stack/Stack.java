package com.datastructure.stack;

/**
 * Created by wesley on 2016/11/23.
 * 栈的基类
 * @author wesley
 *
 */
public interface Stack<T> {

    /**
     * 入栈
     * @param t
     */
    public void push(T t);

    /**
     * 出栈
     */
    public T pop();

    /**
     * 显示栈中的数据
     */
    public void display();

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 栈是否满了
     * @return
     */
    public boolean isFull();

    /**
     * 栈的长度
     * @return
     */
    public int size();

    /**
     * 返回栈顶元素
     * @return
     */
    public T peek();

    /**
     * 清空栈
     */
    public void clear();
}
