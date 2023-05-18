package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args){
        // 애플리케이션 로딩시점에 딱 하나만 만들어야함
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // entitiyManager가 꺼내지는지 확인
        // 디비에 저장하는 트랜잭션 단위마다는 Manager를 생성해야함
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        // 디비를 실행하는 데 있어서는 트랜잭션이란 단위가 중요 꼭 시작하여야 에러가 나지 않음
        tx.begin();

        try {

            tx.commit();
        } catch (Exception e){
            // 에러시 롤백
            tx.rollback();
        } finally {
            // entityManager 종료 또한 중요하다.
            em.close();
        }

        emf.close();
    }
}
