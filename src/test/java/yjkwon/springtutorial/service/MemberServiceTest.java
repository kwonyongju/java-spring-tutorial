package yjkwon.springtutorial.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yjkwon.springtutorial.domain.Member;
import yjkwon.springtutorial.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService service;
    MemoryMemberRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new MemoryMemberRepository();
        service = new MemberService(repository);
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("member10");

        //when
        Long savedId = service.join(member);

        //then
        Member findMember = service.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void joinWithDuplicate() {
        //given
        Member member1 = new Member();
        member1.setName("member1");

        Member member2 = new Member();
        member2.setName("member1");

        //when
        Long member1Id = service.join(member1);

        //then
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class, () -> service.join(member2));
        assertThat(e.getMessage()).isEqualTo("The member already exists");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}