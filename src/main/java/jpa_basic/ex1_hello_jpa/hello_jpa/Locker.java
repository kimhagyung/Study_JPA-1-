package jpa_basic.ex1_hello_jpa.hello_jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class Locker {

	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy = "locker") //일대일 양방향 
	private Member member;
}
