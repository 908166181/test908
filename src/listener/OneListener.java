package listener;

import until.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OneListener implements ServletContextListener {



    //创建二十个通道
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        JdbcUtil util=new JdbcUtil();
        Map map=new HashMap();
        for(int i=1;i<=20;i++){
            Connection con=util.getConnection();
            map.put(con,true);//true表示通道处于空闲；
        }
        ServletContext application=sce.getServletContext();
        application.setAttribute("key1",map);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //销毁map
        ServletContext application=sce.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            Connection con=(Connection) it.next();
            if(con!=null){
                //销毁con
                System.out.println("我走了");
            }
        }

    }
}
