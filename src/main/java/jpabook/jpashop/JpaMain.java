package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 주문했다고 예시들고
            /* Order order = em.find(Order.class, 1L);
            Long memeberId = order.getMemberId();

            // 찾은걸 넣어서 또 찾아야함
            // 객체지향스럽지 않다.
            // 지금 같은 설계는 관계형 디비 쪽에 맞춰서 설계 한 것
            em.find(Member.class ,memeberId); */

            // 이게 더 객체지향적
            // Member findMemeber = order.getMemeber();


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
