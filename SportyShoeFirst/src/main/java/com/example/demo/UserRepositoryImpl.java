package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private class UserRowMapper implements RowMapper<UserLoginDetails> {

		@Override
		public UserLoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UserLoginDetails user = new UserLoginDetails();
			user.setUserId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setUserEmail(rs.getString(3));
			user.setUserPwd(rs.getString(4));
			user.setLoggedIn(rs.getBoolean(5));
			return user;
		}

	}

	@Override
	public List<UserLoginDetails> searchUsersByName(String username) {
		// TODO Auto-generated method stub
		List<UserLoginDetails> users = jdbcTemplate.query(
				"SELECT USER_ID,USER_NAME,USER_EMAIL,USER_PWD,IS_LOGGED_IN from USER_LOGIN_DETAILS WHERE IS_LOGGED_IN=true and USER_NAME like ?",
//						+ username + "'",
				new Object[] { "%" + username + "%" }, new int[] { java.sql.Types.VARCHAR },
				new RowMapper<UserLoginDetails>() {

					@Override
					public UserLoginDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						UserLoginDetails user = new UserLoginDetails();
						user.setUserId(rs.getInt(1));
						user.setUserName(rs.getString(2));
						user.setUserEmail(rs.getString(3));
						user.setUserPwd(rs.getString(4));
						user.setLoggedIn(rs.getBoolean(5));
						return user;
					}

				});

		return users;
	}

	@Override
	public List<UserLoginDetails> getLoggedInUsers() {
		// TODO Auto-generated method stub
		List<UserLoginDetails> users = jdbcTemplate.query(
				"select USER_ID,USER_NAME,USER_EMAIL,USER_PWD,IS_LOGGED_IN from USER_LOGIN_DETAILS where IS_LOGGED_IN=true",
				new UserRowMapper());
		return users;

	}

	@Override
	public void saveNewUser(UserLoginDetails user) {
		// TODO Auto-generated method stub

//		jdbcTemplate.update("insert into userlogindetails ( name, email, password,isloggedin) " + "values(?,  ?, ?, ?)",
//				new Object[] { user.getUserName(), user.getUserEmail(), user.getUserPwd(), 0 });

		String query = "insert into userlogindetails(username,email,password,isloggedin) values('" + user.getUserName()
				+ "','" + user.getUserEmail() + "','" + user.getUserPwd() + "',0)";

		jdbcTemplate.update(query);

	}

	@Override
	public void deleteUser(UserLoginDetails user) {
		// TODO Auto-generated method stub

//		jdbcTemplate.update("delete from userlogindetails where userid=?", new Object[] { user.getUserId() });

		String query = "delete from userlogindetails where userid=" + user.getUserId();
		jdbcTemplate.update(query);

	}

	@Override
	public void getUserByEmail(String userEmail) {
		UserLoginDetails user = jdbcTemplate.queryForObject(
				"select * from userlogindetails where useremail='" + userEmail + "'", UserLoginDetails.class);
	}

	@Override
	public void changeUserPwd(int userId, String password) {
		jdbcTemplate.update("update userlogindetails set password='" + password + "' where userid=" + userId);
	}

	@Override
	public void changeIsLoggedIn(int userId, int isloggedin) {
		jdbcTemplate.update("update userlogindetails set isloggedin='" + isloggedin + "' where userid=" + userId);
	}

	public void findById(String userEmail) {
//	 jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { userEmail },
//				new BeanPropertyRowMapper<UserLoginDetails>(UserLoginDetails.class));
//	 jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { userEmail }, new BeanPropertyRowMapper<UserLoginDetails>(UserLoginDetails.class))

		UserLoginDetails user = jdbcTemplate.queryForObject("select * from userlogindetails where useremail=?",
				new Object[] { userEmail }, new int[] { java.sql.Types.VARCHAR },
				new BeanPropertyRowMapper<UserLoginDetails>(UserLoginDetails.class));

	}
}
