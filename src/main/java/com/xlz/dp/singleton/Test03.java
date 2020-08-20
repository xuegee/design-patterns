package com.xlz.dp.singleton;

/**
 * <p>className: Test03</p>
 * <p>description: 使用静态内部类来解决反射破坏单例模式 但是还是会被序列化破坏
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 16:52
 */
public class Test03 {

    private Test03(){
        if(Test0303.innerTest03!=null){
            throw new RuntimeException("此路不通了！");
        }
    }

    public static Test03 getInstance(){
        return Test0303.innerTest03;
    }

    public static class Test0303{
        //使用静态属性创建外部类对象
        public static Test03 innerTest03 = new Test03();
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->
                    System.out.println(Test03.getInstance().hashCode())
            ).start();
        }
        try {
            //使用反射已被限制
            Test03 test03 = Test03.class.newInstance();
            System.out.println("--------"+test03.hashCode());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}