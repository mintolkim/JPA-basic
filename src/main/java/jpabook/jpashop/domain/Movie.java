package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Movie extends Item{
    private String direct;
    private String actor;
}