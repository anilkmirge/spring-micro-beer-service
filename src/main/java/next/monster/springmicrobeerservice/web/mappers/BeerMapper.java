package next.monster.springmicrobeerservice.web.mappers;

import next.monster.springmicrobeerservice.domain.Beer;
import next.monster.springmicrobeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

  BeerDto beerToBeerDto(Beer beer);
  Beer beerDtoToBeer(BeerDto dto);

}
