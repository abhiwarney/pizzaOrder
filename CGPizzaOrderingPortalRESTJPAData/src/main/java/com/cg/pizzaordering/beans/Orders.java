package com.cg.pizzaordering.beans;
import java.time.LocalDate;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private double totalAmount;
	private String orderStatus;
	private LocalDate placeDate;
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer,Pizza>pizzas;
	public Orders() {}
	public Orders(int orderId, double totalAmount, String orderStatus, LocalDate placeDate, Customer customer,
			Map<Integer, Pizza> pizzas) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.placeDate = placeDate;
		this.customer = customer;
		this.pizzas = pizzas;
	}
	public Orders(double totalAmount, String orderStatus, LocalDate placeDate, Customer customer,
			Map<Integer, Pizza> pizzas) {
		super();
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.placeDate = placeDate;
		this.customer = customer;
		this.pizzas = pizzas;
	}
	public Orders(double totalAmount, String orderStatus, LocalDate placeDate, Customer customer) {
		super();
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.placeDate = placeDate;
		this.customer = customer;
	}
	public Orders(double totalAmount, String orderStatus, LocalDate placeDate) {
		super();
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.placeDate = placeDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDate getPlaceDate() {
		return placeDate;
	}
	public void setPlaceDate(LocalDate placeDate) {
		this.placeDate = placeDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Map<Integer, Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Map<Integer, Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((pizzas == null) ? 0 : pizzas.hashCode());
		result = prime * result + ((placeDate == null) ? 0 : placeDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		if (pizzas == null) {
			if (other.pizzas != null)
				return false;
		} else if (!pizzas.equals(other.pizzas))
			return false;
		if (placeDate == null) {
			if (other.placeDate != null)
				return false;
		} else if (!placeDate.equals(other.placeDate))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus
				+ ", placeDate=" + placeDate + ", customer=" + customer + ", pizzas=" + pizzas + "]";
	}
}
