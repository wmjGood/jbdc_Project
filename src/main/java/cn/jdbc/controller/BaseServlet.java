package cn.jdbc.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    /*
    *
    * 所有的子类servlet都要继承baseServlet
    * */
    public  abstract  Class getServletClass();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //在jsp页面携带的参数   通过传过来的参数判断执行那个方法
        String methodName=request.getParameter("methodName");
        //指定的方法
        Method method=null;
        //执行方法的返回值，因为你不能判断返回的结果是什么类型
        //但不管返回的什么结果都是Object的子类
        Object result=null;

        //判断传过来的methodName是否为空，如果为空就说明没有返回值
        //不为空就说明有方法
        if(methodName==null || "".equals(methodName)){
            //methodName为空，直接返回主页
            result=excute(request,response);
        }else{
            //methodName不为空的话，就找到根据与methodName找到对应子类中的方法
            try {
                method=getServletClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
               //执行方法

                result=method.invoke(this,request,response);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        //根据返回的结果不同，返回不同的操作
        toView(request,response,result);

    }
    //根据返回的结果不同，返回不同的操作   result返回的结果

    private void toView(HttpServletRequest request, HttpServletResponse response, Object result) {
       //判断是否有返回结果
        if (result==null){
            System.out.println("没有返回值");
        }else{
            //有返回结果  1.返回字符串类型，跳转页面
            //2.返回JSON类型，不用跳转页面
            //判断result是什么类型
            if(result instanceof  String ){
                //返回的值
                String viewName=request.toString()+".jsp";
                try {
                   //转发到页面
                    request.getRequestDispatcher(viewName).forward(request,response);

                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{//返回JSON
                //转换成String类型
                String resultJSON= JSON.toJSONString(result);
                //将结果返回去
                PrintWriter writer= null;
                try {
                    writer = response.getWriter();
                    writer.write(resultJSON);
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //返回主页面的方法
    private Object excute(HttpServletRequest request, HttpServletResponse response) {
         return  "index";  //你的主页面是什么名字就写什么名字
    }
}
