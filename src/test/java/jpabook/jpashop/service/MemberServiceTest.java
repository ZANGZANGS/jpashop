package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("회원가입")
    @Rollback(value = false)
    public void 회원가입(){
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long id = memberService.join(member);
        
        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(id));
    }
    @Test
    @DisplayName("중복_회원_예와")
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);

        try {
            memberService.join(member2); // 예외가 발생해야 한다!!!
        } catch (IllegalStateException e) {
            return;
        }


        //then
        fail("예외가 발생해야 한다.");

    }
}