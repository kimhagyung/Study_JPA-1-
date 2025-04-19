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
			member.setTeam(team);
			em.persist(member);
			
			em.flush();
			em.clear(); //이거 두개를 하면 영속성컨텍스트를 초기화 시켜버려서 콘솔에 쿼리가 뜬다 
			
			//연관관계가 없기 떄문에 번거롭게 됨 계속 참조해야됨 
			Member findMemeber = em.find(Member.class, member.getId());
			Team findTeam = findMemeber.getTeam(); //바로 팀을 받아오면 됨 
			System.out.println("findTeam = "+findTeam.getName());
			
			//연관관계 수정 
			Team newTeam = em.find(Team.class, 100L);
			findMemeber.setTeam(newTeam); //이러면  Member테이블의 연관관계 수정이 가능하다
			
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
