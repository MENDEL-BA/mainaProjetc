package com.institution.school.dtos;

import com.institution.school.models.Room;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Getter
@Setter
public class TeacherDTO implements Serializable {
    private Long id;
    private String name;
    private Set<Room> rooms = new HashSet<>();
}
