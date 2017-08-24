package com.motoz.Dao;
import java.util.List;
import org.springframework.stereotype.Service;

import com.motoz.model.Category;
public interface CategoryDao 
{		
boolean insertcat (Category i);
boolean updatecat (Category u);
boolean deletecat (int id);
List <Category>showall();

Category showone (int id);

}
