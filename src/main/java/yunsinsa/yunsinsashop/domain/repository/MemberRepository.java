package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yunsinsa.yunsinsashop.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
