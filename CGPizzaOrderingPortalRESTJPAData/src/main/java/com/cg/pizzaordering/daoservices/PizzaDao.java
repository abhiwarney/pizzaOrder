package com.cg.pizzaordering.daoservices;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.pizzaordering.beans.Pizza;
public interface PizzaDao extends JpaRepository<Pizza, Integer>{
}
