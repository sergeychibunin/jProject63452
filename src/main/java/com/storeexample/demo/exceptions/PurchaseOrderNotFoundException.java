package com.storeexample.demo.exceptions;

public class PurchaseOrderNotFoundException extends RuntimeException {

    public PurchaseOrderNotFoundException(Long id) {
        super("Could not find PurchaseOrder " + id);
    }
}
