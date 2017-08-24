package com.motoz.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motoz.Dao.CustomerDao;
import com.motoz.model.Customer;
import com.motoz.model.Product;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SessionFactory sessionfactory;

	public boolean insertuser(Customer i) {
		try {
System.out.println(i.getCustomername()+"  "+i.getEmail());
			Session s =sessionfactory.openSession();
			Transaction t=s.getTransaction();
			t.begin();
			s.save(i);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {

			return false;
		}

	}


	public List<Customer> showall() {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<Customer> r = s.createQuery("from Customer").list();
			t.commit();
			s.close();
			return r;
			}
catch (Exception e) 
		{
			return null;
		}
	}}