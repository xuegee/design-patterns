package com.xlz.dp.singleton;

import java.io.*;

/**
 * <p>className: Test04</p>
 * <p>description: 序列化破坏单例模式
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 17:11
 */
public class Test04 implements Serializable {

    private Test04(){}

    private static final Test04 test = new Test04();

    public static Test04 getInstance(){
        return test;
    }

    public static void main(String[] args) {
        Test04 test1 = Test04.getInstance();
        Test04 test2 = null;

        try {
            FileOutputStream fo = new FileOutputStream("fo.obj");
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(test1);
            os.flush();
            os.close();

            FileInputStream fi = new FileInputStream("fo.obj");
            ObjectInputStream ois = new ObjectInputStream(fi);
            test2 =(Test04) ois.readObject();
            ois.close();
            //false 序列化后 反序列化得到的对象并非源对象
            System.out.println(test1 == test2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //增加该方法后 输出true
    private Object readResolve(){
        return test;
    }

}