package gardenproject.orchidcare.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORCHID_WATERING")
@NoArgsConstructor
@Getter
public class Watering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "WATERING_ID" , unique = true)
    private Long id;

    @Column(name ="DATE")
    @NotNull
    private String date;

    @Column(name = "FERTILIZER")
    private boolean withFertilizer;

    @Column(name = "USER_NOTES")
    private String userNotes;

    @ManyToOne
    @JoinColumn(name = "ORCHID_ID", nullable = false)
    private Orchid orchid;
}
