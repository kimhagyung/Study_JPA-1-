package jpa_basic.ex1_hello_jpa.hello_jpa;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
public class Member {
	
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	 private Long id;
	 
	@Column(name = "USERNAME") 
	 private String name;
	 
//	 @Column(name = "TEAM_ID")
	// private Long teamId; //객체를 테이브 ㄹ중심으로 만들어 버린 예 
	 //그니깐 테이블의 외래키 인데 이걸 entity에 고대로 박아버린 셈 ! 

	@ManyToOne //다대일 (멤버:팀)
	@JoinColumn(name = "TEAM_ID") //조인 컬럼 적어주기 
	private Team team;
	
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

	public void setChangTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}
 
	 
	 
	 
}
