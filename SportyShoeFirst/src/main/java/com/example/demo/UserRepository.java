package com.example.demo;

import java.util.List;

public interface UserRepository {
	public List<UserLoginDetails> searchUsersByName(String username);

	public List<UserLoginDetails> getLoggedInUsers();

	public void saveNewUser(UserLoginDetails user);

	public void deleteUser(UserLoginDetails user);

	void getUserByEmail(String userEmail);

	void changeUserPwd(int userId, String password);

	void changeIsLoggedIn(int userId, int isloggedin);

}
