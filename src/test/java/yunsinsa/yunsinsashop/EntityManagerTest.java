package yunsinsa.yunsinsashop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import yunsinsa.yunsinsashop.domain.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootTest
public class EntityManagerTest {

    private static final String PERSISTENCE_UNIT_NAME = "yunshinshop";

    @Test
    void entityManagerTest() {
        // 순수 JPA 사용 시 정석 코드
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
//            member.setId(1L);
            member.setName("Jungho");
            em.persist(member);
//Persistence:애플리케이션과 데이터베이스 사이에 영속성 컨텍스트(Persistence Context)라는 개념(공간)을 두고 데이터를 관리
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    void test2() {
        /*
  아래 어노테이션의 내용은 위에 내용      
        @Transactional
        void createMember() {
            Member member = new Member();
            member.setName("Jungho");
            repository.save(member)
        }
         */
    }
}
