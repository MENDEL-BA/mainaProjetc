package com.institution.school.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.institution.school.models.Room;
import com.institution.school.models.Teacher;

import java.util.ArrayList;
import java.util.Collection;

public class TeacherDTO {
    private Long id;
    private String name;
    private Collection<Room> rooms = new ArrayList<>();

    TeacherDTO(Teacher teacher){
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.rooms = teacher.getRooms();
    }
    TeacherDTO(Long id, String name, Collection<Room> rooms){
        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }

    @JsonIgnore
    public Teacher getTeacherDTOInstance() {
        return new Teacher(
                this.id,
                this.name,
                this.rooms
        );
    }
}
