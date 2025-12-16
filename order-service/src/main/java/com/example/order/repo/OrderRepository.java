
package com.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
