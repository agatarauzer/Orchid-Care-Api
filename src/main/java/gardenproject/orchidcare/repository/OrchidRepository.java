package gardenproject.orchidcare.repository;

import gardenproject.orchidcare.domain.Orchid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrchidRepository extends CrudRepository<Orchid, Long> {

    @Override
    List<Orchid> findAll();
}
