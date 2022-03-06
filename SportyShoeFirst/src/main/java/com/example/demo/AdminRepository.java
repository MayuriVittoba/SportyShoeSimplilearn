package com.example.demo;

public interface AdminRepository {
	public void changeAdminPwd(AdminDetails adminDetails);

	public AdminDetails findAdminByEmail(String adminEmail);

}
