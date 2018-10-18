package gardenproject.orchidcare.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TransplantingDto {

    private Long id;
    private LocalDate date;
    private String userNotes;
    private Orchid orchid;

}
