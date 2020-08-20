package com.xlz.dp.singleton;

/**
 * <p>enumName: Test05</p>
 * <p>description: TODO</p>
 *
 * @author XUELIANZENG
 * @version 1.0.0
 * @date 2020-08-20 17:48
 */
public enum Test05 {
    INSTANCE;
    private  Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static Test05 getInstance(){
        return INSTANCE;
    }
}
