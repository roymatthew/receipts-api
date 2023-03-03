package edu.receitps.api.service;

import edu.receitps.api.FakeReceiptsDB;
import edu.receitps.api.dto.Receipt;
import edu.receitps.api.exception.ReceiptNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptsServiceImpl implements ReceiptsService {

    @Override
    public List<Receipt> getReceipts(String monthname, int year) throws ReceiptNotFoundException {
        return null;
    }

    @Override
    public Receipt getReceipt(String provider, String theDate) throws ReceiptNotFoundException {
//        Receipt receipt = this.receiptsRepository.findByProviderAndDate(provider, theDate);
//        if (receipt == null) {
//            throw new ReceiptNotFoundException();
//        }
//        return receipt;
        return null;
    }

    @Override
    public List<Receipt> getReceipt(String provider) throws ParseException {
        return FakeReceiptsDB.getAll().stream()
                .filter(r->r.getReceiptsProviderName().equalsIgnoreCase(provider))
                .collect(Collectors.toList());
    }
}
