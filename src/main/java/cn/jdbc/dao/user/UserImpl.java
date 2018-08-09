package cn.jdbc.dao.user;

import cn.jdbc.bean.Users;
import cn.jdbc.util.BaseDaoUtil;
import cn.jdbc.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public class UserImpl extends BaseDaoUtil implements  UserDao {
   /*
   * 注册功能
   * */
    @Override
    public int add(Users users) {
        String sql="INSERT INTO news_userinfo(uname,upwd) \n" +
                    "   VALUES(?,?)";
        Object [] objects={users.getUname(),users.getUpwd()};
        int count = executeUpdate(sql, objects);
        return count;
    }

    @Override
    public int deleteByCondition(Serializable t) {
        return 0;
    }

    @Override
    public int updateByCondition(Users users) {
        return 0;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findByCondition(Serializable t) {
        return null;
    }

    @Override
    public int totalRows() {
        return 0;
    }

    @Override
    public List<Users> findAllPage(PageUtil util, Object... objects) {
        return null;
    }
}
