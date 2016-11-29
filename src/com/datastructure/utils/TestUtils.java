package com.datastructure.utils;

import java.util.List;

/**
 * Created by wesley on 2016/11/29.
 * @author wesley
 */
public class TestUtils {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("------scan package-----start");
        List<Class<?>> classInfos = ClassUtils.getAllClassOfPackage("com.datastructure.queue");
        for (Class<?> classInfo : classInfos) {
            String className = classInfo.getName();
            System.err.println("-classname-"+className);
        }
    }
}
