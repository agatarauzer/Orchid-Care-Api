package gardenproject.orchidcare.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "ORCHID_WATERING")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Watering {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "WATERING_ID" , unique = true)
    private Long id;

    @Column(name ="DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "FERTILIZER")
    private boolean withFertilizer;

    @Column(name = "USER_NOTES")
    private String userNotes;

    @ManyToOne
    @JoinColumn(name = "ORCHID_ID", nullable = false)
    private Orchid orchid;

    public Watering(@NotNull LocalDate date, boolean withFertilizer, String userNotes) {
        this.date = date;
        this.withFertilizer = withFertilizer;
        this.userNotes = userNotes;
    }
}
