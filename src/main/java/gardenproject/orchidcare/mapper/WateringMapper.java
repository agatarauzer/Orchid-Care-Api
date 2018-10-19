package gardenproject.orchidcare.mapper;


import gardenproject.orchidcare.domain.Watering;
import gardenproject.orchidcare.domain.WateringDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WateringMapper {

    public List<WateringDto> mapToWateringListDtos(List<Watering> wateringList) {
        return wateringList.stream()
                .map(watering -> new WateringDto(watering.getId(),
                        watering.getDate(),
                        watering.isWithFertilizer(),
                        watering.getUserNotes(),
                        watering.getOrchid()))
                .collect(Collectors.toList());
    }

    public Watering mapToWatering(WateringDto wateringDto) {
        return new Watering(wateringDto.getId(),
                wateringDto.getDate(),
                wateringDto.isWithFertilizer(),
                wateringDto.getUserNotes(),
                wateringDto.getOrchid());
    }

    public WateringDto mapToWateringDto(WateringDto watering) {
        return new WateringDto(watering.getId(),
                watering.getDate(),
                watering.isWithFertilizer(),
                watering.getUserNotes(),
                watering.getOrchid());
    }
}
