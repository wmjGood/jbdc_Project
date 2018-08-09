package cn.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {


  private  static ConfigManager configManager;
    //properties对象  专门解析properties文件
  private static Properties properties;

  static {
      String path="jdbc.properties";
      properties=new Properties();
      InputStream is =ConfigManager.class.getClassLoader().getResourceAsStream(path);
      try {
           properties.load(is);
      } catch (IOException e) {
          e.printStackTrace();
      }finally {
          try {
              is.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

  }


  //对外访问接口

    public  static synchronized   ConfigManager getInstence(){
      return  configManager;
    }

    //根据获取的properties文件的key获取value
    public static String getValue(String key){
      return  properties.getProperty(key);
    }

}
