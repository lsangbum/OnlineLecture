package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 한다.")
    public void vip_o() throws Exception {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }//할인금액확인

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 한다.")
    public void vip_x() throws Exception {
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);


        //then
        assertThat(discount).isEqualTo(0);

    }//할인금액 실패테스트

}//class