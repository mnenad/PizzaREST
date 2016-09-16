package com.pizza.backend.atb.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	//@Transactional(propagation=Propagation.REQUIRED)
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Order addOrder(String userId, String orderJSON) {
		Order order = new Order();
		order.setUserId(userId);
		order.setOrderJSON(orderJSON);
		return orderRepository.save(order);
	}
	public List<Order> getOrders(String userId) {
		return orderRepository.findByUserId(userId);
	}
	public Order getPrevOrder(String orderId) {
		return orderRepository.findOne(new Integer(orderId));
	}
	
}
