package com.datastructure.stack;

/**
 * Created by wesley on 2016/11/23.
 */
public class TimeForStack {
    public static void main(String[] args){
        System.err.println("----java three stack execution time---");
        ListForStack listForStack = new ListForStack();
        Long listCurrentTime = System.currentTimeMillis();
        for( int i = 0 ; i < 1000000 ; i++){
            listForStack.push(String.valueOf(i));
        }
        System.out.println("listForStack push execution time:"+(System.currentTimeMillis()-listCurrentTime));

        LinkedForStack linkedForStack = new LinkedForStack();
        Long linkedCurrentTime = System.currentTimeMillis();
        for( int i = 0 ; i < 1000000 ; i++){
            linkedForStack.push(String.valueOf(i));
        }
        System.out.println("linkedForStack push execution time:"+(System.currentTimeMillis()-linkedCurrentTime));

        ArrayForStack arrayForStack = new ArrayForStack();
        Long arrayCurrentTime = System.currentTimeMillis();
        for( int i = 0 ; i < 1000000 ; i++){
            arrayForStack.push(String.valueOf(i));
        }
        System.out.println("arrayForStack push execution time:"+(System.currentTimeMillis()-arrayCurrentTime));
    }
}
