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
			//연관관계의 주인 아님 
			Team team = new Team();
			team.setName("TeamA");
			//team.getMembers().add(member); //team은 연관관계의 주인이 아니기 떄문에 이렇게 해도 
			//DB의 값은 변경되지 않고 null로 되게 됨 .! 
			em.persist(team);
			
			//연간관계의 주인임 
			Member member = new Member();
			member.setName("member1");
			member.setChangTeam(team); //주인쪽에서 변경해주면됨   
			em.persist(member);
			
			//team.getMembers().add(member); //결론.. 근데 사실 
			//이렇게 양쪽에 다 세팅 해주는게 맞음
			//근데 사실 늘 이렇게 양쪽으로 호출하는걸 까먹을 수있으니 Member 엔티티에 
			//setChangTeam 에서 team.getMembers().add(this); 이거 추가하면 양쪽에 됨 
			
			em.flush();
			em.clear(); //이거 두개를 하면 영속성컨텍스트를 초기화 시켜버려서 콘솔에 쿼리가 뜬다
			
			Team findTeam=em.find(Team.class, team.getId());
			List<Member> members=findTeam.getMembers();
			
			for(Member m :members) {
				System.out.println("m = "+m.getName());
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
