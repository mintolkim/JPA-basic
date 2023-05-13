package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// jpa를 사용하는 애구나 라고 인식
public class Member {
    @Id //
    private long id;
    private String name;
}
