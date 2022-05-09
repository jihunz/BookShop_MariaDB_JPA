package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Orders;

public interface OrdersService {

	List<Orders> list();

	void add(Orders item, List<Integer> books, List<Integer> amounts);

	Orders item(int orderid);

	void update(Orders item);

	void delete(int orderid);

}
