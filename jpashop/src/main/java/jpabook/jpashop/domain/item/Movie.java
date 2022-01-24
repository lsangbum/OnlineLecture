package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M") //기본값은 class명이 들어감
@Getter
@Setter
public class Movie extends Item{

    private String director;
    private String actor;
}//class
