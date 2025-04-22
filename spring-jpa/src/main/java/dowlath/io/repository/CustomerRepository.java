package dowlath.io.repository;

import dowlath.io.common.CustomerOrderDTO;
import dowlath.io.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //join query
    @Query(value = "SELECT c.name , COUNT(o) FROM Customer c JOIN c.orders o GROUP BY c.id")
    List<Object[]> findCustomerOrderCount();

    @Query(value = "SELECT  NEW common.dowlath.io.CustomerOrderDTO(c.name , COUNT(o), SUM(o.price)) FROM Customer c JOIN c.orders o GROUP BY c.id")
    List<CustomerOrderDTO> findCustomerOrderCountResponse();

}
