package org.sofka.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teams")
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private int id;

    @Column(name = "team_name", nullable = false)
    private String name;

    @Column(name = "team_code", length = 3, nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "cyclingTeam", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cyclist> cyclists;
}
