package com.cg.pizzaordering.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.pizzaordering.beans.Customer;
import com.cg.pizzaordering.beans.Orders;
import com.cg.pizzaordering.beans.Pizza;
import com.cg.pizzaordering.daoservices.CustomerDao;
import com.cg.pizzaordering.daoservices.OrderDao;
import com.cg.pizzaordering.daoservices.PizzaDao;
import com.cg.pizzaordering.exceptions.CustomerDetailsNotFoundException;
import com.cg.pizzaordering.exceptions.OrderDetailsNotFoundException;
import com.cg.pizzaordering.exceptions.PizzaDetailsNotFoundException;
@Component("pizzaOrderServices")
public class PizzaOrderingServicesImpl implements PizzaOrderServices {
	@Autowired
	public CustomerDao customerDao;
	@Autowired
	public OrderDao orderDao;
	@Autowired
	public PizzaDao pizzaDao;
	@Override
	public Customer acceptCustomerDetails(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Orders placeOrder(int customerId,List<Pizza> pizzaList) {
		getCustomerDetails(customerId);
		double totalSum=0;
		Orders order = new Orders();
		for (Pizza pizza : pizzaList) {
			order.getPizzas().put(pizza.getPizzaId(), pizza);
			totalSum+=pizza.getPrice();
		}
		order.setOrderStatus("Pending");
		order.setPlaceDate(LocalDate.now());
		order.setTotalAmount(totalSum);
		order.setCustomer(getCustomerDetails(customerId));
		orderDao.save(order);
		return order;
	}

	@Override
	public boolean addToCart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCustomerDetails(int customerId) {
		customerDao.delete(getCustomerDetails(customerId));
		return true;
	}

	@Override
	public Pizza getPizzaDetails(int pizzaId) {
		return pizzaDao.findById(pizzaId).orElseThrow(()->new PizzaDetailsNotFoundException("Pizza Details not found for PizzaId:-"+pizzaId));
	}

	@Override
	public Orders getOrderDetails(int orderId) {
		return orderDao.findById(orderId).orElseThrow(()->new OrderDetailsNotFoundException("Order Details Not Found For Order Id:-"+orderId));
	}

	@Override
	public Customer getCustomerDetails(int customerId) {
		return customerDao.findById(customerId).orElseThrow(()->new CustomerDetailsNotFoundException("CustomerDetailsNotFound for customerId:-"+customerId));
	}

}
