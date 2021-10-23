package hellojpa;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Table (name = "MBR")
@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    private String createdBy;
    private LocalDateTime createTime;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Column(name = "TEAM_ID")
//    private Long teamId;
//
//    @Column(name = "name", nullable = false, unique = true) // 데이터베이스에 name 이라는 이름으로 매핑
//    private String username;
//
//    private Integer age;
//
//    @Enumerated(EnumType.STRING) // enum의 이름을 DB에 저장
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP) // DB에 시간을 년-월-일-시-분-초 단위로 저장
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP) // DB에 시간을 년-월-일-시-분-초 단위로 저장
//    private Date lastModifiedDate;
//
//    @Lob // 데이터베이스에서 VARCHAR보다 큰 데이터를 담고 싶을 때 사용한다.
//    private String description;

}
