package com.revature.revaturequestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.Question;

@Repository
public class QuestionAnswerDAOImpl implements IAnswerQuestionDAO {
	@Autowired
	private DataSource datasource;
	Connection con = null;
	PreparedStatement pst = null;
	Boolean result = false;

	public boolean saveQuestionAnswer(Question question, Answer answer) throws SQLException {

		Savepoint questionAnswer = null;
		try {
			con = datasource.getConnection();
			con.setAutoCommit(false);
			questionAnswer = con.setSavepoint("savepoint");
			String sqlQuestion = "insert into question(title,question_type,content,category_id,tag,level_id,skill_points,score,duration,status,is_import)values(?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sqlQuestion);
			pst.setString(1, question.getTitle());
			pst.setString(2, question.getQuestionType().toString());
			pst.setString(3, question.getContent());
			pst.setInt(4, question.getCategoryId());
			pst.setString(5, question.getTag());
			pst.setInt(6, question.getLevelId());
			pst.setInt(7, question.getSkillPoints());
			pst.setDouble(8, question.getScore());
			pst.setString(9, question.getDuration());
			pst.setBoolean(10, question.getStatus());
			pst.setBoolean(11, question.getIsImported());
			pst.executeUpdate();

			String selectQuery = "select last_insert_id()";
			pst = con.prepareStatement(selectQuery);

			ResultSet rs = pst.executeQuery();
			int questionId = 0;
			if (rs.next()) {

				questionId = rs.getInt("last_insert_id()");

			}

			String sqlAnswer = "insert into answer(question_id,`option`,is_right_answer,right_ans_explanation,grading,is_sticky)values(?,?,?,?,?,?)";
			pst = con.prepareStatement(sqlAnswer);
			pst.setInt(1, questionId);
			pst.setString(2, answer.getOption());
			pst.setBoolean(3, answer.getIsRightAnswer());
			pst.setString(4, answer.getRightAnswerExplanation());
			pst.setString(5, answer.getGrading());
			pst.setBoolean(6, answer.getIsStricky());

			int check = pst.executeUpdate();
			con.commit();

			if (check == 1) {
				result = true;
			}
		} catch (SQLException e) {
			con.rollback(questionAnswer);
			e.printStackTrace();
		} finally {
			pst.close();
			con.close();
		}
		return result;
	}

	public boolean deleteQuestion(Question question) throws SQLException {
		Boolean result = false;
		Savepoint deleteQuestion = null;

		try {
			con = datasource.getConnection();
			
			con.setAutoCommit(false);
			deleteQuestion = con.setSavepoint("savepoint");
			
			String query = "delete from answer where question_id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, question.getQuestionId());
			pst.executeUpdate();

			String sql = "delete from question where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, question.getQuestionId());
			int check = pst.executeUpdate();
			if (check == 1) {
				result = true;
			}
			con.commit();
			
		} catch (SQLException e) {
           con.rollback(deleteQuestion);
			e.printStackTrace();
		} finally {
			pst.close();
			con.close();
		}
		return result;
	}
}
