package jpa_basic.ex1_hello_jpa.hello_jpa;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne; 
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
public class Member extends BaseEntity{
	
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	 private Long id;
	 
	@Column(name = "USERNAME") 
	 private String name;
	  
	//다대일 양방향 관계임. (약간 억지스러움)
	//name="TEAM_ID" 이거를 쓴다는것부터 연관관계 주인 같은데 문제는 Team에 이미 연관관계 주인이 있다. 
	//근데 insertable = false, updatable = false 이 있으면 강제로 읽기 전용으로 해버림 
	@ManyToOne
	@JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
	private Team team;
	 
	@OneToOne //일대일 관계임 
	@JoinColumn(name = "LOCKER_ID")
	private Locker locker;
	
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

	public Team getTeam() {
		return team;
	}
	 
	 
	 
}
