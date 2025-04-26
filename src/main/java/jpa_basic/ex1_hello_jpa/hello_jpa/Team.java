package jpa_basic.ex1_hello_jpa.hello_jpa;
 

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany; 
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
public class Team {
	 @Id @GeneratedValue
   	 @Column(name="TEAM_ID")
	 private Long id;
	 private String name;
	 
	 @OneToMany(mappedBy = "team") //team클래스에 team이라는 변수에 의해 매핑이 되어진다.
	private List<Member> members =new ArrayList<>();
	 
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
