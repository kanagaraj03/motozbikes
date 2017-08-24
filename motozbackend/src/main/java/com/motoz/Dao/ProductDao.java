package com.motoz.Dao;
import java.util.List;
import com.motoz.model.Product;

public interface ProductDao
{
	boolean insertprodu(Product i);
	boolean updateprodu(Product u);
	boolean deleteprodu (int id);
	List<Product> showall();
	Product showone (int id);
}
