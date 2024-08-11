package com.spring_cloud.eureka.client.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String name;

    @OneToMany(mappedBy = "order")
    private List<OrderProductMapping> orderProductMappings = new ArrayList<>();



}
