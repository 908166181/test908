package controller;

import dao.StudentDao;
import entity.Students;
import until.ReflectUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentFindServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                        StudentDao dao=new StudentDao();
                        PrintWriter out;
                        HttpSession session=request.getSession(false);
                        if(session==null){
                            response.sendRedirect("/myWeb/login_error.html");
                            return ;
                        }


                        List<Students> stuList=dao.find();
                        List<String> jsonList=new ArrayList();
                        for (Students stu:stuList) {
                            String json=ReflectUtil.json(stu);
                            jsonList.add(json);
                        }

                        request.setAttribute("key",jsonList);
                        request.getRequestDispatcher("/student_find.jsp").forward(request,response);


    }
}
