package com.springframework.mssebeerservice.services;


import com.springframework.mssebeerservice.repositories.BeerRepository;
import com.springframework.mssebeerservice.web.model.BeerDto;
import com.springframework.mssebeerservice.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .build();
    }

    @Override
    public BeerDto createNewBeer(BeerDto beerDto) {
        return beerRepository.save(beerDto);
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        return;
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Deleting beer with id "+ beerId);
    }

    @Override
    public BeerDto getBeerByUpc(Long upc){
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .upc(upc)
                .build();
    }


}
