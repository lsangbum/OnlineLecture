package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class  MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        //name 중복검사
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }//join

    /**
     * 회원중복검증코드
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }//validateDuplicateMember

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }//findMembers

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }//findOne

}//class
