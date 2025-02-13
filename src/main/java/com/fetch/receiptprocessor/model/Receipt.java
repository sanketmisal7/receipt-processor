package com.fetch.receiptprocessor.model;

import java.util.List;

import lombok.Data;

@Data
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> items;
    private String total;
}
