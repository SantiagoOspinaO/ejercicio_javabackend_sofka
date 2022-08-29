package org.sofka.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cyclists")
@NoArgsConstructor
public class Cyclist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cyc_id", nullable = false)
    private String id;

    @Column(name = "cyc_full_name", nullable = false)
    private String fullName;

    @Column(name = "cyc_competitor_number", nullable = false, unique = true)
    private int competitorNumber;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;
}
