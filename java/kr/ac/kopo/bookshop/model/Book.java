package kr.ac.kopo.bookshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// 엔티티 = 저장되어야하는 덩어리
@Entity
// 테이블명 기술
@Table(name="book")
public class Book {
	// 기본키
	@Id
	// 자동 증가 값과 이에 대한 설정을 기술
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;

	public int getBookid() {
		return bookid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
