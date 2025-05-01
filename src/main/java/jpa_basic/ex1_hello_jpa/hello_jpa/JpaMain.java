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
			 Movie movie = new Movie();
			 movie.setDirector("aaaa");
			 movie.setActor("bbb");
			 movie.setName("바람과 함께 사라지다");
			 em.persist(movie);
			 
			 em.flush();
			 em.clear(); //영속성 컨텍스트 값 날림 1차캐시에 ㄴ안남음 
			 
			 Movie findMove=em.find(Movie.class, movie.getId());
			 System.out.println("findMove ="+ findMove );//조인할 때 조인까지 해준 쿼리가 나옴 
			 
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
