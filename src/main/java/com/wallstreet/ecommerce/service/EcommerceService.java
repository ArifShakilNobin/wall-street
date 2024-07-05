package com.wallstreet.ecommerce.service;

import com.wallstreet.ecommerce.domain.dto.SaleSummary;
import com.wallstreet.ecommerce.domain.entity.Item;
import com.wallstreet.ecommerce.domain.entity.Wishlist;
import com.wallstreet.ecommerce.repository.SaleRepository;
import com.wallstreet.ecommerce.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EcommerceService {

    private static final Logger logger = LoggerFactory.getLogger(EcommerceService.class);

    private final WishlistRepository wishlistRepository;
    private final SaleRepository saleRepository;


    public List<Wishlist> getCustomerWishlist(Long customerId) {
        if (customerId == null) {
            log.error("Customer ID cannot be null");
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        log.info("Retrieving wishlist for customer {}", customerId);
        return wishlistRepository.findByCustomerId(customerId);
    }


    public BigDecimal getTotalSaleAmountOfCurrentDay(LocalDate date) {
        if (date == null) {
            log.error("Date cannot be null");
            throw new IllegalArgumentException("Date cannot be null");
        }
        log.info("Retrieving total sale amount for date {}", date);
        return saleRepository.findTotalSaleAmountByDate(date);
    }

    public List<SaleSummary> getMaxSaleDayInRange(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            log.error("Start date and end date cannot be null");
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        log.info("Retrieving max sale day for date range {} to {}", startDate, endDate);
        return saleRepository.findMaxSaleDayInRange(startDate, endDate);
    }

    public List<Item> getTopSellingItems() {
        log.info("Retrieving top selling items");
        return saleRepository.findTopSellingItems().stream()
                .map(record -> (Item) record[0])
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Item> getTopSellingItemsInLastMonth(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            log.error("Start date and end date cannot be null");
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        log.info("Retrieving top selling items for date range {} to {}", startDate, endDate);
        return saleRepository.findTopSellingItemsInLastMonth(startDate, endDate).stream()
                .map(record -> (Item) record[0])// Assuming item is the first element in the Object[]
                .limit(5)
                .collect(Collectors.toList());
    }


}
