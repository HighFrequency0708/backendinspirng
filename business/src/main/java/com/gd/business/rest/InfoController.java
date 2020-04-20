package com.gd.business.rest;

import com.gd.common.pojo.APIResult;
import com.gd.common.pojo.ResultGenerator;
import com.gd.business.pojo.Info;
import com.gd.business.service.IInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:CodeGenerator
 * @Date:2020/04/07.
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Resource
    private IInfoService infoService;

    @GetMapping()
    public String getInfo(){
        return infoService.getInfo(1);
    }

}
