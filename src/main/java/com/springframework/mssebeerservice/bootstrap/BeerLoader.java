package com.springframework.mssebeerservice.bootstrap;

import com.springframework.mssebeerservice.repositories.BeerRepository;
import com.springframework.mssebeerservice.web.domain.Beer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.beerRepository.count() == 0){
            loadBeerData();
        }
    }

    private void loadBeerData(){
        beerRepository.save(Beer.builder()
                .beerName("Pale Ale")
                .beerStyle("IPA")
                .quantityToBrew(200)
                .minOrdered(200)
                .price(new BigDecimal(100))
                .upc(123456789L)
                .build());


        beerRepository.save(Beer.builder()
                .beerName("Galaxy_Cat")
                .beerStyle("PALE_ALE")
                .price(new BigDecimal(105))
                .quantityToBrew(400)
                .minOrdered(100)
                .upc(987654321L)
                .build());


        System.out.println("Loaded Beers :" + beerRepository.count());
    }
}
