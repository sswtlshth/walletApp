package com.wallet.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.model.Wallet;

import com.wallet.services.WalletService;
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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WalletControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private WalletService walletService;

    @Test
    void testGetAllWallets() throws Exception {
        List<Wallet> walletList = new ArrayList<Wallet>();
        walletList.add(new Wallet("wallet1",500));
        walletList.add(new Wallet("wallet2",100));
        when(walletService.getAllWallets()).thenReturn(walletList);
        mockMvc.perform(MockMvcRequestBuilders.get("/wallets")).andExpect(jsonPath("$",hasSize(2))).andDo(print());
    }

    @Test
    void testGetWallet() throws Exception {
        Wallet wallet= new Wallet("wallet1",500);
        when(walletService.getWallet(Mockito.any(String.class))).thenReturn(wallet);
        mockMvc.perform(MockMvcRequestBuilders.get("/wallets/wallet1")).andExpect(status().isOk());
    }

    @Test
    void addWallet() throws Exception {
        Wallet wallet = new Wallet("wallet3",200);
        when(walletService.addWallet(Mockito.any(Wallet.class))).thenReturn(wallet);
        mockMvc.perform(MockMvcRequestBuilders.post("/wallets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(wallet)))
                .andExpect(status().isCreated());
    }

}
