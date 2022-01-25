package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    /**
     * @return memberService 의 구현체 생성 파라미터는 현재 사용중인 저장소
     */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    /**
     * @return 저장소 구현체
     */
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * @return OrderService 의 구현체 생성 파라미터는 현재 사용중인 저장소와 할인정책
     */
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    /**
     * @return 할인정책 구현체
     */
    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}//class
