package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}