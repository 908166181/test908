package controller;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentDeleteServlet extends HttpServlet  {



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid;
        int result=0;
        PrintWriter out=null;
        sid=request.getParameter("sid");
        StudentDao dao=new StudentDao();
        result=dao.delete(sid);
        response.setContentType("text/html;charset=utf-8");
        out=response.getWriter();
        if(result==1){
            out.print("<font style=' color:red;font-size:40'>用户信息删除成功</font>");
        }else {
            out.print("<font style=' color:red;font-size:40'>用户信息删除失败</font>");
        }
    }



    }

