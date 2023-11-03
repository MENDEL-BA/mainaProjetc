package com.institution.school.dtos;

import com.institution.school.models.Room;

import java.util.Collection;

public class SessionDTO {
    private Long id;
    private String code;
    private Collection<Room> rooms;
}
