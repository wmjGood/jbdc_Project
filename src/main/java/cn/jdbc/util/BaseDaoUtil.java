package cn.jdbc.util;

import java.sql.*;

public class BaseDaoUtil {
    private static Connection  con;
    private  static PreparedStatement ps;
    private  static ResultSet rs;


    //连接数据库
    public boolean getConnection() {
        try {
            Class.forName(ConfigManager.getValue("jdbc.driver"));
            if(con==null){
                con= DriverManager.getConnection(ConfigManager.getValue("jdbc.url"),
                        ConfigManager.getValue("jdbc.username"),
                        ConfigManager.getValue("jdbc.password"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  false;
        } catch (SQLException e) {
            e.printStackTrace();
            return  false;
        }
        return true;
    }

    //释放资源
    public  void  CloseConnection(){
        try {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (con!=null){
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//进行增删改操作
    public  int executeUpdate(String sql,Object...objects){
        int count=0;
        if (getConnection()){
            try {
                ps=con.prepareStatement(sql);
                if (objects!=null){
                    for (int i = 0; i <objects.length ; i++) {
                        ps.setObject(i+1,objects[i]);
                    }
                }
                count=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  count;
    }
//进行查询操作
    public  ResultSet executeQuery(String sql,Object...objects){
      if (getConnection()){
            try {
                ps=con.prepareStatement(sql);
                if (objects!=null){
                    for (int i = 0; i <objects.length ; i++) {
                        ps.setObject(i+1,objects[i]);
                    }
                }
               rs=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  rs;
    }
}
