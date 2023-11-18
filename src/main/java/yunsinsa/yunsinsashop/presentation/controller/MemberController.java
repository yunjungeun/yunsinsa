package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.service.MemberService;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

@RequiredArgsConstructor //final 으로 쓰인 대상자에 관해서 생성자를 만든다
@RestController
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

//회원 정보수정
    @PutMapping
    public void updateMember(@RequestBody MemberDto.UpdateRequest request){
    memberService.updateMember(request); }

//회원 삭제
    @DeleteMapping
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

}
