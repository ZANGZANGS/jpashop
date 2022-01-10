package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
        //커맨드랑 쿼리를 분리해라, 저장을 하고 난 뒤 사이드 이펙트를 발생시킬 커맨드 성이기에 아이디 정도만 반환한다.
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
