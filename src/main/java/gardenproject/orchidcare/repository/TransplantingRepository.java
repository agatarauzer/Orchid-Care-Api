package gardenproject.orchidcare.repository;

import gardenproject.orchidcare.domain.Transplanting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransplantingRepository extends CrudRepository<Transplanting, Long> {

    @Override
    List<Transplanting> findAll();
}
