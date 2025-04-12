package jpa_basic.ex1_hello_jpa.hello_jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*; 
import java.util.Date;
@Entity //필수임 ! 붙이면 jpa가 관리하는 테이블이라는것
public class Member {
	
	@Id
	 private Long id; 
	
	 @Column(name = "name")
	 private String username;
	 
	 private Integer age;
	 
	 @Enumerated(EnumType.STRING)
	 private RoleType roleType;
	 
	 @Temporal(TemporalType.TIMESTAMP) //매핑정보 ! DATE, TIMESTAMP, TIME 3가지가 있따.
	 private Date createdDate;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date lastModifiedDate;
	 
	 @Lob //varchar를 넘어서는 큰 컨텐츠에 사용한다.
	 private String description;
	
	Member(){ //생성자 필수 ! 
	}
	 
	
	
	
}
