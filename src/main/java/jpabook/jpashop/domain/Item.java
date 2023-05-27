package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;

    private int stockQuanity;



}
