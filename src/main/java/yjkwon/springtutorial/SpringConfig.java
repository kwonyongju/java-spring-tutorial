package yjkwon.springtutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjkwon.springtutorial.repository.MemberRepository;
import yjkwon.springtutorial.repository.MemoryMemberRepository;
import yjkwon.springtutorial.service.MemberService;


// Manually register objects to Spring bean
@Configuration
public class SpringConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
