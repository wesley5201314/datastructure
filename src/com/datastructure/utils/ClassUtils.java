package com.datastructure.utils;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by wesley on 2016/11/29.
 * 扫描包工具类
 * @author wesley
 */
public class ClassUtils {

    public static final List<Class<?>> getAllClassOfPackage(String packageName) {
        List<Class<?>> list = new ArrayList<>();
        if (StringUtils.isBlank(packageName)) {
            return list;
        }
        //获取当前线程上下文类加载器
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            //获取当前类加载器中的class所有的地址
            ClassPath classPath = ClassPath.from(loader);
            //然后根据包名获取需要的class信息
            ImmutableSet<ClassPath.ClassInfo> classInfos = classPath.getTopLevelClasses(packageName);
            //循环添加到返回值中
            for (ClassPath.ClassInfo classInfo : classInfos) {
                String className = classInfo.getName();
                list.add(Class.forName(className));
            }
        } catch (Throwable t) {
            System.err.println("---error---"+t.getMessage());
        }
        return list;
    }
}
