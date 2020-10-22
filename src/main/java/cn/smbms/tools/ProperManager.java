package cn.smbms.tools;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProperManager {

    private static ProperManager properManager;
    Properties properties;

    private ProperManager(){
        properties=new Properties();
        String configFile="database.properties";
        InputStream is=ProperManager.class.getResourceAsStream(configFile);
        try {
            properties.load(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public synchronized static ProperManager getInstance(){
        if (properManager==null){
            properManager=new ProperManager();
        }
        return properManager;
    }

        public String getValueByKey(String key){
        return properties.getProperty(key);
        }


}
