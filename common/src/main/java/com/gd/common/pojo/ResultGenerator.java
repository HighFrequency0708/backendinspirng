package com.gd.common.pojo;

import com.gd.common.consts.ConstantUtil;
import com.gd.common.consts.ResultPacketCode;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhuys
 */
public class ResultGenerator {

    /**
     * 成功返回
     */
    public static APIResult<Void> success() {
        APIResult<Void> result = new APIResult<>();
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        return result;
    }

    /**
     * 成功返回(返回数据)
     *
     * @param object 返回数据
     */
    public static <T> APIResult<T> success(T object) {
        APIResult<T> result = new APIResult<>();
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        result.setResult(object);
        return result;
    }

    /**
     * 成功返回分页(返回数据)
     *
     * @param object 返回数据
     */
    public static <T> APIResult<T> success(T object, PageInfo pageInfo) {
        APIResult<T> result = new APIResult<>();
        Pager pager = new Pager((int) pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.isIsLastPage());
        result.setPager(pager);
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        result.setResult(object);
        return result;
    }

    /**
     * 成功不含参
     */
    public static APIResult getSuccessResult() {
        APIResult result = new APIResult<>();
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        return result;
    }

    /**
     * 成功含返回数据
     */
    public static APIResult getSuccessResult(Object data) {
        APIResult result = new APIResult();
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        result.setResult(data);
        return result;
    }

    /**
     * 成功含返回分页列表
     *
     * @return
     */
    public static APIResult<List> getSuccessResult(PageInfo pageInfo) {
        APIResult<List> result = new APIResult<>();
        Pager pager = new Pager();
        pager.setRecordSize(((int) pageInfo.getTotal()));
        pager.setPageIndex(pageInfo.getPageNum());
        pager.setIsEnd(pageInfo.isIsLastPage());
        result.setPager(pager);
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        result.setResult(pageInfo.getList());
        return result;
    }

    /**
     * 成功返回数据包含分页信息
     */
    public static APIResult getSuccessPagerResult(Object data, long recordSize, Boolean isEnd) {
        APIResult result = new APIResult<>();
        result.setPager(new Pager((int) recordSize, isEnd));
        result.setResult(data);
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        return result;
    }

    /**
     * 失败含报错信息
     */
    public static APIResult getFailResult(String message) {
        APIResult result = new APIResult<>();
        result.setMessage(message);
        result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
        return result;
    }

    /**
     * 失败含报错信息以及数据
     */
    public static APIResult getFailResult(Object data, String message) {
        APIResult result = new APIResult();
        result.setResult(data);
        result.setMessage(message);
        result.setCode(ResultPacketCode.APIResultCode.Fail.getCode());
        return result;
    }

    /**
     * 1对多自写分页返回方式封装
     * @param data
     * @param pageIndex
     * @param count
     * @return
     */
    public static APIResult getPagerResult(List data, int pageIndex ,int count) {
        APIResult result = new APIResult();
        result.setResult(data);
        result.setCode(ResultPacketCode.APIResultCode.Success.getCode());
        Pager pager = new Pager();
        pager.setIsEnd(count - (pageIndex-1) * ConstantUtil.PAGE_SIZE <= ConstantUtil.PAGE_SIZE);
        pager.setRecordSize(count);
        pager.setPageIndex(pageIndex);
        pager.setPageSize(ConstantUtil.PAGE_SIZE);
        result.setPager(pager);
        return result;
    }
}
