package yunsinsa.yunsinsashop.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yunsinsa.yunsinsashop.domain.entity.Order;
import yunsinsa.yunsinsashop.domain.entity.OrderDetail;
import yunsinsa.yunsinsashop.domain.service.OrderDetailService;
import yunsinsa.yunsinsashop.domain.service.OrderService;
import yunsinsa.yunsinsashop.presentation.dto.OrderDto;

import java.util.List;

@RequiredArgsConstructor // final붙은거 생성자 만들어줌
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    @PostMapping   // 주문생성
    public void createOrder(@RequestBody OrderDto.CreateRequest request){
        orderService.create(request);
    }

    @GetMapping("/{id}") // 선택주문 조회
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")  //전체주문조회
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // OrderDetail !!!!!
    @GetMapping("/{orderDetailId}") // 아이디 선택하여 상세조회
    public OrderDetail getOrderDetailById(@PathVariable Long orderDetailId) {
        return orderDetailService.getOrderDetailById(orderDetailId);
    }


}
