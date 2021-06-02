package yjkwon.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjkwon.springtutorial.repository.MemberRepository;
import yjkwon.springtutorial.service.MemberService;


// Manually register objects to Spring bean
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // JPA
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        // Spring data JPA
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop TimeTraceAop() {
//        return new TimeTraceAop();
//    }
}
