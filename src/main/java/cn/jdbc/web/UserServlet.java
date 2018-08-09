package cn.jdbc.web;

import cn.jdbc.bean.Users;
import cn.jdbc.controller.BaseServlet;
import cn.jdbc.service.ServiceFactory;
import cn.jdbc.service.user.UserService;
import cn.jdbc.service.user.UserServiceImpl;
import cn.jdbc.util.Md5Encrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/UserServlet")
public class UserServlet  extends BaseServlet{

    private  UserService userService;
    @Override
    public void init() throws ServletException {
        userService= (UserService) ServiceFactory.getServiceImpl("userService");
    }


    @Override
    public Class getServletClass() {
        return UserServlet.class;
    }





    public  String register(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users users=new Users();
        users.setUname(username);
        try {

            users.setUpwd(Md5Encrypt.getEncryptedPwd(password));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int count = userService.add(users);
        if (count>0){
            return "index";
        }else{
            return "register";
        }
    }



}
