package com.example.demo;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public void changeAdminPwd(AdminDetails adminDetails) {
		// TODO Auto-generated method stub
		entityManager.merge(adminDetails);

	}

	@Override
	public AdminDetails findAdminByEmail(String adminEmail) {
		// TODO Auto-generated method stub

		AdminDetails adminDetails = new AdminDetails();
		try {
			Query query = entityManager
					.createNativeQuery("select admin_id,admin_name,admin_pwd from admin_details where admin_email=?");
			query.setParameter(1, adminEmail);

			if (query.getSingleResult() != null) {

				Object[] adminObj = (Object[]) query.getSingleResult();

				adminDetails.setAdminEmail(adminEmail);
				adminDetails.setAdminId((int) adminObj[0]);
				adminDetails.setAdminName((String) adminObj[1]);
				adminDetails.setAdminPwd((String) adminObj[2]);
			}
		} catch (Exception ex) {
			adminDetails = null;
		}

		return adminDetails;

	}

}
