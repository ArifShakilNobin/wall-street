package com.wallstreet.ecommerce;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
class EcommerceApplicationTests {

    private final MockMvc mockMvc;

    @Test
    public void testGetWishlist() throws Exception {
        mockMvc.perform(get("/api/wishlist/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetTotalSaleAmountOfCurrentDay() throws Exception {
        mockMvc.perform(get("/api/sales/today"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetMaxSaleDayInRange() throws Exception {
        mockMvc.perform(get("/api/sales/max-day?startDate=2023-06-01&endDate=2023-06-30"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTopSellingItems() throws Exception {
        mockMvc.perform(get("/api/sales/top-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetTopSellingItemsInLastMonth() throws Exception {
        mockMvc.perform(get("/api/sales/top-items-last-month"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


}
