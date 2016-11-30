package com.datastructure.linearlist;

/**
 * Created by wesley on 2016/11/29.
 */
public class TestLinearList {

    public static void main(String[] args){
        /*ArrayForLinearList arrayForLinearList = new ArrayForLinearList();
        arrayForLinearList.add(1);
        arrayForLinearList.display();
        System.out.println("-----");
        arrayForLinearList.add(2);
        arrayForLinearList.add(3);
        arrayForLinearList.display();
        System.out.println("-----");
        arrayForLinearList.insert(2,22);
        arrayForLinearList.display();
        System.out.println("-----");
        arrayForLinearList.delete(3);
        arrayForLinearList.display();
        System.out.println("-----");*/
        SequenceList sequenceList = new SequenceList();
        sequenceList.append("a");
        sequenceList.display();
        System.out.println(sequenceList.length()+"toString:"+sequenceList.toString());
        sequenceList.append("b");
        sequenceList.display();
        System.out.println(sequenceList.length()+"toString:"+sequenceList.toString());
        sequenceList.append("c");
        sequenceList.append("d");
        sequenceList.append("f");
        sequenceList.display();
        System.out.println(sequenceList.length()+"toString:"+sequenceList.toString());
        sequenceList.insert(4,"e");
        sequenceList.insert(5,"g");
        sequenceList.insert(7,"h");
        System.out.println("----"+sequenceList.get(7)+"---"+sequenceList.length()+"toString:"+sequenceList.toString());
        sequenceList.set(5,"gg");
        sequenceList.display();
        System.out.println(sequenceList.length()+"toString:"+sequenceList.toString());
        sequenceList.remove(2);
        sequenceList.display();
        System.out.println(sequenceList.length()+"toString:"+sequenceList.toString());
        System.out.println("---search---"+sequenceList.search("a"));

    }
}
