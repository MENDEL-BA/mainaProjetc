package com.institution.school.dtos;

import com.institution.school.models.Room;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class SessionDTO implements Serializable {
    private Long id;
    private String code;
    private Set<Room> rooms;
}
