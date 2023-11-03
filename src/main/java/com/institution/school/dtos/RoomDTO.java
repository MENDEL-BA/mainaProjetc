package com.institution.school.dtos;

import com.institution.school.models.Session;
import com.institution.school.models.Teacher;

import java.util.ArrayList;
import java.util.Collection;

public class RoomDTO {
    private Long id;
    private String name;
    private Collection<Teacher> teachers;
    private Collection<Session> sessions = new ArrayList<>();
}
