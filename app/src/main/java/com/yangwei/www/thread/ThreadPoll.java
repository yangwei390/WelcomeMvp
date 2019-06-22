package com.yangwei.www.thread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoll {
    private static ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoll() {
        if (threadPoolExecutor == null) {
            synchronized (ThreadPoll.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                            2, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardOldestPolicy());
                }
            }
        }
    }

    public void start(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }
}
