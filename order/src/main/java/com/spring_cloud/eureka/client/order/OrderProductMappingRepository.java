package com.spring_cloud.eureka.client.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductMappingRepository extends JpaRepository<OrderProductMapping, Long> {
}
