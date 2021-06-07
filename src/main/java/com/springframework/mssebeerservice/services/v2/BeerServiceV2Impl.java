package com.springframework.mssebeerservice.services.v2;



import com.springframework.mssebeerservice.web.model.v2.BeerDtoV2;
import com.springframework.mssebeerservice.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2{
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.LAGER)
                .build();
    }

    @Override
    public BeerDtoV2 createNewBeer(BeerDtoV2 beerDtoV2) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Deleting beer with id "+ beerId);
    }
}
