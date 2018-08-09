package cn.jdbc.service;

import cn.jdbc.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    //添加方法
    int add(T t);
    //删除方法  按条件
    int deleteByCondition(Serializable t);
    //修改方法  按条件
    int updateByCondition(T t);
    //查询所有信息
    List<T> findAll();
    //按条件查询
    T findByCondition(Serializable t);
    //查询总记录数
    int totalRows();
    //查询分页的数据
    List<T> findAllPage(PageUtil util, Object...objects);
}
