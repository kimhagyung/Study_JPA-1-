package jpa_basic.ex1_hello_jpa.hello_jpa;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator; 
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
@SequenceGenerator(name="member_seq_generator", sequenceName="member_seq")
public class Member {
	
	 @Id //내가 직접 기본키를 설정한다. 
	//자동 생성은 @GeneratedValue를 사용하면 된다.
	//@GeneratedValue(strategy = GenerationType.AUTO)   //기본값이 auto이다 . auto로 설정하면 디비방언에 맞춰 TABLE, SEQUENCE,IDENTITY 중에 하나를 자동으로 선택하게됨
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //mysql로 치면 autoincrement 같은 개념이다.
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //시퀀스를 만든다.
	private Long id; 
	
	 @Column(name = "name",nullable = false)
	 private String username;
	  
	public Member() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
