package com.gd.business.rest;

import com.gd.business.pojo.User;
import com.gd.business.service.IUserService;
import com.gd.common.auth.RestAuth;
import com.gd.common.pojo.APIResult;
import com.gd.common.pojo.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:CodeGenerator
 * @Date:2020/04/07.
 */
@RestController
@RequestMapping(value = "login", produces = {"text/html;charset=UTF-8;","application/json;"})
public class LoginController {

    private static final String DEMO_NAME = "andrew";

    private static final String DEMO_PASSWORD = "12345678";

    @PostMapping()
    public APIResult<Map<String, Object>> login(@RequestBody Map<String, String> body){
        if (DEMO_NAME.equals(body.get("name")) && DEMO_PASSWORD.equals(body.get("password"))) {
            Map<String, Object> mapResult = new HashMap<>();

            mapResult.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
            return ResultGenerator.getSuccessResult(mapResult);
        } else {
            return ResultGenerator.getFailResult("username or password error!");
        }
    }

}
