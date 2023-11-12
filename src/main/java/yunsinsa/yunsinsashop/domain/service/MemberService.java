
package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yunsinsa.yunsinsashop.domain.entity.Member;
import yunsinsa.yunsinsashop.domain.model.Address;
import yunsinsa.yunsinsashop.domain.repository.MemberRepository;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto.CreateResponse createMember(MemberDto.CreateRequest request) {
        Member newMember = Member.builder()
                .name(request.getName())
                .address(
                        Address.builder()
                                .city(request.getCity())
                                .street(request.getStreet())
                                .state(request.getState())
                                .zipcode(request.getZipcode())
                                .build()
                )
                .email(request.getEmail())
                .build();

        Member savedMember = memberRepository.save(newMember);

        return MemberDto.CreateResponse.builder()
                .name(savedMember.getName())
                .street(savedMember.getAddress().getStreet())
                .city(savedMember.getAddress().getCity())
                .state(savedMember.getAddress().getState())
                .zipcode(savedMember.getAddress().getZipcode())
                .email(savedMember.getEmail())
                .build();
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

  //   모든 회원 조회
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

        member.change(request.getName(), request.getEmail(), request.getPassword());

    }

    // 회원 삭제
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        memberRepository.delete(member);
    }
}

