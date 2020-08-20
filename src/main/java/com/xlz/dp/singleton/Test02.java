package com.xlz.dp.singleton;

/**
 * <p>className: Test02</p>
 * <p>description: 单例模式：懒汉模式
 *                 使用的时候创建对象,但是也因为有多线程导致了线程不安全
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 16:13
 */
public class Test02 {
    //私有构造函数防止new
    private Test02(){}
    //声明对象
    private static Test02 INSTANCE;
    //提供类对象 多线程不安全
    private static Test02 getInstance(){
        if(INSTANCE==null){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Test02();
        }
        return INSTANCE;
    }

    //提供类对象，使用synchronized锁，并且需要双重验证才可以保证线程安全
    private static Test02 getInstanceBySingle(){
        if(INSTANCE==null){
            synchronized (Test02.class){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Test02();
            }
        }
        return INSTANCE;
    }

    //提供类对象，使用synchronized锁，并且需要双重验证才可以保证线程安全
    //第一个if判断null为了提升处理速度如果不为null直接返回已有对象，第二个if判断null为了防止多线程创建多个实例
    private static Test02 getInstanceByDouble(){
        if(INSTANCE==null){
            synchronized (Test02.class){
                if(INSTANCE==null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Test02();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i=0;i<10;i++){
            new Thread(()->
                    System.out.println(Test02.getInstanceByDouble().hashCode())
                    ).start();
        }

    }


}