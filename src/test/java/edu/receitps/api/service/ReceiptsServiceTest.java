package edu.receitps.api.service;

import edu.receitps.api.dto.Receipt;
import edu.receitps.api.service.ReceiptsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReceiptsServiceTest {

    @Mock
    private ReceiptsService receiptsService;

    @Test
    public void mock_receipts_service() {
        when(receiptsService.getReceipts(anyString(), anyInt())).thenReturn(List.of(new Receipt("Walmart")));
        assertThat("Size of receitps is greater than zero", receiptsService.getReceipts("monthname", 2005).size() > 0);
    }
}
