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
	 
	 @OneToMany(mappedBy = "team") //팀에서 멤버로 가는건 일대다임
	 //mappedBy 는 현재 member에서 뭐랑 변수가 걸려있는지 ! member 엔ㅌ니티에서는 team이라는이름의 변수랑 매핑되어있음
	 //mappedBy를 사용하면 주인을 지정한다는것임 
	 private List<Member> members=new ArrayList<>();
	 
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
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	 
}
