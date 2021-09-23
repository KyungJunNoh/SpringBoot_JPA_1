package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "MBR")
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, unique = true) // 데이터베이스에 name 이라는 이름으로 매핑
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum의 이름을 DB에 저장
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) // DB에 시간을 년-월-일-시-분-초 단위로 저장
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP) // DB에 시간을 년-월-일-시-분-초 단위로 저장
    private Date lastModifiedDate;

    @Lob // 데이터베이스에서 VARCHAR보다 큰 데이터를 담고 싶을 때 사용한다.
    private String description;

    public Member(){

    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
