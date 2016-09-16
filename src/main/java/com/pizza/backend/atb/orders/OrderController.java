package com.pizza.backend.atb.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	

	@RequestMapping("/")
	//todo: Remove test URL http://localhost:8080/
	public List<Order> getAllOrders(){
		
		List<Order> orders = orderService.getAllOrders();
		return orders;	
		
	}
	@RequestMapping("/add/{userId}/{orderJSON}")
	//todo: Remove test URL http://localhost:8080/add/nenadm/'JSON String goes here'
	public Order add(@PathVariable("userId") String userId, 
							 @PathVariable("orderJSON") String orderJSON){
		
		Order order = orderService.addOrder(userId, orderJSON);
		System.out.println("Order saved:"+order);
		return order;
	}
	@RequestMapping("/getOrders/{userId}")
	//todo: Remove test URL http://localhost:8080/getOrders/nenadm
	public List<Order> getOrders(@PathVariable("userId") String userId){
		List<Order> orders = orderService.getOrders(userId);
		System.out.println("Orders retreived:"+orders.toString());
		return orders;
	}
	@RequestMapping("/getPrevOrder/{orderId}")
	//todo: Remove test URL http://localhost:8080/getPrevOrder/4
	public Order getPrevOrder(@PathVariable("orderId") String orderId){
		Order order = orderService.getPrevOrder(orderId);
		System.out.println("Order found:"+order.toString());
		return order;
	}
}
