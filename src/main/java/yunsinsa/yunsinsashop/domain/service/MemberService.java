package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.entity.Member;
import yunsinsa.yunsinsashop.domain.repository.MemberRepository;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto.CreateResponse createMember(MemberDto.CreateRequest request){

        Member newMember = Member.builder()
                .name(request.getname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        Member savedMember = memberRepository.save(newMember);

        MemberDto.CreateResponse response = MemberDto.CreateResponse.builder()
                .id(savedMember.getId())
                .username(savedMember.getUsername())
                .email(savedMember.getEmail())
                .build();

        return response;

    }

    // 회원 조회
    public MemberDto.FindResponse findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        MemberDto.FindResponse response = MemberDto.FindResponse.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .build();

        return response;
    }

    // 모든 회원 조회
    public List<MemberDto.FindResponse> findAllMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberDto.FindResponse> responses = new ArrayList<>();

        for (Member member : members) {
            MemberDto.FindResponse response = MemberDto.FindResponse.builder()
                    .id(member.getId())
                    .username(member.getUsername())
                    .email(member.getEmail())
                    .build();
            responses.add(response);
        }

        return responses;
    }

    // 회원 수정
    public void updateMember(MemberDto.UpdateRequest request) {
        Member member = memberRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        member.change(request.getname(), request.getEmail(), request.getPassword());

    }

    // 회원 삭제
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        memberRepository.delete(member);
    }

