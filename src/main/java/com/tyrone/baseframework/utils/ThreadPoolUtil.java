package com.tyrone.baseframework.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: baseframework
 * @description: 全局单例线程池
 * @author: Tyrone
 * @create: 2020-06-17 14:23
 **/
public enum ThreadPoolUtil {
    /**
     * Description:定义实例，实际上是类的一个实例，可以调用枚举中的方法
     *
     * @param null
     * @return:
     * @Author: Tyrone
     * @date: 2020/6/17
     **/
    SINGLETON;

    private final ExecutorService es;

    ThreadPoolUtil() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("topChivesRise-global-pool-%d").build();
        //Common Thread Pool
        es  = new ThreadPoolExecutor(10, 100,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(200), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * Description:共有方法，或去单例的实例
     * @param
     * @return: java.util.concurrent.ExecutorService
     * @Author: Tyrone
     * @date: 2020/6/17
     **/
    public ExecutorService getInstance() {
        return es;
    }
}
