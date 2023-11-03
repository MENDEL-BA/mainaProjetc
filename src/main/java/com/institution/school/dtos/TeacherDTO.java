package com.institution.school.dtos;

import com.institution.school.models.Room;

import java.util.ArrayList;
import java.util.Collection;

public class TeacherDTO {
    private Long id;
    private String name;
    private Collection<Room> rooms = new ArrayList<>();
}
