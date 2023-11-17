package yunsinsa.yunsinsashop.presentation.controller;

import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.service.MemberService;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

//회원 등록
@PostMapping
public MemberDto.CreateResponse createMember(@RequestBody MemberDto.CreateRequest request){
 return memberService.createMember(request);
}
//회원 조회
@GetMapping
public MemberDto.FindResponse findResponse(@PathVariable Long id){
    return memberService.findMember(id);
}

}
