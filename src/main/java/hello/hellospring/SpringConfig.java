package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    // SpringData가 JpaRepository를 컨테이너에 Bean으로 등록해주기 때문에 DI(주입)할 수 있다.
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // AOP를 이렇게 Bean으로 직접 등록해도 되고 클래스에서 @Component어노테이션으로 등록해도 된다.
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
    // 인터페이스를 통해 구현하여 확장했기 때문에 db엑세스 방법을 쉽게 변경할 수 있다.
    // 사용할 인터페이스 구현체를 생성하여 반환하는 메소드를 빈으로 등록해준다.
    // SpringDataJpa를 사용할 경우 이 메소드는 사용하지 않는다.
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}