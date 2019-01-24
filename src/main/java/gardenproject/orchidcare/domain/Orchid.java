package gardenproject.orchidcare.domain;


import gardenproject.orchidcare.validator.Enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORCHIDS")
public class Orchid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ORCHID_ID" , unique = true)
    private Long id;

    @Column(name = "NAME_FROM_USER", unique = true)
    @NotNull
    private String name;

    @Column(name = "COLOR")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "BASE_GROUP")
    private BaseGroup group;

    @Enumerated(EnumType.STRING)
    @Column(name = "KIND")
    private Kind kind;

    @Column(name = "CULTIVAR")
    private String cultivar;

    @Column(name = "BUY_DATE")
    private LocalDate buyDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Watering.class, mappedBy = "orchid")
    private List<Watering> plantWatering;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Transplanting.class, mappedBy = "orchid")
    private List<Transplanting> plantTransplanting;

}
