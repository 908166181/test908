package controller;

import dao.StudentDao;
import entity.Students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

public class StudentAddServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    //1.取参
                        String sname,password,sex,email;
                        StudentDao dao=new StudentDao();
                         Students stu=null;
                        sname=request.getParameter("username");
                        password=request.getParameter("password");
                        sex=request.getParameter("sex");
                        email=request.getParameter("email");
                        int result=0;
                        PrintWriter out=null;
                        
                        //2.调用【dao】将用户信息传入
                        stu=new Students(null,sname,password,sex,email);
                        Date start=new Date();
                        result=dao.add(stu);
                        Date end=new Date();
                        System.out.println(end.getTime()-start.getTime()+"毫秒");

                        //3.调用【响应对象】将结果写入【响应体】
                        response.setContentType("text/html;charset=utf-8");
                        out=response.getWriter();
                        if(result==1){
                            out.print("<font style=' color:red;font-size:40'>用户信息注册成功</font>");
                        }else {
                            out.print("<font style=' color:red;font-size:40'>用户信息注册失败</font>");
                        }






    }
}
