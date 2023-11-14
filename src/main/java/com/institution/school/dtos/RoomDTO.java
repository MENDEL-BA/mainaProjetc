package com.institution.school.dtos;

import com.institution.school.models.Session;
import com.institution.school.models.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class RoomDTO implements Serializable {
    private Long id;
    private String name;
    private Set<Teacher> teachers;
    private Set<Session> sessions = new HashSet<>();
}
