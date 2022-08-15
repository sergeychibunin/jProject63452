package com.storeexample.demo.controllers.requests;

import lombok.Data;

@Data
public class PurchaseOrderPositionRequest {

    private Long order;
    private Long rssfeed;
}
