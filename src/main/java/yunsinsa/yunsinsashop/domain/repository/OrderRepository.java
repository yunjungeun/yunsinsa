package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
