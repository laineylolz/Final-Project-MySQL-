package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDao {
	
	private Connection connection;
	private final String CREATE_NEW_USER_QUERY = "insert into user (username, first_name, last_name, birth_date, email, password) values (?,?,?,?,?,?)";
	private final String GET_USER_BY_ID_QUERY = "select * from user where id = ?";
	private final String UPDATE_USER_QUERY = "update user set username = ?, first_name = ?, last_name = ?, email = ?, password = ? where id = ?";
	private final String DELETE_USER_BY_ID_QUERY = "delete from user where id = ?";
	public UserDao() {
		connection = DBConnection.getConnection();
	}
	
	public User getUserById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
	}
	
	private User populateUser(int int1, String string, String string2, String string3, String string4, String string5,
			String string6) {
		return new User(int1, string, string2, string3, string4, string5, string6);
	}

	public void createNewUser(String username, String firstName, String lastName, String birthDate, String email, String password) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_USER_QUERY);
		ps.setString(1, username);
		ps.setString(2, firstName);
		ps.setString(3, lastName);
		ps.setString(4, birthDate);
		ps.setString(5, email);
		ps.setString(6, password);
		ps.executeUpdate();
		
	}
	
	public void updateUser(User user) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_USER_QUERY);
		ps.setString(1, user.getUserUsername());
		ps.setString(2, user.getUserFirstName());
		ps.setString(3, user.getUserLastName());
		ps.setString(4, user.getUserEmail());
		ps.setString(5, user.getUserPassword());
		ps.setInt(6, user.getUserId());
		
		ps.executeUpdate();
		
	}
	public void deleteUserById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_USER_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	} 
	
}
