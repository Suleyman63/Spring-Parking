package com.example.demo.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerFirstname;
    private String customerLastname;
    private String customerPlate;
    private String customerEmail;
    private String customerPhone;
    private String customerPassword;


}
