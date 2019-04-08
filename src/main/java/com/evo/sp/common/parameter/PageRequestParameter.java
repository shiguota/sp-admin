package com.evo.sp.common.parameter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evo.sp.common.ex.SpAssert;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-04-08 11:22
 */
public class PageRequestParameter<T> {
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页行数
     */
    private Integer size;
    /**
     * 查询参数
     */
    private T parameter;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }

    public PageRequestParameter() {
    }


    public PageRequestParameter(Integer page) {
        this.page = page;
    }

    public PageRequestParameter(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public PageRequestParameter(Integer page, Integer size, T parameter) {
        this.page = page;
        this.size = size;
        this.parameter = parameter;
    }

    /**
     *
     * 获取ipage实例
     */
    public IPage pageInstance() {
        return new Page(this.page, this.size);
    }
    /**
     *
     * 分页查询所需参数
     */
    public T parameterInstance(){
        if(SpAssert.isNotNull(parameter)){
            return parameter;
        }else{
            return null;
        }
    }
}
