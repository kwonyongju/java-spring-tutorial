package yjkwon.springtutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yjkwon.springtutorial.repository.JdbcMemberRepository;
import yjkwon.springtutorial.repository.MemberRepository;
import yjkwon.springtutorial.service.MemberService;

import javax.sql.DataSource;


// Manually register objects to Spring bean
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
