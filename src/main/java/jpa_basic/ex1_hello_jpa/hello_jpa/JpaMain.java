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
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("member1");
			member.setTeam(team);
			em.persist(member);
			
			em.flush();
			em.clear(); //이거 두개를 하면 영속성컨텍스트를 초기화 시켜버려서 콘솔에 쿼리가 뜬다 
			
			Member findMemeber = em.find(Member.class, member.getId());
			List<Member> members= findMemeber.getTeam().getMembers(); //양방향 매핑 됨 
			
			for(Member m:members) {
				System.out.println("m = " + m.getName());
			}
			
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
