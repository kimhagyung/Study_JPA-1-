package jpa_basic.ex1_hello_jpa.hello_jpa;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.JOINED) 
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //단일 테이블전략   
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) //Item 테이블이 생성안됨 . 그냥 나머지 3개 album, movie, book만 생성ㅅ됨    
@DiscriminatorColumn
public class Item {
	
	 @Id @GeneratedValue	
	 private Long id;
	 private String name;
	 private int price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
