package gardenproject.orchidcare.mapper;

import gardenproject.orchidcare.domain.Orchid;
import gardenproject.orchidcare.domain.OrchidDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Component
public class OrchidMapper {

    public Orchid mapToOrchid(OrchidDto orchidDto) {
        return new Orchid(orchidDto.getId(),
                orchidDto.getName(),
                orchidDto.getColor(),
                orchidDto.getGroup(),
                orchidDto.getKind(),
                orchidDto.getCultivar(),
                orchidDto.getBuyDate(),
                orchidDto.getPlantWatering(),
                orchidDto.getPlantTransplanting());
    }

    public OrchidDto mapToOrchidDto(Orchid orchid) {
        return new OrchidDto(orchid.getId(),
                orchid.getName(),
                orchid.getColor(),
                orchid.getGroup(),
                orchid.getKind(),
                orchid.getCultivar(),
                orchid.getBuyDate(),
                orchid.getPlantWatering(),
                orchid.getPlantTransplanting());
    }

    public List<OrchidDto> mapToOrchidsDtosList(List<Orchid> orchids) {
        return orchids.stream()
                .map(orchid -> new OrchidDto(
                        orchid.getId(),
                        orchid.getName(),
                        orchid.getColor(),
                        orchid.getGroup(),
                        orchid.getKind(),
                        orchid.getCultivar(),
                        orchid.getBuyDate(),
                        orchid.getPlantWatering(),
                        orchid.getPlantTransplanting())
                        )
                .collect(Collectors.toList());
    }
}
