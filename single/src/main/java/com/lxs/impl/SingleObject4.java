package com.lxs.impl;

import com.lxs.inter.SingleObject;
import com.lxs.util.Show;

/**
 * Created by carry on 17-3-20.
 * 双重校验锁
 * JDK 版本：JDK1.5 起
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class SingleObject4 implements SingleObject {
    private volatile static SingleObject4 instance;

    private SingleObject4() {
    }

    public static SingleObject4 getInstance() {
        if (instance == null) {
            synchronized (SingleObject4.class) {
                if (instance == null) {
                    instance = new SingleObject4();
                }
            }
        }
        return instance;
    }

    @Override
    public void showMessage(String s) {
        Show.showMessage(s);
    }
}
