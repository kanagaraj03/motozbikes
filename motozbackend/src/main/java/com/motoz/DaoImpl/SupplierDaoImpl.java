package com.motoz.DaoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.motoz.Dao.SupplierDao;
import com.motoz.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionfactory;

	public boolean insertsup(Supplier i) {
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

	public boolean updatesup(Supplier u) {
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

	public boolean deletesup(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Supplier c = s.get(Supplier.class, id);
			s.delete(c);
			t.commit();
			s.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Supplier> showall() {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			List<Supplier> r = s.createQuery("from Supplier").list();
			t.commit();
			s.close();
			return r;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Supplier showone(int id) {
		try {
			Session s = sessionfactory.openSession();
			Transaction t = s.getTransaction();
			t.begin();
			Supplier x = s.get(Supplier.class, id);
			t.commit();
			s.close();
			return x;
		} catch (Exception e) {
			return null;
		}

	}
}