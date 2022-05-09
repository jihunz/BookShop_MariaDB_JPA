package kr.ac.kopo.bookshop.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int orderid;
	private int saleprice;
	private int custid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate = new Date();

	// orders 테이블 입장에서의 customer에 대한 '다 대 1' 관계이므로 Many To One
	@ManyToOne
	// join은 검색 시에만 사용하므로 '삽입', '수정'시에는 false로 설정하여 join하지 않음
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	// JPA는 도메인 중심이기 때문에 join을 위해선 하나의 키가 아닌 객체 필요 -> join을 통해 얻는 cutomer 테이블을 객체로 저장
	private Customer customer;

	@OneToMany
	@JoinColumn(name = "orderid", insertable = false, updatable = false)
	private List<Detail> detail;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getSaleprice() {
		return saleprice;
	}

	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}
}
