package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Comment;

public class CommentDao {

	private Connection connection;
	private final String CREATE_NEW_COMMENT_QUERY = "insert into comments (post_id, user_id, content_commented, date_commented) values (?,?,?, now())";
	private final String GET_COMMENT_BY_ID_QUERY = "select * from comments where comment_id = ?";
	private final String UPDATE_COMMENT_QUERY = "update comments set content_commented = ? where comment_id = ?";
	private final String DELETE_COMMENT_BY_ID_QUERY = "delete from comments where comment_id = ?";
	public CommentDao() {
		connection = DBConnection.getConnection();
	}

	public void createNewComment(int postId, int userId, String content_commented) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_COMMENT_QUERY);
		ps.setInt(1, postId);
		ps.setInt(2, userId);
		ps.setString(3, content_commented);
		ps.executeUpdate();
	}
	
	public Comment getCommentById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_COMMENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateComment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
		
	}

	private Comment populateComment(int int1, int int2, int int3, String string, String string2) {
		return new Comment(int1, int2, int3, string, string2);
	}
	public void updateComment(Comment comment) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_COMMENT_QUERY);
		ps.setString(1, comment.getContentCommented());
		ps.setInt(2, comment.getCommentId());
		ps.executeUpdate();
	}
	
	public void deleteCommentById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_COMMENT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
}
