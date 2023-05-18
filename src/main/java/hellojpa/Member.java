package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;

    // 여기서 중요
    /* @Column(name = "TEAM_ID")
    private Long teamId; */

    @ManyToOne // member 입장에선 Many team 입장에선 one
    @JoinColumn(name = "TEAM_ID") // member 객체와 member db테이블의 fk 의 team_id 와 맵핑해야함
    private Team team;
    public Member() {
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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); //이 this가 내 자신 인스턴스
    }
}
