package com.revature.revaturequestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.revaturequestion.connection.ConnectionUtil;
import com.revature.revaturequestion.dto.QuestionDTO;
import com.revature.revaturequestion.exception.DBException;
import com.revature.revaturequestion.model.Answer;
import com.revature.revaturequestion.model.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	// @Autowired
	// DataSource datasource;
	Connection con = null;
	PreparedStatement pst = null;
	ConnectionUtil conObject;

	public boolean saveQuestionAnswer(Question question, QuestionDTO QuestionDTO) throws DBException {
		Boolean result = false;
		Savepoint questionAnswer = null;
		try {
			con = ConnectionUtil.getConnection();
			con.setAutoCommit(false);
			questionAnswer = con.setSavepoint("savepoint");
			String sqlQuestion = "insert into questions(title,question_type,content,category_id,tag,level_id,skill_points,score,duration,status,is_import)values(?,?,?,?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sqlQuestion);
			pst.setString(1, question.getTitle());
			pst.setString(2, question.getQuestionType().toString());
			pst.setString(3, question.getContent());
			pst.setString(4, question.getCategoryId());
			pst.setString(5, question.getTag());
			pst.setString(6, question.getLevelId());
			pst.setString(7, question.getSkillPoints());
			pst.setString(8, question.getScore());
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

			List<Answer> answerList = QuestionDTO.getAnswer();
			String answerDetail = "";
			int count = 0;
			for (Answer answers : answerList) {
				answerDetail = answerDetail + "(" + questionId + "," + "\"" + answers.getOption() + "\"" + ","
						+ answers.getIsRightAnswer() + " ," + "\"" + answers.getRightAnswerExplanation() + "\"" + ","
						+ answers.getIsStricky() + "," + answers.getGrading() + ")";
				count++;

				if (count < answerList.size()) {
					answerDetail = answerDetail + ",";
				}

			}
			String sqlMultiple = "insert into question_answers(question_id,`option`,is_right_answer,right_ans_explanation,is_sticky,grading)values"
					+ answerDetail;
			System.out.println("sqlMultiple" + sqlMultiple);
			pst = con.prepareStatement(sqlMultiple);
			int check = pst.executeUpdate();

			// String sqlMatching="insert into
			// question_matchings(question_id,answer_id,is_sticky)values(?,?,?)";

			con.commit();

			if (check == 1) {
				result = true;
			}
		} catch (SQLException e) {
			try {
				con.rollback(questionAnswer);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DBException("Unable to save Question");
		} finally {
			try {
				pst.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean deleteQuestion(String questionId) throws DBException {
		Boolean result = false;
		Savepoint deleteQuestion = null;

		try {
			con = ConnectionUtil.getConnection();

			con.setAutoCommit(false);
			deleteQuestion = con.setSavepoint("savepoint");

			String query = "delete from question_answers where question_id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, questionId);
			pst.executeUpdate();

			String sql = "delete from questions where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, questionId);
			int check = pst.executeUpdate();
			if (check == 1) {
				result = true;
			}
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback(deleteQuestion);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DBException("Unable to delete Question");
		} finally {
			try {
				pst.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("result" + result);
		return result;
	}

	public boolean updateQuestion(String questionId, String status) throws DBException {
		Boolean result = false;

		try {
			con = ConnectionUtil.getConnection();
			String sql = "update questions set `status`=? where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			pst.setString(2, questionId);
			int check = pst.executeUpdate();
			if (check == 1) {
				result = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Unable to update Question");

		} finally {
			try {
				pst.close();
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Question> listAllQuestions(String status) throws DBException {
		Connection con = null;
		PreparedStatement pst = null;
		List<Question> question = new ArrayList<Question>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select q.title,q.tag,c.name,ql.name from questions q,categories c,question_levels ql where q.category_id=c.id and q.level_id=ql.id and q.status=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, status);
			ResultSet rs = pst.executeQuery();
			Question value = null;
			while (rs.next()) {
				value = new Question();
				value = toRows(rs);
				question.add(value);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to view Questions");

		} finally {
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("value" + question);
		return question;
	}

	public Question toRows(ResultSet rs) {
		Question value = new Question();
		try {
			String title = rs.getString("q.title");
			String tag = rs.getString("q.tag");
			// question.setQuestionType(rs.getString("question_type"));
			String categoryName = rs.getString("c.name");
			String levelName = rs.getString("ql.name");

			value.setTitle(title);
			value.setCategoryName(categoryName);
			value.setLevelName(levelName);
			value.setTag(tag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public boolean update(Question question, Answer answer) throws DBException {
		Boolean result = false;
		try {
			con = ConnectionUtil.getConnection();
			String sqlQuestion = "update questions set title=?,content=?,category_id=?,level_id=?,tag=?,skill_points=?,score=?,duration=? where id=?";
			pst = con.prepareStatement(sqlQuestion);
			pst.setString(1, question.getTitle());
			pst.setString(2, question.getContent());
			pst.setString(3, question.getCategoryId());
			pst.setString(4, question.getLevelId());
			pst.setString(5, question.getTag());
			pst.setString(6, question.getSkillPoints());
			pst.setString(7, question.getScore());
			pst.setString(8, question.getDuration());
			pst.setString(9, question.getQuestionId());

			pst.executeUpdate();

			String sqlAnswer = "update question_answers set `option`=?,is_right_answer=?,right_ans_explanation=?,is_sticky=? where id=?";
			pst = con.prepareStatement(sqlAnswer);
			pst.setString(1, answer.getOption());
			pst.setBoolean(2, answer.getIsRightAnswer());
			pst.setString(3, answer.getRightAnswerExplanation());
			pst.setBoolean(4, answer.getIsStricky());
			pst.setString(5, answer.getId());
			int check = pst.executeUpdate();
			if (check == 1) {
				result = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("Connection error");

		} finally {
			try {
				pst.close();
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
