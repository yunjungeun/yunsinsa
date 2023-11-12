package yunsinsa.yunsinsashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yunsinsa.yunsinsashop.domain.entity.Member;
import yunsinsa.yunsinsashop.domain.repository.MemberRepository;
import yunsinsa.yunsinsashop.presentation.dto.MemberDto;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDto.CreateResponse createMember(MemberDto.CreateRequest request){

        Member newMember =
    }

}
