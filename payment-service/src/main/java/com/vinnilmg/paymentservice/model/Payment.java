package com.vinnilmg.paymentservice.model;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class Payment implements Serializable {

    private Long id;
    private Long userId;
    private Long productId;
    private String cardNumber;

}
