package com.fetch.receiptprocessor.utils;

import com.fetch.receiptprocessor.model.Item;
import com.fetch.receiptprocessor.model.Receipt;

import java.time.LocalTime;
import java.util.List;

public class PointsCalculator {

    public static int calculatePoints(Receipt receipt) {
        int points = 0;

        // One point for every alphanumeric character in the retailer name.
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        // 50 points if the total is a round dollar amount.
        double total = Double.parseDouble(receipt.getTotal());
        if (total == Math.floor(total)) points += 50;

        // 25 points if total is multiple of 0.25
        if (total % 0.25 == 0) points += 25;

        // 5 points for every two items
        List<Item> items = receipt.getItems();
        points += (items.size() / 2) * 5;

        // If item description length is multiple of 3, add 20% of price rounded up
        for (Item item : items) {
            if (item.getShortDescription().length() % 3 == 0) {
                points += Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
            }
        }

        // 6 points if purchase day is odd
        int day = Integer.parseInt(receipt.getPurchaseDate().split("-")[2]);
        if (day % 2 != 0) points += 6;

        // 10 points if purchase time is between 2:00 PM and 4:00 PM
        LocalTime time = LocalTime.parse(receipt.getPurchaseTime());
        if (time.isAfter(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(16, 0))) {
            points += 10;
        }

        return points;
    }
}
