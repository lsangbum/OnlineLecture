package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository // component-scan의 대상이므로 spring 이 해당 Entity 를 spring bean 에 등록한다.
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext //JPA 표준 어노테이션 spring data jpa 가 Autowired 를 사용가능하게 해줌 고로 requiredArgsConstructor 사용 생략가능
    //spring 이 EntityManager 를 만들어서 injection 을 해줌
    private final EntityManager em;

    /**
     * 회원 가입
     */
    public void save(Member member) {
        em.persist(member);
    }

    /**
     *  회원 단일 조회
     */
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    /**
     *  회원 전체 조회
     */
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();   //기존 sql 과 차이가 있다. Entity 를 대상으로 문법이 짜여진다. from 의 대상이 테이블이 아닌 Entity가 된다.
    }

    /**
     * 회원 이름으로 조회
     */
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}//class
