package com.gd.business.rest;

import com.gd.business.pojo.Product;
import com.gd.business.service.IInfoService;
import com.gd.common.pojo.APIResult;
import com.gd.common.pojo.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:CodeGenerator
 * @Date:2020/04/07.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public APIResult<List<Product>> getInfo(){
        List<Product> products = new ArrayList<Product>();
        products.add(Product.builder().id(1).name("iphone se").price(new BigDecimal(3299.00)).build());
        products.add(Product.builder().id(2).name("xiao mi").price(new BigDecimal(3999.00)).build());
        return ResultGenerator.getSuccessResult(products);
    }

}
