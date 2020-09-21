package controller;

import entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionAnswerServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session=request.getSession(false);

        List<Question> list=(List) session.getAttribute("key");
        int result=0;
        for (Question question:list) {
            Integer questionId=question.getQuetionId();
            String answer=question.getAnswer();
            String value=request.getParameter("answer_"+questionId+"");
            if(answer.equals(value)){
                result +=25;
            }

        }
        request.setAttribute("info","本次考试分数为："+result+"");
        request.getRequestDispatcher("/info.jsp").forward(request,response);




    }
}
