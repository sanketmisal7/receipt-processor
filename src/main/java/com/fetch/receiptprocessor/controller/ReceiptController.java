package com.fetch.receiptprocessor.controller;

import com.fetch.receiptprocessor.dto.ReceiptResponse;
import com.fetch.receiptprocessor.dto.PointsResponse;
import com.fetch.receiptprocessor.model.Receipt;
import com.fetch.receiptprocessor.service.ReceiptService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/process")
    public ReceiptResponse processReceipt(@RequestBody Receipt receipt) {
        return receiptService.processReceipt(receipt);
    }

    @GetMapping("/{id}/points")
    public PointsResponse getPoints(@PathVariable String id) {
        return receiptService.getPoints(id);
    }
}
