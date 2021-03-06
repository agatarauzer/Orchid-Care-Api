package gardenproject.orchidcare.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrchidDto {

    private Long id;
    private String name;
    private String color;
    private BaseGroup group;
    private Kind kind;
    private String cultivar;
    private LocalDate buyDate;
    private List<Watering> plantWatering;
    private List<Transplanting> plantTransplanting;
}
