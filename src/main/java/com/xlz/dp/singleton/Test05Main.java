package com.xlz.dp.singleton;

import java.io.*;

/**
 * <p>className: Test05Main</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 17:55
 */
public class Test05Main {

    public static void main(String[] args) {
        Test05 test1 = Test05.getInstance();
        Test05 test2 = null;

        try {
            FileOutputStream fos = new FileOutputStream("fos.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(test1);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("fos.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            test2 = (Test05) ois.readObject();

            System.out.println(test1 == test2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}