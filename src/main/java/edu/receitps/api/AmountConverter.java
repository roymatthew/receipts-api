package edu.receitps.api;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class AmountConverter {

    public static BigDecimal convertStringToBigDecimal(String amount) {
        try {
            if (StringUtils.hasLength(amount)) {
                return new BigDecimal(amount);
            }
        } catch (Exception e) {
            //do nothing
        }
        return BigDecimal.ZERO;
    }
}
