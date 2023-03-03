package edu.receitps.api;

import edu.receitps.api.dto.Receipt;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateMatcherImpl {

    DateMatcher matchByDay = ((receipt, date) -> {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Instant instant = receipt.getReceiptsDate().toInstant();
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String receiptDate = ldt.format(fmt);
        String[] predicateTokens = date.split("/");
        String[] actualTokens = receiptDate.split("/");
        return actualTokens[1].equalsIgnoreCase(predicateTokens[1]) ? true : false;
    });

    DateMatcher matchByMonth = ((receipt, date) -> {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Instant instant = receipt.getReceiptsDate().toInstant();
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String receiptDate = ldt.format(fmt);
        String[] predicateTokens = date.split("/");
        String[] actualTokens = receiptDate.split("/");
        return actualTokens[0].equalsIgnoreCase(predicateTokens[0]) ? true : false;
    });

    public static DateMatcher matchByYear = ((receipt, date) -> {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Instant instant = receipt.getReceiptsDate().toInstant();
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String receiptDate = ldt.format(fmt);
        String year = date;
        if (date.contains("/")){
            String[] predicateTokens = date.split("/");
            year = predicateTokens[2];
        }
        String[] actualTokens = receiptDate.split("/");
        return actualTokens[2].equalsIgnoreCase(year) ? true : false;
    });

    public static DateMatcher matchExact = ((receipt, date) -> {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Instant instant = receipt.getReceiptsDate().toInstant();
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        String receiptDate = ldt.format(fmt);
        return receiptDate.equalsIgnoreCase(date) ? true : false;
    });

    public boolean matchDate(Receipt receipt, String dateToMatch, DateMatcher dateMatcher) {
        return dateMatcher.matchDateCriteria(receipt, dateToMatch);
    }
}
