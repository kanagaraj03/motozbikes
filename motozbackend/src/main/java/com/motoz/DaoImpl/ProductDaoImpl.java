package com.motoz.DaoImpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.motoz.Dao.ProductDao;
import com.motoz.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionfactory;
	public boolean insertprodu(Product i) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			s.save(i);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean updateprodu(Product u) {
		{
			try {
				Session s = sessionfactory.openSession();
				Transaction t = s.getTransaction();
				t.begin();
				s.update(u);
				t.commit();
				s.close();
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	public boolean deleteprodu(int id) {
		Session s = sessionfactory.openSession();
		Transaction t = s.getTransaction();
		t.begin();
		Product c = s.get(Product.class, id);
		s.delete(c);
		t.commit();
		s.close();
		
		return true;
	}


	public List<Product> showall() {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<Product> r = s.createQuery("from Product").list();
			t.commit();
			s.close();
			return r;
		}
		catch (Exception e) 
		
		{
			return null;
		}
	}

	public Product showone(int id) 
	{	try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Product x = s.get(Product.class, id);
			t.commit();
			s.close();
			return x;
		} catch (Exception e) {
			return null;
		}
	}
}