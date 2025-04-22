package dowlath.io.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {
    @Id
    private Long id;
    private String name;
    private int qty;
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}