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

    @Column(name = "cou_name")
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<Cyclist> cyclists;
}
