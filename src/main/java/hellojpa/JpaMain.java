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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

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
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA"); // 커밋을 했을때 변경점이 있다면 update 쿼리를 날려줌
//            System.out.println("======================");

            // flush 는 영속성 컨텍스트를 비우는것이 아닌 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화시키는 역할임
//            em.flush(); // 이 위에 있는 쿼리들이 flush로 인해 쿼리가 날라감

            // 준 영속상태
//            em.detach(member); // Entity를 준영속상태로 만들어 영속성 컨텍스트에서 관리하지않는 형태로 만듬
//            em.clear(); // 이것또한 준영속상태로 만들어주는 메소드

            // 정리 ( 영속성 컨텍스트의 이점 )
            // 1. 1차 캐시
            // 2. 동일성 보장
            // 3. 트랜잭션을 지원하는 쓰기 지연
            // 4. 변경 감지 ( 더티 채킹 )
            // 5. 지연 로딩 ( LAZY Loading )

//            Member member = new Member();
//            member.setUsername("C");
//
//            System.out.println("=============================");
//            em.persist(member); // Id 속성인 strategy = GenerationType.IDENTITY 때문에 persist 하는 즉시 DB에 INSERT 쿼리 적용
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("=============================");

            tx.commit(); // 한 트랜잭션 종료
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close(); // em 종료
        }

        emf.close(); // emf 종료
    }
}
