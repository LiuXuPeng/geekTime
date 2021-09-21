package com.geekTime.learn.loadClass;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;



public class MyClassLoader extends ClassLoader{

    // 文件后缀
    private final String suffix = ".xlass";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(name + suffix);
        try {
            // 读取数据
            int length = inputStream.available();
            byte[] byteArray = new byte[length];
            inputStream.read(byteArray);
            // 转换
            byte[] classBytes = decode(byteArray);
            // 通知底层定义这个类
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static byte[] decode(byte[] byteArray) {
        byte[] targetArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            targetArray[i] = (byte) (255 - byteArray[i]);
        }
        return targetArray;
    }

    public static void main(String[] args) throws Exception{
        ClassLoader myClassLoader = new MyClassLoader();
        Class<?> clazz = myClassLoader.loadClass("Hello");

        // 创建对象
        Object instance = clazz.getDeclaredConstructor().newInstance();
        for (Method m : clazz.getDeclaredMethods()) {
            // 调用实例方法
            Method method = clazz.getMethod(m.getName());
            method.invoke(instance);
        }




    }
}
