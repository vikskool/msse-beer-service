package com.springframework.mssebeerservice.web.controller;

import com.springframework.mssebeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId){
        //todo impl
        return new ResponseEntity(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createNewBeer(@RequestBody BeerDto beerDto){
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //todo impl
    public void updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){

    }

    @GetMapping("/upc/{upcId}")
    public ResponseEntity getBeerByUpc(@PathVariable("upcId") Long upcId){
        //todo impl
        return new ResponseEntity(BeerDto.builder().build(), HttpStatus.OK);
    }


}
