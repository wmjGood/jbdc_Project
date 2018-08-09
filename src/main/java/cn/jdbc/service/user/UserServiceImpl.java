package cn.jdbc.service.user;

import cn.jdbc.bean.Users;
import cn.jdbc.dao.user.UserDao;
import cn.jdbc.dao.user.UserImpl;
import cn.jdbc.util.BaseDaoUtil;
import cn.jdbc.util.PageUtil;

import javax.servlet.http.HttpServlet;
import java.io.Serializable;
import java.util.List;

public class UserServiceImpl extends BaseDaoUtil implements  UserService {

/**
 * 注册功能
 *
 */


   private UserDao userDao=new UserImpl();

    @Override
    public int add(Users users) {
        return userDao.add(users);
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
