package com.institution.school.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.Collection;
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "rooms", fetch = FetchType.EAGER)
    private Collection<Teacher> teachers;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.PERSIST})
    @JoinTable(name = "rooms_sessions", joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "session_id", referencedColumnName = "id"))
    private Collection<Session> sessions = new ArrayList<>();
}
