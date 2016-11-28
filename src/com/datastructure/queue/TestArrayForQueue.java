package com.datastructure.queue;

/**
 * Created by wesley on 2016/11/28.
 */
public class TestArrayForQueue {

    public static void main(String[] args){
        ArrayForQueue queue = new ArrayForQueue();
        System.err.println("queue data size:"+queue.size());
        queue.append(1);
        System.out.println("front data:"+queue.front());
        System.out.println("queue data size:"+queue.size());
        queue.append(2);
        queue.append(3);
        queue.append(4);
        System.out.println("front data:"+queue.front());
        System.out.println("queue data size:"+queue.size());
        queue.display();
        queue.remove();
        System.out.println("front data:"+queue.front());
        System.out.println("queue data size:"+queue.size());
        queue.display();
    }
}
