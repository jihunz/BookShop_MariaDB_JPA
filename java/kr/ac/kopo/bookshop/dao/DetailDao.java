package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import kr.ac.kopo.bookshop.model.Detail;
import kr.ac.kopo.bookshop.model.Orders;

public interface DetailDao extends Repository<Detail, Integer> {

	void save(Detail detail);
	
}
