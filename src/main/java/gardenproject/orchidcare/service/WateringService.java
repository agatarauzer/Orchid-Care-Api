package gardenproject.orchidcare.service;

import gardenproject.orchidcare.domain.Watering;
import gardenproject.orchidcare.repository.WateringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WateringService {

    @Autowired
    private WateringRepository wateringRepository;


    public List<Watering> getFullWateringList() {
        return wateringRepository.findAll();
    }
}
