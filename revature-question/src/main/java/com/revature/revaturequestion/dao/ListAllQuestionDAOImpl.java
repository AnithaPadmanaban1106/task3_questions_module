package com.revature.revaturequestion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.revaturequestion.model.Question;

@Repository
public class ListAllQuestionDAOImpl implements IListAllQuestionDAO {
	@Autowired
	private DataSource datasource;

	public List<Question> listAllQuestions() throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		List<Question> question = new ArrayList<Question>();
		try {
			con = datasource.getConnection();
			String sql = "select q.title,q.tag,c.name,ql.name from question q,category c,question_level ql where q.category_id=c.id and q.level_id=ql.id";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			Question value = null;
			while (rs.next()) {
				value = new Question();
				value = toRows(rs);
				question.add(value);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			pst.close();
			con.close();
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
}
