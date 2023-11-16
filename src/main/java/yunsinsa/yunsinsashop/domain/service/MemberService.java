
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
                .name(member.getName())
                .email(member.getEmail())
                .build();

        return response;
    }

  //   모든 회원 조회
    public List<MemberDto.FindResponse> findAllMembers() {
        List<Member> members = memberRepository.findAll(); //모든회원조회라서 다 찾고
        List<MemberDto.FindResponse> responses = new ArrayList<>(); // 리스트로 목록만듬

        for (Member member : members) {  // dto에 맞게 반복문을 돌려서 회원 목록을 만듬
            MemberDto.FindResponse response = MemberDto.FindResponse.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .build();
            responses.add(response);
        }
        return responses;
    }

    // 회원 수정
    public void updateMember(MemberDto.UpdateRequest request) {
        Member member = memberRepository.findById(request.getId()) // id를 db에서 찾아서 조회를 함
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        //주소 정보 업데이트가 필요함 (그냥 address로는 안되서 dto에 맞게 업뎃address로 처리함)
        Address newAddress = Address.builder()
                .street(request.getStreet())
                .city(request.getCity())
                .state(request.getState())
                .zipcode(request.getZipcode())
                .build();

        // 멤버 엔티티에서 수정 요청 처리
        member.change(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                newAddress
        );

        // 저장
        memberRepository.save(member);
    }


    // 회원 삭제
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        memberRepository.delete(member);
    }
}

