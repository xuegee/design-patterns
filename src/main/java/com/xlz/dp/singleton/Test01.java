package com.xlz.dp.singleton;

/**
 * <p>className: Test01</p>
 * <p>单例模式：饿汉模式 类加载到内存后，就实例化一个单例，JVM保证线程安全
 *      static 启动就直接加载到内存，不使用就会浪费资源
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 16:05
 */
public class Test01 {

    //私有构造函数 防止外界new对象
    private Test01(){}
    //使用static 加载创建对象
    private static final Test01 test = new Test01();

    //提供获取对象方法
    private static Test01 getInstance(){
        return test;
    }


    public static void main(String[] args) {

        Test01 test1 = Test01.getInstance();
        Test01 test2 = Test01.getInstance();
        Test01 test3 = null;
        try {
            test3 = Test01.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //true
        System.out.println(test1==test2);
        //false
        System.out.println(test1==test3);

    }

}