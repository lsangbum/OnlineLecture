package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    //생성자가 하나 일 경우 @Autowired 생략
    //@RequiredArgsConstructor 이 붙으면 final 이 붙은 인자가 파라미터로 들어간 생성자가 자동으로 생성된다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 할인율 구해서 Order 객체 반환
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }//createOrder

    /**
     * 각기 다른 객체에서 호출 시 싱글톤 테스트용도
     */
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}//class
