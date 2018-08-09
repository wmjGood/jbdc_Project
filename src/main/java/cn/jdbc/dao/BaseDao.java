package cn.jdbc.dao;




//每个dao中都有相同的增删改查方法，所以提取一个公共类

import cn.jdbc.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
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
    List<T> findAllPage(PageUtil util,Object...objects);
}
