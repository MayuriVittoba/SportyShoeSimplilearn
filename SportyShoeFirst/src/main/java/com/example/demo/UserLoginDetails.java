package com.example.demo;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class UserLoginDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userEmail;
	private String userPwd;
	private boolean isLoggedIn;

}
