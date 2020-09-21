package dao;

import entity.Students;
import until.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private JdbcUtil util=new JdbcUtil();

    public int add(Students user){
        String sql ="insert into students(sname ,password, sex,email)" + " values(?,?,?,?)";

        PreparedStatement ps = util.addSql(sql);
        int result=0;
        try {
            ps.setString(1,user.getSname());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public int add(Students user, HttpServletRequest request){
        String sql ="insert into students(sname ,password, sex,email)" + " values(?,?,?,?)";

        PreparedStatement ps = util.addSql(sql,request);
        int result=0;
        try {
            ps.setString(1,user.getSname());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(request);
        }
        return result;

    }

    public List find(){
        String sql="select * from students";
        PreparedStatement ps =util.addSql(sql);
        ResultSet rs=null;
        List stuList=new ArrayList();
        try {
            rs =ps.executeQuery();
            while (rs.next()){
                Integer sid=rs.getInt("sid");
                String sname=rs.getString("sname");
                String password=rs.getString("password");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                Students stu=new Students(sid,sname,password,sex,email);
                stuList.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return stuList;


    }

    public int delete(String sid){
        int relust=0;
        String sql="delete from students where sid=?";
        try {
            PreparedStatement ps=util.addSql(sql);
            ps.setInt(1,Integer.valueOf(sid));
            relust=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return relust;
    }

    public int login(String sname,String password){
        String sql="select count(*) from students where sname=? and password=?";
        PreparedStatement ps=util.addSql(sql);
        ResultSet rs=null;
        int result=0;
        try {
            ps.setString(1,sname);
            ps.setString(2,password);
            rs=ps.executeQuery();
            while (rs.next()){
                result=rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }
}