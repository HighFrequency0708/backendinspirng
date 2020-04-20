package com.gd.business.rest;

import com.gd.common.pojo.APIResult;
import com.gd.common.pojo.ResultGenerator;
import com.gd.business.pojo.User;
import com.gd.business.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date:2020/04/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping()
    public String user(){
        return userService.getUser(1).getName();
    }

}
