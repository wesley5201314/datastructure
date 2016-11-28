package com.datastructure.queue;

/**
 * Created by wesley on 2016/11/28.
 */
public interface Queue<T> {

    /**
     * 入队：从队尾加入一个元素
     * @param t
     */
    public void append(T t);
    /**
     * 出队：移走队头元素并返回
     * @return 当前队头元素
     */
    public T remove();
    /**
     * 当前队列的元素个数
     * */
    public int size();
    /**
     * 判断当前队列是否为空
     * @return
     */
    public boolean isEmpty();
    /**
     * 只是返回队头元素，并未删掉
     * @return t*/
    public T front();

    /**
     * 清空队列
     */
    public void clear();

    /**
     * 显示队列数据
     */
    public void display();

}
