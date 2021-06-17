package com.springframework.mssebeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.mssebeerservice.bootstrap.BeerLoader;
import com.springframework.mssebeerservice.services.BeerService;
import com.springframework.mssebeerservice.web.model.BeerDto;
import com.springframework.mssebeerservice.web.model.BeerStyleEnum;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    @SneakyThrows
    void getBeerById() {
        this.mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void createNewBeer() {
        BeerDto beerDto = getValidBeerDto();
        String beetDtoJson = this.objectMapper.writeValueAsString(beerDto);

        given(beerService.createNewBeer(any())).willReturn(getValidBeerDto());

        this.mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beetDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    @SneakyThrows
    void updateBeerById() {
        BeerDto beerDto = getValidBeerDto();
        String beetDtoJson = this.objectMapper.writeValueAsString(beerDto);

        this.mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON).content(beetDtoJson))
                .andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    void getBeerByUpc() {
        this.mockMvc.perform(get("/api/v1/beer/upc/" + Long.valueOf(10))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    BeerDto getValidBeerDto(){
        return BeerDto.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(Long.valueOf(BeerLoader.BEER_1_UPC))
                .build();
    }
}