package edu.receitps.api.service;

import edu.receitps.api.dto.Receipt;
import edu.receitps.api.exception.ReceiptNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class ReceiptServiceNoSpringTest {
//
//    @Mock
//    private ReceiptsRepository receiptsRepository;
//
//    private ReceiptsService receiptsService;
//
//    @BeforeEach
//    public void setUp() {
//        receiptsService = new ReceiptsServiceImpl(receiptsRepository);
//    }
//
//    @Test
//    public void getReceipts_returns_receipts_for_given_provider_and_date() {
//        given(receiptsRepository.findByProviderAndDate(anyString(), anyString())).willReturn(new Receipt("Walmart"));
//        Receipt receipt = receiptsService.getReceipt("Walmart", "01012005");
//        assertThat(receipt.getReceiptsProviderName().equalsIgnoreCase("walmart"));
//    }
//
//    @Test
//    public void getReceipts_throws_ReceiptNotFoundException() {
//        given(receiptsRepository.findByProviderAndDate(anyString(), anyString())).willThrow(new ReceiptNotFoundException());
//        //Receipt receipt = receiptsService.getReceipt("Walmart", "01012005");
//        ReceiptNotFoundException thrown = Assertions.assertThrows(ReceiptNotFoundException.class, () -> {
//            receiptsService.getReceipt("Walmart", "01012005");
//        }, "Exception expected");
//        assertThat(thrown.getClass().getName().equalsIgnoreCase("ReceiptNotFoundException"));
//    }
}
