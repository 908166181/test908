package dao;

import entity.Question;
import until.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    JdbcUtil util=new JdbcUtil();

    public int add(Question qs){
        String sql="insert into question(title,optionA,optionB,optionC,optionD,answer)"+"value(?,?,?,?,?,?)";
        PreparedStatement ps=util.addSql(sql);
        int result=0;
        try {
            ps.setString(1,qs.getTitle());
            ps.setString(2,qs.getOptionA());
            ps.setString(3,qs.getOptionB());
            ps.setString(4,qs.getOptionC());
            ps.setString(5,qs.getOptionD());
            ps.setString(6,qs.getAnswer());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;


    }

    public List findAll(){
        String sql="select * from question";
        PreparedStatement ps=util.addSql(sql);
        ResultSet rs=null;

        List<Question> question=new ArrayList<>();
        Question qs=null;
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer questionId=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String  answer =rs.getString("answer");
                qs=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                question.add(qs);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return question;



    }

    public Question find(String questionId){
        String sql="select * from question where questionId=?";
        PreparedStatement ps=util.addSql(sql);
        ResultSet rs=null;
        Question qs=null;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            rs=ps.executeQuery();
            while (rs.next()){
                Integer Id=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String  answer =rs.getString("answer");
                qs=new Question(Id,title,optionA,optionB,optionC,optionD,answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return qs;


    }

    public int update(Question qs){
        String sql="update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
        PreparedStatement ps=util.addSql(sql);
        int result=0;
        try {
            ps.setString(1,qs.getTitle());
            ps.setString(2,qs.getOptionA());
            ps.setString(3,qs.getOptionB());
            ps.setString(4,qs.getOptionC());
            ps.setString(5,qs.getOptionD());
            ps.setString(6,qs.getAnswer());
            ps.setInt(7,qs.getQuetionId());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public int delete(String questionId){
        String sql="delete from question where questionId=?";
        PreparedStatement ps=util.addSql(sql);
        int result=0;
        try {
            ps.setInt(1,Integer.valueOf(questionId));
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public List random(){
        String sql="select * from question order by rand() limit 0,4";
        PreparedStatement ps=util.addSql(sql);
        ResultSet rs=null;

        List<Question> question=new ArrayList<>();
        Question qs=null;
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                Integer questionId=rs.getInt("questionId");
                String title=rs.getString("title");
                String optionA=rs.getString("optionA");
                String optionB=rs.getString("optionB");
                String optionC=rs.getString("optionC");
                String optionD=rs.getString("optionD");
                String  answer =rs.getString("answer");
                qs=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                question.add(qs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return question;



    }





}
