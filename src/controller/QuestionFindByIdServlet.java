package controller;

import dao.QuestionDao;
import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao dao=new QuestionDao();
        String questionId;
        Question qs=null;
       questionId=request.getParameter("questionId");
        qs=dao.find(questionId);
        request.setAttribute("key",qs);
        request.getRequestDispatcher("/question_find.jsp").forward(request,response);


    }
}
