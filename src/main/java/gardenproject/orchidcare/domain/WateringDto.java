package gardenproject.orchidcare.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class WateringDto {

    private Long id;
    private LocalDate date;
    private boolean withFertilizer;
    private String userNotes;
    private Orchid orchid;

}
