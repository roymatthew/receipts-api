package edu.receitps.api;

import edu.receitps.api.dto.Receipt;

public interface DateMatcher {

    boolean matchDateCriteria(Receipt receipt, String date);
}
