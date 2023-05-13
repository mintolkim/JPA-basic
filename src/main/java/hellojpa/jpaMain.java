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
            // INSERT
            /* Member member = new Member();
            member.setId(2L);
            member.setName("HELLO");
            em.persist(member);*/

            // UPDATE
            // em 를 java 컬렉션 처럼 생각하기
            /* Member findMember = em.find(Member.class, 1L);
            findMember.setName("HELLO JPA"); */

            // em.persist(findMember); -> 이거 해야하나요? 아뇨!!
            // 왜냐면 자바 컬렉션 다루듯이 다루면 된다

            // 삭제
            /* Member findMember = em.find(Member.class, 1L);
            em.remove(findMember); */

            // 전체 조회
            Member member = new Member();
            // 테이블 대상으로 코드를 짜는 것이 아닌 객체 대상을 쿼리로 짬
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                            .setFirstResult(5)
                            .setMaxResults(10)
                            .getResultList();
            for (Member members : result){
                System.out.println("member.name" + members.getName());
            }
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
