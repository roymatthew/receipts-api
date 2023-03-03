package edu.receitps.api.controller;

import edu.receitps.api.exception.ReceiptNotFoundException;
import edu.receitps.api.service.ReceiptsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReceiptsController.class)
public class ReceiptsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReceiptsService receiptsService;

    @Test
    public void getReceipt_should_return_receipt() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/receipts/walmart/01012005"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("receiptsProviderName").value("Walmart"));

    }

    @Test
    public void getReceipt_must_throw_ReceiptNotFoundException() throws Exception {
        //given(receiptsService.getReceipts(anyString(), anyInt())).willThrow
        when(receiptsService.getReceipt(anyString(), anyString())).thenThrow(new ReceiptNotFoundException());
        mockMvc.perform(MockMvcRequestBuilders.get("/receipts/walmart/01012005"))
                .andExpect(status().isNotFound());

    }
}
