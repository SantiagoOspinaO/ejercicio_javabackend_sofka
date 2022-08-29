package org.sofka.model;

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
    private int id;

    @Column(name = "cyc_full_name", nullable = false)
    private String fullName;

    @Column(name = "cyc_competitor_number", length = 3, nullable = false, unique = true)
    private int competitorNumber;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team teamCode;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}
