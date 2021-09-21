package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("Hello JPA");
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }

              // insert
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== After ===");
//            Member findMember = em.find(Member.class, 101L);

//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());


//            Member findMember1 = em.find(Member.class, 101L); // 첫번째 조회 // select쿼리를 이용하여 DB에서 정보를 가져옴
//            Member findMember2 = em.find(Member.class, 101L); // 두번째 조회 // 영속성 컨텍스트에 이미 저장되어있는 정보를 불러와 Select 쿼리를 사용하지 않음
//            System.out.println("result = " + (findMember1 == findMember2)); // 같은 트랜잭션 에서 실행된 member은 동일성을 보장시킴.


            // 영속
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            em.persist(member1); // 커밋을 하기 전까진 영속성 컨텍스트에 임시 저장
//            em.persist(member2); // 커밋을 하기 전까진 영속성 컨텍스트에 임시 저장
//            System.out.println("=====================================");

            // 엔티티 수정 (더티 체킹)
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ"); // 커밋을 했을때 변경점이 있다면 update 쿼리를 날려줌
            System.out.println("======================");

            tx.commit(); // 한 트랜잭션 종료
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); // em 종료
        }

        emf.close(); // emf 종료
    }
}
