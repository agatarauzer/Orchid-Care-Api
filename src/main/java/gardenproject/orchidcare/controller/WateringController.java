package gardenproject.orchidcare.controller;

import gardenproject.orchidcare.domain.Watering;
import gardenproject.orchidcare.domain.WateringDto;
import gardenproject.orchidcare.mapper.WateringMapper;
import gardenproject.orchidcare.service.WateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/orchid-care")
public class WateringController {

    @Autowired
    private WateringService wateringService;

    @Autowired
    private WateringMapper wateringMapper;

    @GetMapping(value = "/watering")
    public List<WateringDto> getWateringList() {
        List<Watering> wateringList = wateringService.getFullWateringList();
        return wateringMapper.mapToWateringListDtos(wateringList);
    }
}
