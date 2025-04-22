package dowlath.io.controller;

import dowlath.io.common.CustomerOrderDTO;
import dowlath.io.common.OrderRequest;
import dowlath.io.entity.Customer;
import dowlath.io.service.OrderFulfillmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecom")
public class OrderFulfillmentController {

    @Autowired
    private OrderFulfillmentService orderFulfillmentService;

    @PostMapping("/addOrder")
    public Customer addOrder(@RequestBody OrderRequest<Customer> orderRequest) {
        return orderFulfillmentService.createOrder(orderRequest);
    }

    @GetMapping("/orderCount")
    public List<Object[]> getCustomerOrderCount() {
        return orderFulfillmentService.findCustomerOrderCount();
    }

    @GetMapping("/orderCount/response")
    public List<CustomerOrderDTO> getCustomerOrderCountResponse() {
        return orderFulfillmentService.findCustomerOrderCountResponse();
    }
}
