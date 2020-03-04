package next.monster.springmicrobeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import next.monster.springmicrobeerservice.web.model.BeerDto;
import next.monster.springmicrobeerservice.web.model.BeerStyleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;
  @Test
  void getBeerById() throws Exception {
    mockMvc.perform(get("/api/v1/beer/" +
        UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void saveNewBeer() throws Exception {
    BeerDto newBeer = getValidBeer();
    String beerToJson = objectMapper.writeValueAsString(newBeer);

    mockMvc.perform(post("/api/v1/beer")
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerToJson))
        .andExpect(status().isCreated());
  }

  @Test
  void updateBeerById() throws Exception{
    BeerDto savedBeer = getValidBeer();
    String beerToJson = objectMapper.writeValueAsString(savedBeer);

    mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
        .contentType(MediaType.APPLICATION_JSON)
        .content(beerToJson))
        .andExpect(status().isNoContent());
  }

  BeerDto getValidBeer() {
    return BeerDto.builder()
        .beerName("My Custom Beer")
        .price(new BigDecimal("2.99"))
        .beerStyle(BeerStyleEnum.ALE)
        .upc(47234347L)
        .build();
  }
}
