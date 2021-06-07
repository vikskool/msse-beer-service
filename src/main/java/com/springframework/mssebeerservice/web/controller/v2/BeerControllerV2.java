package com.springframework.mssebeerservice.web.controller.v2;

import com.springframework.mssebeerservice.services.v2.BeerServiceV2;
import com.springframework.mssebeerservice.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBeerEntry(@RequestBody BeerDtoV2 beerDtoV2){
        BeerDtoV2 savedBeerDtoV2 = beerServiceV2.createNewBeer(beerDtoV2);
        HttpHeaders httpHeader = new HttpHeaders();
        //TODO: add hostname to url
        httpHeader.add("Location","/api/v1/beer/"+savedBeerDtoV2.getId().toString());
        return new ResponseEntity(httpHeader, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDtoV2){
        beerServiceV2.updateBeer(beerId, beerDtoV2);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeerById(beerId);
    }
}