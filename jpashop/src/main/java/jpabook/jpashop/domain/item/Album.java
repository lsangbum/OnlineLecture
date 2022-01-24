package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //기본값은 class명이 들어감
@Getter
@Setter
public class Album extends Item{

    private String artist;
    private String etc;
}//class
