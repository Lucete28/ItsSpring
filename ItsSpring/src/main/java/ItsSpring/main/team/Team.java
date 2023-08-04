package ItsSpring.main.team;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String name;
    private LocalDateTime createDate;
    @Column(columnDefinition = "TEXT")
    private String stack;
    @Column(length = 11)
    private String number;
    @Column(columnDefinition = "TEXT")
    private String profile;

}
