package com.cg.pizzaordering.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.pizzaordering.beans.Orders;
public interface OrderDao extends JpaRepository<Orders, Integer>{
}
