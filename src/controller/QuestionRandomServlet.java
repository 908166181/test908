package controller;

import dao.QuestionDao;
import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRandomServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionDao dao=new QuestionDao();
        List list=new ArrayList();
        HttpSession session=request.getSession(false);

        list=dao.random();
        session.setAttribute("key",list);


         request.getRequestDispatcher("/question_random.jsp").forward(request,response);



    }
}
