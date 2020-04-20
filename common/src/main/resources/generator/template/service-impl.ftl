package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;

import ${basePackageFrame}.exception.ServiceErrorException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @Author:${author}
 * @Date:${date}.
 */
@Service
@Transactional(rollbackFor = ServiceErrorException.class)
public class ${modelNameUpperCamel}ServiceImpl implements I${modelNameUpperCamel}Service {
    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
