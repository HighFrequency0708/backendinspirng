package com.gd.common.pojo;


import com.gd.common.consts.ConstantUtil;

import java.util.List;


/**
 * @author 作者 yuansf
 * @version 创建时间：2016年7月13日 下午3:10:09
 * 类说明
 */
public class PageParam<T> {

    private T param;

    private Integer pageIndex;

    private Integer pageSize;

    private List<Long> ids;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize == null ? ConstantUtil.PAGE_SIZE : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
