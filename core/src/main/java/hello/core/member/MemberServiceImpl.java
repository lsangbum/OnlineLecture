package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 회원조회
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}//class
