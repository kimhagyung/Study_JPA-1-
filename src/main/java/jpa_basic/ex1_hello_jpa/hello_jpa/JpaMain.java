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
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			Member member = new Member();
			member.setName("member1");
			member.setTeamId(team.getId()); //외래키 식별자를 그대로 다루고 있음.
			em.persist(member);
			
			
			//연관관계가 없기 떄문에 번거롭게 됨 계속 참조해야됨 
			Member findMemeber = em.find(Member.class, member.getId());
			Long findTeamId =  findMemeber.getTeamId();
			Team findTeam = em.find(Team.class, findTeamId); 
			
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
