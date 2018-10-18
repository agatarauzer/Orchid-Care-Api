package gardenproject.orchidcare.service;


import gardenproject.orchidcare.domain.Orchid;
import gardenproject.orchidcare.repository.OrchidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrchidService {

    @Autowired
    private OrchidRepository orchidRepository;

    public List<Orchid> getOrchidsList() {
        return orchidRepository.findAll();
    }

    public Optional<Orchid> getOrchidById(Long id) {
        return orchidRepository.findById(id);
    }

    public Orchid saveOrchid(Orchid orchid) {
        return orchidRepository.save(orchid);
    }

    public void deleteOrchid(Long id) {
        orchidRepository.deleteById(id);
    }
}
