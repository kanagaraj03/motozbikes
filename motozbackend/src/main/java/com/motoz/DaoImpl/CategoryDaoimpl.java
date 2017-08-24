package com.motoz.DaoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.motoz.Dao.CategoryDao;
import com.motoz.model.Category;

@Repository
public class CategoryDaoimpl implements CategoryDao {
	@Autowired
	SessionFactory sessionfactory;


	public boolean insertcat(Category i) {
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


	public boolean updatecat(Category u) {
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


	public boolean deletecat(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Category c = s.get(Category.class, id);
			s.delete(c);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public List<Category> showall() {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<Category> r = s.createQuery("from Category").list();
			t.commit();
			s.close();
			return r;
		} catch (Exception e) {
			return null;
		}
	}

	
	public Category showone(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Category x = s.get(Category.class, id);
			t.commit();
			s.close();
			return x;
		} catch (Exception e) {
			return null;
		}

	}
}
