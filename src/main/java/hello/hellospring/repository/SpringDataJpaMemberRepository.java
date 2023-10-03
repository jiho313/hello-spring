package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// 객체와 pk의 타입
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // ... Spring Data JPA가 MemberRepository 인터페이스의 메소드들을 자동으로 구현
    @Override
    Optional<Member> findByName(String name);
}

