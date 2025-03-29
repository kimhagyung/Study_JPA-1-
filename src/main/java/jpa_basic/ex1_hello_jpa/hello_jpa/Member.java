package jpa_basic.ex1_hello_jpa.hello_jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //필수임 
public class Member {
	
	@Id
	private Long id;
	private String name;
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
	
	
}
