package com.wallstreet.ecommerce.repository;

import com.wallstreet.ecommerce.domain.dto.SaleSummary;
import com.wallstreet.ecommerce.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT SUM(s.amount) FROM Sale s WHERE s.date = :date")
    BigDecimal findTotalSaleAmountByDate(LocalDate date);

    @Query("SELECT NEW com.wallstreet.ecommerce.domain.dto.SaleSummary(s.date, SUM(s.amount)) " +
            "FROM Sale s " +
            "WHERE s.date BETWEEN :startDate AND :endDate " +
            "GROUP BY s.date " +
            "ORDER BY SUM(s.amount) DESC")
    List<SaleSummary> findMaxSaleDayInRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query("SELECT s.item, SUM(s.amount) as totalAmount FROM Sale s GROUP BY s.item ORDER BY totalAmount DESC")
    List<Object[]> findTopSellingItems();

    @Query("SELECT s.item, COUNT(s) as salesCount FROM Sale s WHERE s.date >= :startDate AND s.date < :endDate GROUP BY s.item ORDER BY salesCount DESC")
    List<Object[]> findTopSellingItemsInLastMonth(LocalDate startDate, LocalDate endDate);
}
