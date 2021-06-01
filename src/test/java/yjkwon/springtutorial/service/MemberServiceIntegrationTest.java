package yjkwon.springtutorial.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yjkwon.springtutorial.domain.Member;
import yjkwon.springtutorial.repository.MemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("member3");

        //when
        Long savedId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void joinWithDuplicate() {
        //given
        Member member1 = new Member();
        member1.setName("member5");

        Member member2 = new Member();
        member2.setName("member5");

        //when
        Long member1Id = memberService.join(member1);

        //then
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("The member already exists");
    }
}
