package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity","street","10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1","street","10000"));
            member.getAddressHistory().add(new AddressEntity("old2","street","10000"));

            em.persist(member); // member만 persist했을 뿐인데 Address와 Favorite_Food 도 자동으로 DB에 반영되었다. ( = 생명주기가 member에 의존되어있다.

            em.flush();
            em.clear();

            System.out.println("============start===============");
            Member findMember = em.find(Member.class, member.getId()); // select문을 날렸을때 Address, Favorite_Food를 다가져오는것이 아닌 Member만 가져온다 ( = 지연 로딩 )

            // homeCity -> newCity (Update)
//            findMember.getHomeAddress().setCity("newCity"); XXX
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity",a.getStreet(),a.getZipcode())); // Address를 새로 만들어줘야함

            // 치킨 -> 한식 (Update)
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddressHistory().remove(new AddressEntity("old1","street","10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1","street","10000"));

            tx.commit();

//            String name = "hello";
//
//            name = "member1";
//
//            Address address = new Address("city", "street", "10000");
//
//            Member member = new Member();
//            member.setUsername(name);
//            member.setHomeAddress(address);
//            em.persist(member);
//
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(address);
//            em.persist(member2);
//
//            // 부작용 발생 ( member 의 City만 newCity로 바꾸고싶었지만 member2 도 바뀜 )
//            member.getHomeAddress().setCity("newCity");
//
//            tx.commit();
//
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);
//
//            tx.commit();

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            team.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();

//            Member m = em.find(Member.class, member1.getId()); // 프록시로 가져옴

//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList(); // TEAM 이 EAGER이라면 멤버의 갯수만큼


//            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//
//            System.out.println("====================");
//            m.getTeam().getName(); // 직접적으로 getName 을 요청했으므로 초기화 되면서 Team을 가져옴
//            System.out.println("====================");

//            tx.commit();

//            Member member2 = new Member();
//            member1.setUsername("hello2");
//            em.persist(member2);

//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass()); // Proxy Member ..?
//
//            System.out.println("a == a:" + (refMember == findMember)); // true

//            Member m2 = em.getReference(Member.class, member2.getId());

//            System.out.println("m1 == m2 : " + (m1 instanceof Member));
//            System.out.println("m1 == m2 : " + (m2 instanceof Member));


//            Member findMember = em.getReference(Member.class, member.getId());
//            Member findMember = em.find(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getClass()); // Hibernate가 만든 가짜 클래스
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = " + findMember.getUsername());

//            Member member = em.find(Member.class, 1L);
//
//            printMember(member);
//
//            printMemberAndTeam(member);

//            Member member = new Member();
//            member.setCreatedBy("kim");
//            member.setCreateTime(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            tx.commit();

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);
//
//            tx.commit();

//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);

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

//            tx.commit(); // 한 트랜잭션 종료
        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close(); // em 종료
        }

        emf.close(); // emf 종료
    }

    // 프록시 할때 썼었던 메소드 들
//    private static void printMember(Member member) {
//        System.out.println("member = " + member.getUsername());
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }
}
