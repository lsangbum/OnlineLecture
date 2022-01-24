package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded //내장타입이기 때문에 적어주어야한다.
    private Address address;

    @Enumerated(EnumType.STRING) //EnumType 은 ORDINAL STRING 이 있는데 ORDINAL은 상태가 1,2 이렇게 숫자로 들어가며 다른 상태발생시 XXX및 다른상태로 값이 들어간다.
    private DeliveryStatus status; //READY, COMP
}//class
