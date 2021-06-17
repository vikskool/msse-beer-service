package com.springframework.mssebeerservice.services;


import com.springframework.mssebeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto createNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteBeerById(UUID beerId);

    BeerDto getBeerByUpc(Long upc);
}
