package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
// 의존관계를 주입 받을 때 생성자 코드 없이 주입 받을 수 있게 하는 Lombok 어노테이션
@RequiredArgsConstructor
public class MemberController {


    private final MemberService memberService;

//     @Autowired - 의존관계를 주입해주는 역할
//          클래스 내에 생성자가 하나만 있으면 생략이 가능한다.
//    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }

}
