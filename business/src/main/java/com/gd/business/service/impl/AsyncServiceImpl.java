package com.gd.business.service.impl;

import com.gd.business.service.IAsyncService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Log
public class AsyncServiceImpl implements IAsyncService {

    @Async
    @Override
    public void sendLog(String info) {
        log.info("currentThread:" + Thread.currentThread().getName());


    }
}
