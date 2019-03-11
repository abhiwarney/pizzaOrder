package com.cg.pizzaordering.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.pizzaordering.beans.Customer;
public interface CustomerDao extends JpaRepository<Customer, Integer>{
}
