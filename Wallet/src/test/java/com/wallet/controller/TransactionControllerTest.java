package com.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.model.Transaction;
import com.wallet.model.Wallet;
import com.wallet.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TransactionController.class)
public class TransactionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    TransactionService transactionService;

    @Test
    void testHandleTransaction() throws Exception {
        Wallet wallet = new Wallet(1123124451l,"wallet1",500);
        Transaction transaction=new Transaction(11234124l, "ADD",300,wallet);
        when(transactionService.handleTransactions(Mockito.any(Transaction.class))).thenReturn(transaction);
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(wallet))).andExpect(status().isCreated());
    }
}
