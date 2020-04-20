package com.gd.common.multids;

import lombok.extern.java.Log;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源路由实现类
 */
@Log
public class DynamicDataSource extends AbstractRoutingDataSource {
    
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContextHolder.getDataSource();
        if (dataSource == null) {
            log.info("当前为默认数据源");
        } else {
            log.info("当前数据源：" + dataSource);
        }
        return dataSource;
    }
}
