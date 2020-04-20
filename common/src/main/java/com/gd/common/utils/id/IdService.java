package com.gd.common.utils.id;

/**
 * ID生成接口
 *
 * @author CAC
 * @date 2019-04-06
 */
public interface IdService {

    /**
     * 生成id
     *
     * @return
     */
    long nextId();

    /**
     * 启用zookeeper注册workerId时有效,用于刷新workerId
     */
    void refreshWorkerId();
}
