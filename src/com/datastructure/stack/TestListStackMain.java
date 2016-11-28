package com.datastructure.stack;

/**
 * Created by wesley on 2016/11/23.
 */
public class TestListStackMain {

    public static void main(String[] args){
        ListForStack stack = new ListForStack();
        System.out.println("init stack size:"+stack.size());
        stack.push("1");
        System.out.println("1 put value to stack size:"+stack.size());
        stack.display();
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println("2 put value to stack size:"+stack.size());
        stack.display();
        stack.push("6");
        System.out.println("3 put value to stack size:"+stack.size());
        stack.display();
        //栈顶元素出栈
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        stack.display();
        System.out.println("out stack length:"+stack.size());
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        System.out.println("top value【"+stack.peek()+"】out stack");
        stack.pop();
        System.out.println("out full length:"+stack.size());
        ListForStack listForStack = new ListForStack();
        Long currentTime = System.currentTimeMillis();
        for( int i = 0 ; i < 1000000 ; i++){
            listForStack.push(String.valueOf(i));
        }
        System.out.println("listForStack time:"+(System.currentTimeMillis()-currentTime));
        listForStack.clear();
        listForStack.display();
    }
}
