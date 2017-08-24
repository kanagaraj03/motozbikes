package com.motoz.Dao;

import java.util.List;

import com.motoz.model.Supplier;

public interface SupplierDao {

	
		boolean insertsup (Supplier i);
		boolean updatesup (Supplier u);
		boolean deletesup (int id);
		List <Supplier> showall();
		Supplier showone (int id);
		
}
