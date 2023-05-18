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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team); 
            em.persist(member);

            // DB 에서 쿼리를 보고 싶다 test 할려면
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members){
                System.out.println("m = "+ m.getUsername());
            }

            Team newTeam = em.find(Team.class, 100L);
            findMember.setTeam(newTeam);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
