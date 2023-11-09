package com.institution.school.services;


import com.institution.school.dtos.TeacherDTO;
import com.institution.school.models.Room;
import com.institution.school.models.Teacher;

public interface RoomService {
    Room addTeacherToRoom(Long roomId, Teacher teacher);
    Room removeTeacherFromRoom(Long roomId, Teacher teacher);
}
