package com.storeexample.demo.controllers.responses;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseOrderReport {

    private Date date;
    private String storeName;
    private Integer amount;
}
