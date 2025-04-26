package jpa_basic.ex1_hello_jpa.hello_jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //디비 연결 됨 
		EntityManager em =emf.createEntityManager();
		//jpa에서는 트랜잭션이 매우 중요함 무조건 넣어줘야된다고 함 
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {   
			
			Member member=new Member();
			member.setName("member1");
			
			em.persist(member);
			
			Team team=new Team();
			team.setName("teamA");
			
			//일대다일 떄 여기가 좀 애매해짐 
			//연관관계가 바뀌는것. 여기의 외래키느 team테이블이 아닌 member테이블에있기 떄문임
			//그래서 옆 테이블로 가서 update쿼리가 한번 더 나간다. (성능상 엄청 차이나진 않지만,,애매 !)
			//이 관계를 잘 사용하지 않는 이유는 추적하기가 애매함. 나는 team테이블을 insert했는데 왜 member테이블에 대한 
			//update 쿼리가 나가지? 하는 식으로 돼서 
			//일대다 단방향에서 member가 team방향으로 갈 일 없다고 해도 그냥 객체지향적으로 좀 손해를 보더라도 (그니깐 member에서 팀으로 갈 일 이 없더라도 !)\
			//그냥 member를 그냥 객체주인으로 하듯이 !! 
			team.getMembers().add(member);
			
			em.persist(team);
			
			 tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
