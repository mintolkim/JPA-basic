package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

public class Catergory extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Catergory parent; // 상위 카테고리

    @OneToMany(mappedBy = "parent")
    private List<Catergory> chulde = new ArrayList<>();


}
