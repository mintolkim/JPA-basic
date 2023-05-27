package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class jpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("city1","street","zipcode"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("족발");

            member.getAddresses().add(new AddressEntity("old1","street","zipcode"));
            member.getAddresses().add(new AddressEntity("old2","street","zipcode"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("========== START =========== ");
            Member findMember = em.find(Member.class, member.getId());

            // city1 -> newCity
            // findMember.getHomeAddress().setCity("newCity");
            // Address old = findMember.getHomeAddress();
            // findMember.setHomeAddress(new Address("newCity", old.getStreet(), old.getZipcode()));

            // 값 컬렉션 수정 ( 이 또한 값타입이 때문에 지우고 다시 넣어야함 )
            // 치킨 -> 한식
            // findMember.getFavoriteFoods().remove("치킨");
            // findMember.getFavoriteFoods().add("한식");

            // equals 를 이래서 구현해야함
            // old1 -> new City
            //findMember.getAddresses().remove(new Address("old1","street","zipcode"));
            //findMember.getAddresses().add(new Address("new City","street","zipcode"));

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
