package jpa_basic.ex1_hello_jpa.hello_jpa;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
public class Member {
	
	@Id
	 private Long id; 
	
	 @Column(name = "name",nullable = false)
	 private String username;
	 
	 private int  age;
	 
	@Enumerated(EnumType.STRING) //enum의 타입값이 들어감 예를들어 타입이 admin이면 RoleType 칼럼에 admin이 저장됨
	 // @Enumerated //이렇게 하면 ORDINAL인데 enum타입에서는 ORDINAL 사용 하면안됨
	//enum의 배열값이 들어가는데 이렇게 하면 꼬임 
  	 private RoleType roleType;
	 
	 @Temporal(TemporalType.TIMESTAMP) //매핑정보 ! DATE, TIMESTAMP, TIME 3가지가 있따.
	 private Date createdDate;
	 
	 //하이버네이트 최신버전을 사용했을 떄는 위의 방식 말고 아래 LocalDate로 하기 
	 private LocalDate testLocalDate; //년월일 
	 private LocalDate testLocalDateTIme; //년월일시간 
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date lastModifiedDate;
	 
	 @Lob //varchar를 넘어서는 큰 컨텐츠에 사용한다.(cLob)
	 private String description;
	
	 @Transient //이렇게 해두면 사용하지 않는다는걸 의미한다.! 
	 private int temp; //메모리에서만 사용하겠다는 의미이다 
	 
	Member(){ //생성자 필수 ! 
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	 
	
	
	
}
