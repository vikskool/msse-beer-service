package com.springframework.mssebeerservice.web.controller;

import com.springframework.mssebeerservice.services.BeerService;
import com.springframework.mssebeerservice.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createBeerEntry(@RequestBody BeerDto beerDto){
        BeerDto savedBeerDto = beerService.createNewBeer(beerDto);
        HttpHeaders httpHeader = new HttpHeaders();
        //TODO: add hostname to url
        httpHeader.add("Location","/api/v1/beer/"+savedBeerDto.getId().toString());
        return new ResponseEntity(httpHeader, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeerById(beerId);
    }


}
