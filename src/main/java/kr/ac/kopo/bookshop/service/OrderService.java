package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Orders;

public interface OrderService {

	List<Orders> list();

	void add(Orders item);

	Orders item(int orderid);

	void update(Orders item);

	void delete(int orderid);

}
