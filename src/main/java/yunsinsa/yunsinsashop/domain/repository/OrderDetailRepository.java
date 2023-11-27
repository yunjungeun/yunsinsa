package yunsinsa.yunsinsashop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunsinsa.yunsinsashop.domain.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail, Long> {

}