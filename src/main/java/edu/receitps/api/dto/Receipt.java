package edu.receitps.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private String receiptsProviderName;
    private BigDecimal totalAmount;
    private int numberOfItems;
    private Date receiptsDate;
    private List<ReceiptItem> items;


    public Receipt(String receiptsProviderName) {
        this.receiptsProviderName = receiptsProviderName;
    }
}
