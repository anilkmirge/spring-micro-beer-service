package next.monster.springmicrobeerservice.repositories;

import java.util.UUID;
import next.monster.springmicrobeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
