package com.gd.common.utils.date;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 高并发场景下System.currentTimeMillis()的性能优化
 *
 * @author Onpu
 * @date 2019-04-01
 */
public class SystemClock {

    private final long period;

    private final AtomicLong now;

    private static SystemClock instance = new SystemClock();

    public static SystemClock getInstance() {
        return instance;
    }

    private SystemClock() {
        this.period = 1;
        this.now = new AtomicLong(System.currentTimeMillis());
        init();
    }

    private void init() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(
                1, new BasicThreadFactory.Builder().namingPattern("SystemClock").daemon(true).build());
        executorService.scheduleAtFixedRate(() ->
                now.set(System.currentTimeMillis()), period, period, TimeUnit.MILLISECONDS);
    }

    public static long currentTimeMillis() {
        return getInstance().now.get();
    }
}
