package com.gd.business.service.impl;

import com.gd.business.dao.UserMapper;
import com.gd.business.pojo.User;
import com.gd.business.service.IUserService;

import com.gd.common.exception.ServiceErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author:CodeGenerator
 * @Date:2020/04/07.
 */
@Service
@Transactional(rollbackFor = ServiceErrorException.class)
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
