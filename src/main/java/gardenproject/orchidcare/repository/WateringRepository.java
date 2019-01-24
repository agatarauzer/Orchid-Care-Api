package gardenproject.orchidcare.repository;


import gardenproject.orchidcare.domain.Watering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WateringRepository extends CrudRepository<Watering, Long> {

    @Override
    List<Watering> findAll();
}
