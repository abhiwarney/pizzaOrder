package com.cg.pizzaordering.services;

import java.util.List;

import com.cg.pizzaordering.beans.Customer;
import com.cg.pizzaordering.beans.Orders;
import com.cg.pizzaordering.beans.Pizza;
import com.cg.pizzaordering.exceptions.CustomerDetailsNotFoundException;
import com.cg.pizzaordering.exceptions.OrderDetailsNotFoundException;
import com.cg.pizzaordering.exceptions.PizzaDetailsNotFoundException;

public interface PizzaOrderServices {
public Customer acceptCustomerDetails(Customer customer);
public Customer getCustomerDetails(int customerId)throws CustomerDetailsNotFoundException;
public Orders placeOrder(int customerId,List<Pizza>pizzaList);
public Pizza getPizzaDetails(int pizzaId)throws PizzaDetailsNotFoundException;
public Orders getOrderDetails(int orderId)throws OrderDetailsNotFoundException;
public boolean addToCart();
public boolean removeCustomerDetails(int customerId)throws CustomerDetailsNotFoundException;
}
