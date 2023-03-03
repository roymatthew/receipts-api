package edu.receitps.api.service;

import edu.receitps.api.DateMatcherImpl;
import edu.receitps.api.FakeReceiptsDB;
import edu.receitps.api.dto.Receipt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalInterfaceTest {

    DateMatcherImpl dateMatcherImpl;

    @BeforeEach
    public void setUp() {
        dateMatcherImpl = new DateMatcherImpl();
    }

    @Test
    public void first_test_to_practice_stream() throws ParseException {

        FakeReceiptsDB.getAll().stream().map(receipt -> receipt.getReceiptsProviderName().toUpperCase()).sorted().forEach(System.out::println);

    }

    @Test
    public void print_receipts_filter_by_year() throws ParseException {

        FakeReceiptsDB.getAll().stream().filter(receipt -> dateMatcherImpl.matchDate(receipt, "2005", DateMatcherImpl.matchByYear))
                .forEach(receipt -> {
                    System.out.println("Receipt provider: " + receipt.getReceiptsProviderName() + " Receipt Date: " + receipt.getReceiptsDate());
                });

    }

    @Test
    public void print_receipts_filter_by_year_full_date_pattern() throws ParseException {

        FakeReceiptsDB.getAll().stream().filter(receipt -> dateMatcherImpl.matchDate(receipt, "01/15/2005", DateMatcherImpl.matchByYear))
                .forEach(receipt -> {
                    System.out.println("Receipt provider: " + receipt.getReceiptsProviderName() + " Receipt Date: " + receipt.getReceiptsDate());
                });

    }

    @Test
    public void print_receipts_filter_by_full_date_pattern_exactMatch() throws ParseException {

        FakeReceiptsDB.getAll().stream().filter(receipt -> dateMatcherImpl.matchDate(receipt, "09/10/2015", DateMatcherImpl.matchExact))
                .forEach(receipt -> {
                    System.out.println("Receipt provider: " + receipt.getReceiptsProviderName() + " Receipt Date: " + receipt.getReceiptsDate());
                });

    }

    @Test
    public void print_receipt_items_using_flatmap() throws ParseException {

        //FakeReceiptsDB.getAll().filter(receipt -> matchByYear(receipt.getReceiptsDate(), "2005"));
        FakeReceiptsDB.getAll().stream().flatMap(receipt -> receipt.getItems().stream()).collect(Collectors.toList()).stream().map(receiptItem -> receiptItem.getItemName()).forEach(System.out::println);

    }

    @Test
    public void print_total_amount_From_all_receipts() throws ParseException {
        BigDecimal total = FakeReceiptsDB.getAll().stream().map(receipt -> receipt.getTotalAmount()).reduce((a, b) -> a.add(b)).orElse(BigDecimal.ZERO);
        assertThat(total.compareTo(BigDecimal.ZERO) > 0);
        System.out.println("Total of all receipts: " + total);

    }

}
