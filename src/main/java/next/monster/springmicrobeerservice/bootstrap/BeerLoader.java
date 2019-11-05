package next.monster.springmicrobeerservice.bootstrap;

import java.math.BigDecimal;
import next.monster.springmicrobeerservice.domain.Beer;
import next.monster.springmicrobeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerLoader implements CommandLineRunner {

  private final BeerRepository beerRepository;

  public BeerLoader(BeerRepository beerRepository) {
    this.beerRepository = beerRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    loadBeerObjects();
  }

  private void loadBeerObjects() {
    if (beerRepository.count() == 0) {
      beerRepository.save(Beer.builder()
              .beerName("Mango Bobs")
              .beerStyle("IPA")
              .price(new BigDecimal(12.05))
              .minOnHand(14)
              .quantityToBrew(200)
              .upc(3370100001L)
              .build());

      beerRepository.save(Beer.builder()
              .beerName("Galaxy Cat")
              .beerStyle("PALE ALE")
              .price(new BigDecimal(10.95))
              .minOnHand(14)
              .quantityToBrew(200)
              .upc(3370100002L)
              .build());
    }
  }
}
