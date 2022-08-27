package org.sofka.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "team")
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private int id;

    @Column(name = "team_name")
    private String name;

    @Column(name = "team_code", length = 3)
    private String code;

    @ManyToOne
    @JoinColumn(name = "team_country")
    private Country country;

    @OneToMany(mappedBy = "teamCode", cascade = CascadeType.ALL)
    private List<Cyclist> cyclists;
}
