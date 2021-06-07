package com.springframework.mssebeerservice.services.v2;




import com.springframework.mssebeerservice.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 createNewBeer(BeerDtoV2 beerDtoV2);

    void updateBeer(UUID beerId, BeerDtoV2 beerDtoV2);

    void deleteBeerById(UUID beerId);
}
