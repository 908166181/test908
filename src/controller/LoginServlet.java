package controller;

import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sname,password;
        StudentDao dao=new StudentDao();
        int result=0;
        request.setCharacterEncoding("utf-8");
        sname=request.getParameter("username");
        password=request.getParameter("password");
        result=dao.login(sname,password);
        if(result==1){//合法后，申请一个私人储物柜
                HttpSession session=request.getSession();

            response.sendRedirect("/myWeb/index.html");
        }else {
            response.sendRedirect("/myWeb/login_error.html");

        }




    }


}
