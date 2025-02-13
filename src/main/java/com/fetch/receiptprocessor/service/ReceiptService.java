package com.fetch.receiptprocessor.service;

import com.fetch.receiptprocessor.dto.ReceiptResponse;
import com.fetch.receiptprocessor.dto.PointsResponse;
import com.fetch.receiptprocessor.model.Receipt;
import com.fetch.receiptprocessor.utils.PointsCalculator;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ReceiptService {
    private final ConcurrentHashMap<String, Integer> receiptStorage = new ConcurrentHashMap<>();

    public ReceiptResponse processReceipt(Receipt receipt) {
        String receiptId = UUID.randomUUID().toString();
        int points = PointsCalculator.calculatePoints(receipt);
        receiptStorage.put(receiptId, points);
        return new ReceiptResponse(receiptId);
    }

    public PointsResponse getPoints(String id) {
        return new PointsResponse(receiptStorage.getOrDefault(id, 0));
    }
}
