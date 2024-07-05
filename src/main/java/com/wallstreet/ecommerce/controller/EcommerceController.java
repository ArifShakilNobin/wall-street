package com.wallstreet.ecommerce.controller;

import com.wallstreet.ecommerce.domain.dto.SaleSummary;
import com.wallstreet.ecommerce.domain.entity.Item;
import com.wallstreet.ecommerce.domain.entity.Wishlist;
import com.wallstreet.ecommerce.service.EcommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EcommerceController {

    private final EcommerceService ecommerceService;


    @GetMapping("/wishlist/{customerId}")
    public List<Wishlist> getWishlist(@PathVariable Long customerId) {
        return ecommerceService.getCustomerWishlist(customerId);
    }

    @GetMapping("/sales/today")
    public BigDecimal getTotalSaleAmountOfCurrentDay() {
        return ecommerceService.getTotalSaleAmountOfCurrentDay(LocalDate.now());
    }

    @GetMapping("/sales/max-day")
    public List<SaleSummary> getMaxSaleDayInRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ecommerceService.getMaxSaleDayInRange(startDate, endDate);
    }

    @GetMapping("/sales/top-items")
    public List<Item> getTopSellingItems() {
        return ecommerceService.getTopSellingItems();
    }

    @GetMapping("/sales/top-items-last-month")
    public List<Item> getTopSellingItemsInLastMonth() {
        LocalDate startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate endDate = LocalDate.now().withDayOfMonth(1);
        return ecommerceService.getTopSellingItemsInLastMonth(startDate, endDate);
    }
}
