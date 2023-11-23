package yunsinsa.yunsinsashop.domain.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yunsinsa.yunsinsashop.domain.entity.OrderDetail;
import yunsinsa.yunsinsashop.domain.repository.OrderDetailRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true) //읽기로만 가능하게 함
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;


    public List<OrderDetail> getAllOrderDetails() {  //전체 상세조회
        return orderDetailRepository.findAll();
    }


    public OrderDetail getOrderDetailById(Long orderDetailId) {  // 아이디선택하여 상세조회
        return orderDetailRepository.findById(orderDetailId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OrderDetailId"));
    }



}
