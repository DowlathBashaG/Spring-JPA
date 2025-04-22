package dowlath.io.service;

import dowlath.io.common.CustomerOrderDTO;
import dowlath.io.common.OrderRequest;
import dowlath.io.entity.Customer;
import dowlath.io.repository.CustomerRepository;
import dowlath.io.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFulfillmentService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Customer createOrder(OrderRequest orderRequest) {
        Customer customer= (Customer) orderRequest.getCustomer();
        customer.getOrders().forEach(c->c.setCustomer(customer));
        return customerRepository.save(customer);
    }


    public List<Object[]> findCustomerOrderCount() {
        return customerRepository.findCustomerOrderCount();
    }

    public List<CustomerOrderDTO> findCustomerOrderCountResponse() {
        return customerRepository.findCustomerOrderCountResponse();
    }
}
