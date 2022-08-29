package org.sofka.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "country")
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cou_id", nullable = false)
    private int id;

    @Column(name = "cou_name", nullable = false)
    private String name;

    @Column(name = "cou_code", length=5, nullable=false, unique=true)
    private String code;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Cyclist> cyclists;
}
