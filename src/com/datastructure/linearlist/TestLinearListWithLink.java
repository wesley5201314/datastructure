package com.datastructure.linearlist;

/**
 * Created by wesley on 2016/11/29.
 */
public class TestLinearListWithLink {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.append("a");
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        linkedList.append("b");
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        linkedList.append("c");
        linkedList.append("d");
        linkedList.append("f");
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        linkedList.insert(5,"e");
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        linkedList.insert(7,"g");
        System.out.println("----"+linkedList.get(5)+"---"+linkedList.length()+"toString:"+linkedList.toString());
        linkedList.set(5,"gg");
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        linkedList.remove(2);
        System.out.println(linkedList.length()+"toString:"+linkedList.toString());
        System.out.println("---search---"+linkedList.search("gg"));
        linkedList.removeAll();
    }
}
