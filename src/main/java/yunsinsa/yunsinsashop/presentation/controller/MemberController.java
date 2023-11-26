package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.service.MemberService;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    /**
     *  회원 생성
     */
    @PostMapping
    public MemberDto.CreateResponse createMember(@Validated @RequestBody MemberDto.CreateRequest request) {
        return memberService.createMember(request);
    }

    /**
     *  선택 회원 조회
     * @param id 조회할 회원의 아이디
     *
     */
    @GetMapping("/{id}")
    public MemberDto.FindResponse findResponse(@PathVariable Long id){
        return memberService.findMember(id);
    }

    /**
     * 모든 회원 조회
     */
    @GetMapping("/all")
    public List<MemberDto.FindResponse> findResponses(){
        return memberService.findAllMembers();
    }

    /**
     *
     * 회원 수정
     */
    @PutMapping("/update/{id}")
    public void updateMember(@RequestBody MemberDto.UpdateRequest request) {
    memberService.updateMember(request);
    }

    /**
     * 회원 삭제
     * @param id 삭제를 하기 위한 회원의 아이디
     */
    @DeleteMapping("delete/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
