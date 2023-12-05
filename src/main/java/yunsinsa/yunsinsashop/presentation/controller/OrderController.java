package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.entity.OrderDetail;
import yunsinsa.yunsinsashop.domain.service.OrderDetailService;
import yunsinsa.yunsinsashop.domain.service.OrderService;
import yunsinsa.yunsinsashop.presentation.dto.OrderDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    /**
     *  주문 생성
     *
     */
    @PostMapping
    public void createOrder(@RequestBody OrderDto.CreateRequest request) {
        orderService.create(request);
    }

    /**
     *  선택 주문 조회
     * @param id 선택할 주문의 아이디
     *
     */
    @GetMapping("/{id}")
    public OrderDto.FindResponse getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    /**
     *  전체 주문 조회
     *
     */
    @GetMapping("/all")
    public List<OrderDto.FindResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     *  주문 상세 조회
     * @param orderDetailId 상세조회할 아이디
     *
     */
    @GetMapping("/{orderDetailId}")
    public OrderDetail getOrderDetailById(@PathVariable Long orderDetailId) {
        return orderDetailService.getOrderDetailById(orderDetailId);
    }
}
