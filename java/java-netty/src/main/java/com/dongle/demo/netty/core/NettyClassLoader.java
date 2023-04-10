package com.dongle.demo.netty.core;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NettyClassLoader extends ClassLoader {

    private static final List<Class<?>> LIST_CLASS = new ArrayList<>();

    private static String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();


    private static List<Class<?>> getAllClasses(File file, List<Class<?>> classes) throws ClassNotFoundException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f : files) {
                getAllClasses(f, classes);
            }
        } else {
            if (file.getName().endsWith(".class")) {
                String className = file.getPath().replace(".class","").replace(classPath.replace("/","\\").substring(1),"").replace("\\",".");
                classes.add(Class.forName(className));
            }
        }
        return classes;
    }

    private static List<Class<?>> getAllClasses() throws ClassNotFoundException {
        List<Class<?>> list = new ArrayList<>();
        getAllClasses(new File(classPath), list);
        return list;
    }

    private static List<Class<?>> getAllClasses(String path) throws ClassNotFoundException {
        List<Class<?>> list = new ArrayList<>();
        getAllClasses(new File(path), list);
        return list;
    }

    public List<Class<?>> findClassByAnnotation(Class<?> cls){
        List<Class<?>> classList = new ArrayList<>();
        try {
            List<Class<?>> allClasses = getAllClasses();
            for (Class<?> cl:allClasses){
                Annotation[] annotations = cl.getAnnotations();
                for(Annotation annotation:annotations){
                    if (annotation.getClass().getName().equals(cls.getName())){
                        classList.add(cl);
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return classList;
    }
}
