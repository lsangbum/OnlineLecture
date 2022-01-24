package hello.core.member;

public interface MemberRepository {

    /*회원저장*/
    void save(Member member);

    /*회원조회*/
    Member findById(Long memberId);

}
