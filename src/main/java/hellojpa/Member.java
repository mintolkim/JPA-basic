package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
// jpa를 사용하는 애구나 라고 인식
public class Member {
    @Id
    private long id;
    @Column(name = "name") // DB 컬럼명은 name
    private String username;
    private Integer age; // DB에도 적절한 숫자 타입 선택됨

    // 객체에서 enum 타입을 쓰고싶다면
    // DB에는 enum 타입이 없다.
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜 타입을 쓰고 싶다면
    // 타입은 3가지가 있다. (데이터베이스에는 구분되있기때문에)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 큰 데이터
    @Lob
    private String description;

    public Member() {
    }

}
