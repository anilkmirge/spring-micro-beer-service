package next.monster.springmicrobeerservice.web.controller;

import next.monster.springmicrobeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class BeerController {

  @GetMapping("beer/{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {
    //todo impl
    return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
  }

  @PostMapping(path = "beer")
  public ResponseEntity<BeerDto> saveNewBeer(@Validated @RequestBody BeerDto beer) {
    //todo impl
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("beer/{beerId}")
  public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId,
      @Validated @RequestBody BeerDto beer) {
    //todo impl
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


}
