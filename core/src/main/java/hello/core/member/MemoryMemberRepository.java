package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    //동시성 이슈가 발생할 수 있어서 ConcurrentHashMap 을 사용해야한다.
    private static Map<Long, Member> store = new HashMap<>();

    /**
     * 회원저장
     */
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    /**
     * 회원조회
     */
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
