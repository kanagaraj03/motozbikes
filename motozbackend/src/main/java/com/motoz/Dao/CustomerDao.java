package com.motoz.Dao;
import java.util.List;

import org.springframework.stereotype.Service;
import com.motoz.model.Customer;
import com.motoz.model.Product;
@Service
public interface CustomerDao 
{
boolean insertuser(Customer i);
List<Customer> showall();

}
