package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

       // entitiyManager가 꺼내지는지 확인
       EntityManager em = emf.createEntityManager();

       em.close();
       emf.close();

    }
}