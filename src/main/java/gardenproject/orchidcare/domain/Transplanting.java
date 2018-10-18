package gardenproject.orchidcare.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "ORCHID_TRANSPLANTING")
@NoArgsConstructor
@Getter
public class Transplanting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TRANSPLANTING_ID")
    private Long id;

    @Column(name = "DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "USER_NOTES")
    private String userNotes;

    @ManyToOne
    @JoinColumn(name = "ORCHID_ID", nullable = false)
    private Orchid orchid;
}
