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
		tx.begin();
		try {
			//영속 
			
			Member member =em.find(Member.class, 150L);
			member.setName("AAAA");
			
			em.detach(member); //준영속상태 
			//영속성컨텍스트에서 뗴어내는것 즉 , jpa에서 관리를 하지 않느것 
			//실행하면 아무일도 일어나지 않음 
			//select 쿼리만 나오고 insert는 안나옴 
			
			
			System.out.println("================");
			
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
