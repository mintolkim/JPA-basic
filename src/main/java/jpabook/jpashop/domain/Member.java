package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @Column(name = "member_id") // 이름 쓰는 건 대문자, 소문자는 회사마다 룰이 있다.
    @GeneratedValue // 생략할 경우 auto
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
    
    // 왠만하면 setter 를 만들지 말고 생성자에서 값을 세팅하고
    // setter는 최소화 하는데 코드추척하기, 유지 보수하기 좋다
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
