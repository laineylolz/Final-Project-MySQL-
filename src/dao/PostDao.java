package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Post;

public class PostDao {

	private Connection connection;
	private final String CREATE_NEW_POST_QUERY = "insert into posts (user_id, content_posted, date_posted) values (?,?, now())";
	private final String GET_POST_BY_ID_QUERY = "select * from posts where post_id = ?";
	private final String DELETE_POST_BY_ID_QUERY = "delete from posts where post_id = ?";
	private final String UPDATE_POST_BY_ID_QUERY = "update posts set content_posted = ? where post_id = ?";
	public PostDao() {
		connection = DBConnection.getConnection();
	}
	
	public void createNewPost(int userId, String contentPosted) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_POST_QUERY);
		ps.setInt(1, userId);
		ps.setString(2, contentPosted);
		ps.executeUpdate();
	}
	public Post getPostById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_POST_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePost(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
	}
	
	private Post populatePost(int int1, int int2, String string1, String string2) throws SQLException {
		return new Post(int1, int2, string1, string2);
	}
	public void deletePostById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_POST_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	public void updatePost(Post post) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_POST_BY_ID_QUERY);
		ps.setString(1, post.getContentPosted());
		ps.setInt(2, post.getPostId());
		ps.executeUpdate();
	}
}
