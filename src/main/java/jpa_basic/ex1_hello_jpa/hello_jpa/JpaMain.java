package jpa_basic.ex1_hello_jpa.hello_jpa;

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
		tx.begin(); //트랜잭션 시작 
			
		Member member = new Member();
		member.setId(1L);
		member.setName("HelloA");
		
		tx.commit();
		
		em.persist(member); //이러면 저장되는 거임 
		
		em.close();
		
		emf.close();
		
		
	}
}
