package com.gd.business.service.impl;

import com.gd.business.service.IAsyncService;
import com.gd.common.multids.ContextConst;
import com.gd.common.multids.DataSource;
import com.gd.business.dao.InfoMapper;
import com.gd.business.service.IInfoService;

import com.gd.common.exception.ServiceErrorException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author:CodeGenerator
 * @Date:2020/04/07.
 */
@Service
@Log
@Transactional(rollbackFor = ServiceErrorException.class)
public class InfoServiceImpl implements IInfoService {
    @Resource
    private InfoMapper infoMapper;

    @Autowired
    private IAsyncService asyncService;

    @DataSource(ContextConst.DataSourceType.TWO)
    @Override
    public String getInfo(Integer id) {
        log.info("currentThread:" + Thread.currentThread().getName());
        asyncService.sendLog("task");
        return infoMapper.selectByPrimaryKey(id).getValue();
    }
}
