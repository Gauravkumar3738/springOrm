package com.gaurav.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gaurav.spring.dto.UserDTO;

@Repository
public class RegistrationDAO {

	@Autowired
	private SessionFactory factory;
	
	public Integer saveUser(UserDTO userDTO) {
		Integer identifier = null;
		Transaction tx = null;
		try(Session session = factory.openSession()) {
			tx = session.beginTransaction();
			identifier = (Integer) session.save(userDTO);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		return identifier;
	}
}
