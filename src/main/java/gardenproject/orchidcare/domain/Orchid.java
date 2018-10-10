package gardenproject.orchidcare.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORCHIDS")
public class Orchid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ORCHID_ID" , unique = true)
    private Long id;

    @Column(name = "NAME_FROM_USER")
    @NotNull
    private String name;

    @Column(name = "BASE_GROUP")
    private String group;

    @Column(name = "KIND")
    private String kind;

    @Column(name = "CULTIVAR")
    private String cultivar;

    @Column(name = "BUY_DATE")
    private String buyDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Watering.class, mappedBy = "orchid")
    private List<Watering> plantWatering;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Transplanting.class, mappedBy = "orchid")
    private List<Transplanting> plantTransplanting;

}
