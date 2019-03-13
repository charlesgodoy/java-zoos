package com.lambdaschool.javazoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    @Column(nullable = false)
    private String zooname;

    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoos")
    private Set<Telephone> telephones  = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "zooanimals",
        joinColumns = {@JoinColumn(name = "zooid")},
        inverseJoinColumns = {@JoinColumn(name = "animalid")})
    private Set<Animal> animals;

    public Zoo() {
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public Set<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(Set<Telephone> telephones) {
        this.telephones = telephones;
    }
}
