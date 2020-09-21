package until;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JdbcUtil {

 final String URL="jdbc:mysql://localhost:3306/xiaoan";
 final String USER="root";
 final String PASSWORD="333";

Connection con=null;
PreparedStatement ps=null;


    public Connection getConnection(HttpServletRequest request )  {
        ServletContext application=request.getServletContext();
        Map map=(Map)application.getAttribute("key1");
        Iterator it=map.keySet().iterator();
        while (it.hasNext()){
            con=(Connection) it.next();
            boolean flag=(boolean)map.get(con);
            if(flag==true){
                map.put(con,false);
                break;
            }

        }
        return con;

    }

    public PreparedStatement addSql(String sql,HttpServletRequest request){
        try {
            con=getConnection(request);
            ps=con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void close(HttpServletRequest request){

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        ServletContext application=request.getServletContext();
        Map map =(Map) application.getAttribute("key1");
        map.put(con,true);



    }
    /*工具类中的构造方法是私有的
          因为工具类中的方法都是静态的，直接通过类名去调即可。*/
    //private JdbcUtil(){}


    /**
     * 静态代码块，类加载的时候执行
     * 把注册驱动程序的代码放在静态代码块中，避免多次获取连接对象时重复调用
     */
    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection()  {
        try {
            con= DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }



    public PreparedStatement addSql(String sql){
        try {
            ps=getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }




    public void close(){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs){
        close();
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}


