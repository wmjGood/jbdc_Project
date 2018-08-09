package cn.jdbc.service;

import cn.jdbc.service.user.UserServiceImpl;

import javax.servlet.ServletException;

public class ServiceFactory {
    private  static  ServiceFactory factory;

    private  ServiceFactory (){

    }

    static {
        if (factory==null){
            synchronized (ServiceFactory.class){
                if (factory==null){
                    factory=new ServiceFactory();
                }
            }
        }
    }


    public  static  BaseService getServiceImpl(String serviceName) {
        BaseService baseService=null;
        switch (serviceName){
            case "userService":
                baseService= new UserServiceImpl();
                default:
                    break;
        }
        return  baseService;
    }
}
