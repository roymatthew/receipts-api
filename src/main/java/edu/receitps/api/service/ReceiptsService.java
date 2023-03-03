package edu.receitps.api.service;

import edu.receitps.api.dto.Receipt;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import edu.receitps.api.exception.ReceiptNotFoundException;

public interface ReceiptsService {
    List<Receipt> getReceipts(String monthname, int year) throws ReceiptNotFoundException;

    Receipt getReceipt(String provider, String theDate) throws ReceiptNotFoundException;

    List<Receipt> getReceipt(String provider) throws ParseException;
}
