package kr.ac.kopo.bookshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.DetailDao;
import kr.ac.kopo.bookshop.model.Detail;
import kr.ac.kopo.bookshop.model.Orders;

@Service
public class OrdersServiceImpl implements OrderService {
	
	@Autowired
	OrdersDao dao;
	
	@Autowired
	DetailDao detailDao;

	@Override
	public List<Orders> list() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void add(Orders item) {
		dao.save(item);
		
		for(Detail detail : item.getDetail()) {
			detail.setOrderid(item.getOrderid());
			detailDao.save(detail);
		}
	}

	@Override
	public Orders item(int orderid) {
		return dao.findOneByOrderid(orderid);
	}

	@Override
	@Transactional
	public void update(Orders item) {		
		for(Detail detail : item.getDetail()) {
			detail.setOrderid(item.getOrderid());			
			detailDao.save(detail);
		}
		
		dao.save(item);
	}

	@Override
	@Transactional
	public void delete(int orderid) {
		Orders item = dao.findOneByOrderid(orderid);
		
		for(Detail detail : item.getDetail())
			detailDao.deleteById(detail.getDetailId());			
		
		dao.deleteById(orderid);
	}

}
