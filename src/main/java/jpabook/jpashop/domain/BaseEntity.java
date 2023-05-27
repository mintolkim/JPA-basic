package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    private String regsDate;
    private String modifyDate;
}
