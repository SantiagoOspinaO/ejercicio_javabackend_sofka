package org.sofka.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cyclist")
@NoArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cyc_id", nullable = false)
    private String id;

    @Column(name = "cyc_full_name")
    private String fullName;

    @Column(name = "cyc_competitor_number")
    private int competitorNumber;

    @ManyToOne
    @Column(name = "cyc_team_code", length = 3)
    private Team teamCode;

    @ManyToOne
    @JoinColumn(name = "cyc_country")
    private Country country;
}
